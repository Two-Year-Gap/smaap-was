package com.example.smaap.domain.region.service;

import com.example.smaap.domain.business.entity.Business;
import com.example.smaap.domain.business.entity.QStore;
import com.example.smaap.domain.business.entity.Store;
import com.example.smaap.domain.business.service.StoreService;
import com.example.smaap.domain.payment.entity.QCardPayment;
import com.example.smaap.domain.population.entity.QPopulation;
import com.example.smaap.domain.population.type.PopulationType;
import com.example.smaap.domain.region.entity.Neighborhood;
import com.example.smaap.domain.region.entity.QNeighborhood;
import com.example.smaap.domain.region.repository.NeighborhoodRepository;
import com.example.smaap.domain.region.type.PopularType;
import com.example.smaap.presentation.dto.NeighborhoodCountDTO;
import com.example.smaap.presentation.dto.RecommendedBusinessDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NeighborhoodService {
    private final NeighborhoodRepository neighborhoodRepository;
    private final StoreService storeService;
    private final JPAQueryFactory queryFactory;

    public List<Neighborhood> list() {
        return neighborhoodRepository.findAll();
    }

    public List<Neighborhood> list(Long districtId) {
        return neighborhoodRepository.findAllByDistrictId(districtId);
    }

    public List<NeighborhoodCountDTO.Response> list(PopularType type, Long count) {
        return switch (type) {
            case STORE -> findAllByStoreCount(count);
            case SALES -> findAllBySales(count);
            case FLOATING -> findAllByFloatingPopulation(count);
            case RESIDENT -> findAllByResidentPopulation(count);
            default -> throw new IllegalArgumentException("잘못된 정렬 기준입니다.");
        };
    }

    public Neighborhood read(Long id) {
        return neighborhoodRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 동입니다."));
    }

    public List<RecommendedBusinessDto.Response> recommendedBusinesses(Long id) {
        Neighborhood neighborhood = neighborhoodRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 동입니다."));

        List<Store> stores = storeService.list(neighborhood.getName());

        Map<Business, Long> businessCount = stores.stream()
                .collect(Collectors.groupingBy(Store::getBusiness, Collectors.counting()));

        long totalStores = businessCount.values().stream().mapToLong(count -> count).sum();

        return businessCount.entrySet().stream()
                .map(entry -> RecommendedBusinessDto.Response.of(
                        entry.getKey().getId(),
                        entry.getKey().getName(),
                        (double) entry.getValue() / totalStores * 100  // 퍼센트로 계산
                ))
                .sorted(Comparator.comparing(RecommendedBusinessDto.Response::getPercent).reversed())  // 내림차순 정렬
                .collect(Collectors.toList());
    }

    private List<NeighborhoodCountDTO.Response> findAllByStoreCount(Long count) {
        QNeighborhood neighborhood = QNeighborhood.neighborhood;
        QStore store = QStore.store;

        return queryFactory
                .select(Projections.constructor(NeighborhoodCountDTO.Response.class,
                        neighborhood.id,
                        neighborhood.name,
                        store.count()))
                .from(neighborhood)
                .leftJoin(store)
                .on(store.neighborhood.id.eq(neighborhood.id))
                .groupBy(neighborhood.id, neighborhood.name)
                .orderBy(store.count().desc())
                .limit(count)
                .fetch();
    }

    private List<NeighborhoodCountDTO.Response> findAllBySales(Long count) {
        QNeighborhood neighborhood = QNeighborhood.neighborhood;
        QCardPayment sales = QCardPayment.cardPayment;

        return queryFactory
                .select(Projections.constructor(NeighborhoodCountDTO.Response.class,
                        neighborhood.id,
                        neighborhood.name,
                        sales.totalAmount.sum()))
                .from(neighborhood)
                .leftJoin(sales)
                .on(sales.neighborhood.id.eq(neighborhood.id))
                .groupBy(neighborhood.id, neighborhood.name)
                .orderBy(sales.totalAmount.sum().desc())
                .limit(count)
                .fetch();
    }

    private List<NeighborhoodCountDTO.Response> findAllByFloatingPopulation(Long count) {
        QNeighborhood neighborhood = QNeighborhood.neighborhood;
        QPopulation population = QPopulation.population;

        NumberExpression<BigDecimal> sumAllHours = population.population00
                .add(population.population01)
                .add(population.population02)
                .add(population.population03)
                .add(population.population04)
                .add(population.population05)
                .add(population.population06)
                .add(population.population07)
                .add(population.population08)
                .add(population.population09)
                .add(population.population10)
                .add(population.population11)
                .add(population.population12)
                .add(population.population13)
                .add(population.population14)
                .add(population.population15)
                .add(population.population16)
                .add(population.population17)
                .add(population.population18)
                .add(population.population19)
                .add(population.population20)
                .add(population.population21)
                .add(population.population22)
                .add(population.population23);

        return queryFactory
                .select(Projections.constructor(NeighborhoodCountDTO.Response.class,
                        neighborhood.id,
                        neighborhood.name,
                        sumAllHours.sum().longValue()))
                .from(neighborhood)
                .leftJoin(population)
                .on(population.neighborhood.id.eq(neighborhood.id))
                .where(population.type.in(PopulationType.WORK, PopulationType.VISIT))
                .groupBy(neighborhood.id, neighborhood.name)
                .orderBy(sumAllHours.sum().desc())
                .limit(count)
                .fetch();
    }

    private List<NeighborhoodCountDTO.Response> findAllByResidentPopulation(Long count) {
        QNeighborhood neighborhood = QNeighborhood.neighborhood;
        QPopulation population = QPopulation.population;

        NumberExpression<BigDecimal> sumAllHours = population.population00
                .add(population.population01)
                .add(population.population02)
                .add(population.population03)
                .add(population.population04)
                .add(population.population05)
                .add(population.population06)
                .add(population.population07)
                .add(population.population08)
                .add(population.population09)
                .add(population.population10)
                .add(population.population11)
                .add(population.population12)
                .add(population.population13)
                .add(population.population14)
                .add(population.population15)
                .add(population.population16)
                .add(population.population17)
                .add(population.population18)
                .add(population.population19)
                .add(population.population20)
                .add(population.population21)
                .add(population.population22)
                .add(population.population23);

        return queryFactory
                .select(Projections.constructor(NeighborhoodCountDTO.Response.class,
                        neighborhood.id,
                        neighborhood.name,
                        sumAllHours.sum().longValue()))
                .from(neighborhood)
                .leftJoin(population)
                .on(population.neighborhood.id.eq(neighborhood.id))
                .where(population.type.in(PopulationType.HOME))
                .groupBy(neighborhood.id, neighborhood.name)
                .orderBy(sumAllHours.sum().desc())
                .limit(count)
                .fetch();
    }
}

package com.example.smaap.domain.region.service;

import com.example.smaap.domain.payment.entity.QCardPayment;
import com.example.smaap.domain.population.entity.QPopulation;
import com.example.smaap.domain.region.entity.Neighborhood;
import com.example.smaap.domain.region.entity.QNeighborhood;
import com.example.smaap.domain.region.repository.NeighborhoodRepository;
import com.example.smaap.presentation.dto.NeighborhoodCountDTO;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NeighborhoodService {
    private final NeighborhoodRepository neighborhoodRepository;
    private final JPAQueryFactory queryFactory;

    public List<Neighborhood> list() {
        return neighborhoodRepository.findAll();
    }

    public List<Neighborhood> list(Long districtId) {
        return neighborhoodRepository.findAllByDistrictId(districtId);
    }

    public List<NeighborhoodCountDTO.Response> list(String popularType) {
        switch (popularType) {
            case "store":
//                return findAllByStoreCount();
                throw new IllegalArgumentException("잘못된 정렬 기준입니다.");
            case "sales":
                return findAllBySales();
            case "floating":
                return findAllByFloatingPopulation();
            case "resident":
                return findAllByResidentPopulation();
            default:
                throw new IllegalArgumentException("잘못된 정렬 기준입니다.");
        }
    }

    public Neighborhood read(Long id) {
        return neighborhoodRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 동입니다."));
    }

//    private List<NeighborhoodCountDTO.Response> findAllByStoreCount() {
//        QNeighborhood neighborhood = QNeighborhood.neighborhood;
//        QStore store = QStore.store;
//
//        return queryFactory
//                .select(Projections.constructor(NeighborhoodCountDTO.Response.class,
//                        neighborhood.id,
//                        neighborhood.name,
//                        store.count()))
//                .from(neighborhood)
//                .leftJoin(store)
//                .on(store.neighborhood.id.eq(neighborhood.id))
//                .groupBy(neighborhood.id, neighborhood.name)
//                .orderBy(store.count().desc())
//                .fetch();
//    }

    private List<NeighborhoodCountDTO.Response> findAllBySales() {
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
                .fetch();
    }

    private List<NeighborhoodCountDTO.Response> findAllByFloatingPopulation() {
        QNeighborhood neighborhood = QNeighborhood.neighborhood;
        QPopulation population = QPopulation.population;

        return queryFactory
                .select(Projections.constructor(NeighborhoodCountDTO.Response.class,
                        neighborhood.id,
                        neighborhood.name,
                        population.floatingCount))
                .from(neighborhood)
                .leftJoin(population)
                .on(population.neighborhood.id.eq(neighborhood.id))
                .orderBy(population.floatingCount.desc())
                .fetch();
    }

    private List<NeighborhoodCountDTO.Response> findAllByResidentPopulation() {
        QNeighborhood neighborhood = QNeighborhood.neighborhood;
        QPopulation population = QPopulation.population;

        return queryFactory
                .select(Projections.constructor(NeighborhoodCountDTO.Response.class,
                        neighborhood.id,
                        neighborhood.name,
                        population.residentCount))
                .from(neighborhood)
                .leftJoin(population)
                .on(population.neighborhood.id.eq(neighborhood.id))
                .orderBy(population.residentCount.desc())
                .fetch();
    }

}

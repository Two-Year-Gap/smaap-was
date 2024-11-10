package com.example.smaap.application.population.service;

import com.example.smaap.application.population.dto.PopulationDto;
import com.example.smaap.domain.population.entity.Population;
import com.example.smaap.domain.population.service.PopulationService;
import com.example.smaap.domain.population.type.PopulationType;
import com.example.smaap.domain.region.entity.Neighborhood;
import com.example.smaap.domain.region.service.NeighborhoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PopulationStatisticService {
    private final PopulationService populationService;
    private final NeighborhoodService neighborhoodService;

    public PopulationDto.Response read(PopulationDto.Request dto) {
        Neighborhood neighborhood = neighborhoodService.read(dto.getNeighborhoodId());
        List<Population> populations = populationService.list(dto.getYear(), neighborhood);

        Map<PopulationType, BigDecimal> populationByType = populations.stream()
                .collect(Collectors.groupingBy(
                        Population::getType,
                        Collectors.mapping(
                                Population::calculateAveragePopulation,
                                Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
                        )
                ));

        return PopulationDto.Response.of(
                populationByType.getOrDefault(PopulationType.HOME, BigDecimal.ZERO),
                populationByType.getOrDefault(PopulationType.WORK, BigDecimal.ZERO),
                populationByType.getOrDefault(PopulationType.VISIT, BigDecimal.ZERO)
        );
    }
}

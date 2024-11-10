package com.example.smaap.domain.population.service;

import com.example.smaap.domain.population.entity.Population;
import com.example.smaap.domain.population.entity.QPopulation;
import com.example.smaap.domain.population.repository.PopulationRepository;
import com.example.smaap.domain.region.entity.Neighborhood;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PopulationService {
    private final PopulationRepository populationRepository;

    public List<Population> list(Integer year, Neighborhood neighborhood) {
        QPopulation qPopulation = QPopulation.population;
        BooleanBuilder builder = new BooleanBuilder();

        if (year != null) {
            builder.and(qPopulation.year.eq(year));
        }

        if (neighborhood != null) {
            builder.and(qPopulation.neighborhood.eq(neighborhood));
        }

        return (List<Population>) populationRepository.findAll(builder);
    }
}

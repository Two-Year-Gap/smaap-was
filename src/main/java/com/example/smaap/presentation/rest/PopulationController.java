package com.example.smaap.presentation.rest;

import com.example.smaap.application.population.dto.PopulationDto;
import com.example.smaap.application.population.service.PopulationStatisticService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/populations")
@Tag(name = "Population", description = "인구 통계 관련 API")
@RequiredArgsConstructor
public class PopulationController {
    private final PopulationStatisticService populationStatisticService;

    @GetMapping
    public PopulationDto.Response read(@RequestParam Integer year, @RequestParam(name = "neighborhood_id") Long neighborhoodId) {
        return populationStatisticService.read(PopulationDto.Request.builder()
                .year(year)
                .neighborhoodId(neighborhoodId)
                .build());
    }
}

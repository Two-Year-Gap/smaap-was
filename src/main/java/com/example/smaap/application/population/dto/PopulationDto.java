package com.example.smaap.application.population.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

public class PopulationDto {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "Population.Request", description = "인구 조회 요청 DTO")
    public static class Request {
        @Schema(description = "년도", example = "2021")
        private Integer year;
        @Schema(description = "동 고유번호", example = "1")
        private Long neighborhoodId;
    }

    @Getter
    @AllArgsConstructor
    @Schema(name = "Population.Response", description = "인구 조회 응답 DTO")
    public static class Response {
        @Schema(description = "거주 인구", example = "100")
        private BigDecimal homePopulation;

        @Schema(description = "근무 인구", example = "100")
        private BigDecimal workPopulation;

        @Schema(description = "방문 인구", example = "100")
        private BigDecimal visitPopulation;


        public static Response of(BigDecimal homePopulation, BigDecimal workPopulation, BigDecimal visitPopulation) {
            return new Response(homePopulation, workPopulation, visitPopulation);
        }
    }
}

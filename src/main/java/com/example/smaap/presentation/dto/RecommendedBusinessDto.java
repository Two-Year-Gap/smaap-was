package com.example.smaap.presentation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class RecommendedBusinessDto {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "RecommendedBusiness.Response", description = "유망 상권 응답 DTO")
    public static class Response {
        @Schema(description = "업종 고유번호", example = "1")
        private Long id;

        @Schema(description = "업종명", example = "요식업")
        private String name;
        @Schema(description = "비율", example = "29")
        private Double percent;

        public static Response of(Long id, String name, Double percent) {
            return new Response(id, name, percent);
        }
    }
}

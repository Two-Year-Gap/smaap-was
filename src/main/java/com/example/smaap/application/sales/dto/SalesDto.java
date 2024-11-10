package com.example.smaap.application.sales.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class SalesDto {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "Sales.Request", description = "매출 조회 요청 DTO")
    @Builder
    public static class Request {
        @Schema(description = "년도", example = "2021")
        private Integer year;
        @Schema(description = "동 고유번호", example = "1")
        private Long neighborhoodId;
        @Schema(description = "업종 고유번호", example = "1")
        private Long businessId;
    }

    @Getter
    @AllArgsConstructor
    @Schema(name = "Sales.Response", description = "매출 조회 응답 DTO")
    public static class Response {
        @Schema(description = "매출 합계", example = "1000000")
        private Long salesAmount;

        @Schema(description = "건수 합계", example = "10")
        private Integer salesCount;

        public static Response of(Long salesAmount, Integer salesCount) {
            return new Response(salesAmount, salesCount);
        }
    }
}

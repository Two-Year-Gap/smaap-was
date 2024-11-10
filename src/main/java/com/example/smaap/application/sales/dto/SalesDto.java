package com.example.smaap.application.sales.dto;

import com.example.smaap.domain.business.entity.Business;
import com.example.smaap.domain.region.entity.Neighborhood;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class SalesDto {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "Sales.Request", description = "매출 조회 요청 DTO")
    public static class Request {
        @Schema(description = "년도", example = "2021")
        private Integer year;
        @Schema(description = "동네", example = "1")
        private Neighborhood neighborhood;
        @Schema(description = "업종", example = "1")
        private Business business;
    }

    @Getter
    @AllArgsConstructor
    @Schema(name = "Sales.Response", description = "매출 조회 응답 DTO")
    public static class Response {
        @Schema(description = "매출 합계", example = "1000000")
        private Integer salesAmount;

        @Schema(description = "건수 합계", example = "10")
        private Integer salesCount;

        public static Response of(Integer salesAmount, Integer salesCount) {
            return new Response(salesAmount, salesCount);
        }
    }
}

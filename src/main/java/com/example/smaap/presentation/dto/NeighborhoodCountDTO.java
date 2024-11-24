package com.example.smaap.presentation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

public class NeighborhoodCountDTO {
    @Getter
    @Schema(name = "NeighborhoodStoreCount.Response", description = "동별 점포 수 응답 DTO")
    public static class Response {
        @Schema(description = "동 고유번호", example = "1")
        private Long id;

        @Schema(description = "동 이름", example = "삼성동")
        private String name;

        @Schema(description = "값", example = "100")
        private Long count;

        @Builder
        public Response(Long id, String name, Long storeCount) {
            this.id = id;
            this.name = name;
            this.count = storeCount;
        }
    }
}


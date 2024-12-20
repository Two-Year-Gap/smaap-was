package com.example.smaap.presentation.rest;

import com.example.smaap.domain.region.service.NeighborhoodService;
import com.example.smaap.domain.region.type.PopularType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/neighborhoods")
@Tag(name = "Neighborhoods", description = "동 정보 API")
@RequiredArgsConstructor
public class NeighborhoodController {
    private final NeighborhoodService neighborhoodService;

    @GetMapping("")
    @Operation(summary = "인기 상권 조회", description = "조건(PopularType[STORE: 상점 수, SALES: 매출액, FLOATING: 유동인구, RESIDENT: 주거인구])에 따른 인기 상권(동)을 조회합니다.")
    public ResponseEntity<?> list(@Parameter(description = "조회할 상권 타입") @RequestParam PopularType type, @RequestParam(defaultValue = "5") Long count) {
        return ResponseEntity.ok(neighborhoodService.list(type, count));
    }

    @GetMapping("/{id}/recommended-businesses")
    @Operation(summary = "상권(동)에 따른 업종 조회", description = "상권(동)에 따른 추천 업종을 조회합니다.")
    public ResponseEntity<?> recommendedBusinesses(@PathVariable Long id) {
        return ResponseEntity.ok(neighborhoodService.recommendedBusinesses(id));
    }
}

package com.example.smaap.presentation.rest;

import com.example.smaap.domain.region.service.DistrictService;
import com.example.smaap.domain.region.service.NeighborhoodService;
import com.example.smaap.domain.region.service.RegionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/regions")
@Tag(name = "Region", description = "지역 관련 API")
@RequiredArgsConstructor
public class RegionController {
    private final RegionService regionService;
    private final DistrictService districtService;
    private final NeighborhoodService neighborhoodService;

    @GetMapping
    @Operation(summary = "지역 목록 조회", description = "지역 목록을 조회합니다.")
    @ApiResponse(responseCode = "200", description = "지역 목록 조회 성공")
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(regionService.list());
    }

    @GetMapping("{id}/districts")
    @Operation(summary = "지역별 구 목록 조회", description = "지역별 구 목록을 조회합니다.")
    @ApiResponse(responseCode = "200", description = "지역별 구 목록 조회 성공")
    public ResponseEntity<?> list(@PathVariable Long id) {
        return ResponseEntity.ok(districtService.list(id));
    }

    @GetMapping("{id}/districts/{districtId}/neighborhoods")
    @Operation(summary = "구/군별 동 목록 조회", description = "구/군별 동 목록을 조회합니다.")
    @ApiResponse(responseCode = "200", description = "구/군별 동 목록 조회 성공")
    public ResponseEntity<?> list(@PathVariable Long id, @PathVariable Long districtId) {
        return ResponseEntity.ok(neighborhoodService.list(districtId));
    }
}

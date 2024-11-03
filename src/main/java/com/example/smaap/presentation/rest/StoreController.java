package com.example.smaap.presentation.rest;

import com.example.smaap.domain.business.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/stores")
@Tag(name = "Store", description = "상점 정보 API")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    @GetMapping
    @Operation(summary = "상점 목록 조회", description = "상점 목록을 조회합니다.")
    @ApiResponse(responseCode = "200", description = "상점 목록 조회 성공")
    public ResponseEntity<?> list(@RequestParam(required = false) Long businessId,
                                  @RequestParam(required = false) String address,
                                  @RequestParam(required = false) BigDecimal latitude,
                                  @RequestParam(required = false) BigDecimal longitude,
                                  @RequestParam(defaultValue = "1000") Long range,
                                  @RequestParam(defaultValue = "100") int size) {
        return ResponseEntity.ok(storeService.list(businessId, address, latitude, longitude, range, size));
    }
}

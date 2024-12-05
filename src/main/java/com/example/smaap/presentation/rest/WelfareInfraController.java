package com.example.smaap.presentation.rest;

import com.example.smaap.domain.welfare.service.WelfareInfraService;
import com.example.smaap.domain.welfare.type.WelfareInfraType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/welafre-infra")
@Tag(name = "Business", description = "업종 관련 API")
@RequiredArgsConstructor
public class WelfareInfraController {
    private final WelfareInfraService welfareInfraService;

    @GetMapping
    @Operation(summary = "복지성 인프라 시설 목록 조회", description = "복지성 인프라 시설 목록을 조회합니다.")
    public ResponseEntity<?> list(@RequestParam BigDecimal latitude,
                                  @RequestParam BigDecimal longitude,
                                  @RequestParam(defaultValue = "1000") Long range,
                                  @RequestParam(required = false) WelfareInfraType type) {
        return ResponseEntity.ok(welfareInfraService.list(latitude, longitude, range, type));
    }
}

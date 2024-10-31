package com.example.smaap.presentation.res;

import com.example.smaap.domain.business.service.BusinessService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/businesses")
@Tag(name = "Business", description = "업종 관련 API")
@RequiredArgsConstructor
public class BusinessController {
    private final BusinessService businessService;

    @GetMapping
    @Operation(summary = "업종 목록 조회", description = "업종 목록을 조회합니다.")
    @ApiResponse(responseCode = "200", description = "업종 목록 조회 성공")
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(businessService.list());
    }
}

package com.example.smaap.presentation.res;

import com.example.smaap.application.health.service.HealthCheckService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
@Tag(name = "Health", description = "서버 상태 체크 API")
@RequiredArgsConstructor
public class HealthCheckController {
    private final HealthCheckService healthCheckService;

    @GetMapping()
    @Operation(summary = "서버 상태 체크", description = "서버의 상태를 체크합니다.")
    @ApiResponse(responseCode = "200", description = "서버 정상 작동")
    public ResponseEntity<?> healthCheck() {
        return ResponseEntity.ok(healthCheckService.checkHealth());
    }
}

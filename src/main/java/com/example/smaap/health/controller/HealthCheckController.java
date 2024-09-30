package com.example.smaap.health.controller;

import com.example.smaap.health.service.HealthCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
@RequiredArgsConstructor
public class HealthCheckController {
    private final HealthCheckService healthCheckService;

    @GetMapping()
    public ResponseEntity<?> healthCheck() {
        return ResponseEntity.ok(healthCheckService.checkHealth());
    }
}

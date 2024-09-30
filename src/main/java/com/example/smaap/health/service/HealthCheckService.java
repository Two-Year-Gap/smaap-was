package com.example.smaap.health.service;

import com.example.smaap.health.dto.HealthCheckDto;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class HealthCheckService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public HealthCheckDto checkHealth() {
        HealthCheckDto healthCheckDto = new HealthCheckDto();
        healthCheckDto.setStatus("UP");
        healthCheckDto.setDatabase("UP");
        try {
            jdbcTemplate.execute("SELECT 1");
        } catch (Exception e) {
            healthCheckDto.setDatabase("DOWN");
            healthCheckDto.setError(e.getMessage());
        }
        return healthCheckDto;
    }
}

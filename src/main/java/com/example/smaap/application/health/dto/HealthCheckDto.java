package com.example.smaap.application.health.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HealthCheckDto {
    private String status;
    private String database;
    private String error;
}

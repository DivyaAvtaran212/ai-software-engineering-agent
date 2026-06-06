package com.project.aisoftwareagent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.aisoftwareagent.dto.HealthResponseDto;
import com.project.aisoftwareagent.service.HealthService;

@RestController
@RequestMapping("/api")
public class HealthController {

    private final HealthService healthService;

    public HealthController(HealthService healthService) {
        this.healthService = healthService;
    }

    @GetMapping("/health")
    public HealthResponseDto health() {
        return healthService.getHealthStatus();
    }
}
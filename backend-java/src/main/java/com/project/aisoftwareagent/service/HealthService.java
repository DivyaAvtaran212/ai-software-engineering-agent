package com.project.aisoftwareagent.service;

import org.springframework.stereotype.Service;

import com.project.aisoftwareagent.dto.HealthResponseDto;

@Service
public class HealthService {

    public HealthResponseDto getHealthStatus() {

        return new HealthResponseDto(
                "Backend Running Successfully",
                200
        );
    }
}
package com.project.aisoftwareagent.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemController {

    @GetMapping("/api/version")
    public Map<String, String> version() {

        return Map.of(
                "application", "AI Software Engineering Agent",
                "version", "1.0.0"
        );
    }
}
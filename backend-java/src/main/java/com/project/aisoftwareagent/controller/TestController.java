package com.project.aisoftwareagent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.aisoftwareagent.exception.ResourceNotFoundException;

@RestController
public class TestController {

    @GetMapping("/api/test-error")
    public String testError() {

        throw new ResourceNotFoundException(
                "Repository not found"
        );
    }
}
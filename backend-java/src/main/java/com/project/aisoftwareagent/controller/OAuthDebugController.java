package com.project.aisoftwareagent.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthDebugController {

    @GetMapping("/api/oauth/debug")
    public Object debug(Authentication authentication) {

        if (authentication == null) {
            return "Authentication is NULL";
        }

        return authentication;
    }
}
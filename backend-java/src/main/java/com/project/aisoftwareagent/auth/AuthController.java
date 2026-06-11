package com.project.aisoftwareagent.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.aisoftwareagent.auth.dto.AuthResponseDto;
import com.project.aisoftwareagent.auth.dto.LoginRequestDto;
import com.project.aisoftwareagent.auth.dto.RegisterRequestDto;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(
            AuthService authService
    ) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(
            @RequestBody RegisterRequestDto request
    ) {

        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponseDto login(
            @RequestBody LoginRequestDto request
    ) {

        return authService.login(request);
    }
}
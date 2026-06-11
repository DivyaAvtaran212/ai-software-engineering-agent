package com.project.aisoftwareagent.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.aisoftwareagent.auth.dto.AuthResponseDto;
import com.project.aisoftwareagent.auth.dto.LoginRequestDto;
import com.project.aisoftwareagent.auth.dto.RegisterRequestDto;
import com.project.aisoftwareagent.entity.User;
import com.project.aisoftwareagent.repository.UserRepository;
import com.project.aisoftwareagent.security.JwtService;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String register(RegisterRequestDto request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());

        user.setPassword(
                passwordEncoder.encode(
                        request.getPassword()
                )
        );

        user.setRole("USER");

        userRepository.save(user);

        return "User Registered Successfully";
    }

    public AuthResponseDto login(
            LoginRequestDto request
    ) {

        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(
                        () -> new RuntimeException(
                                "Invalid credentials"
                        )
                );

        boolean passwordMatches =
                passwordEncoder.matches(
                        request.getPassword(),
                        user.getPassword()
                );

        if (!passwordMatches) {
            throw new RuntimeException(
                    "Invalid credentials"
            );
        }

        String token =
                jwtService.generateToken(
                        user.getEmail()
                );

        return new AuthResponseDto(token);
    }
}
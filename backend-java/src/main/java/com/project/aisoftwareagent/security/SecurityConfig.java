package com.project.aisoftwareagent.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtFilter;
    private final OAuthSuccessHandler successHandler;

    public SecurityConfig(
            JwtAuthenticationFilter jwtFilter,
            OAuthSuccessHandler successHandler
    ) {
        this.jwtFilter = jwtFilter;
        this.successHandler = successHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http
    ) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                // .sessionManagement(session
                //         -> session.sessionCreationPolicy(
                //         SessionCreationPolicy.STATELESS
                // )
                // )
                .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                        "/api/auth/**",
                        "/oauth2/**",
                        "/login/**",
                        "/swagger-ui/**",
                        "/v3/api-docs/**",
                        "/api/oauth/**"
                )
                .permitAll()
                .anyRequest()
                .authenticated()
                )
                .oauth2Login(oauth
                        -> oauth.successHandler(successHandler)
                )
                .addFilterBefore(
                        jwtFilter,
                        UsernamePasswordAuthenticationFilter.class
                );

        return http.build();
    }
}

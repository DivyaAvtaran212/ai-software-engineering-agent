package com.project.aisoftwareagent.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.project.aisoftwareagent.entity.User;
import com.project.aisoftwareagent.service.GithubOAuthService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class OAuthSuccessHandler
        implements AuthenticationSuccessHandler {

    private final GithubOAuthService githubOAuthService;

    private final JwtService jwtService;

    public OAuthSuccessHandler(
            GithubOAuthService githubOAuthService,
            JwtService jwtService
    ) {
        this.githubOAuthService =
                githubOAuthService;

        this.jwtService =
                jwtService;
    }

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws IOException, ServletException {

        OAuth2User oauthUser
                = (OAuth2User) authentication.getPrincipal();

        Object idObj = oauthUser.getAttribute("id");

        String githubId
                = idObj != null ? idObj.toString() : null;

        String githubUsername
                = oauthUser.getAttribute("login");

        User user =
                githubOAuthService
                        .createOrUpdateGithubUser(
                                githubId,
                                githubUsername
                        );

        String token =
                jwtService.generateToken(
                        user.getEmail()
                );

        System.out.println(
                "JWT TOKEN: " + token
        );

        String email
                = oauthUser.getAttribute("email");

        System.out.println("=================================");
        System.out.println("GITHUB LOGIN SUCCESS");
        System.out.println("=================================");

        System.out.println("GitHub ID: " + githubId);
        System.out.println("GitHub Username: " + githubUsername);
        System.out.println("GitHub Email: " + email);

        System.out.println("=================================");

        response.sendRedirect(
                "http://localhost:5173/oauth-success?token="
                        + token
        );
    }
}

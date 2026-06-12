package com.project.aisoftwareagent.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(
            unique = true,
            nullable = false
    )
    private String email;

    private String password;

    private String role;

    // GitHub OAuth Fields

    private String githubId;

    private String githubUsername;

    @Column(length = 2000)
    private String githubAccessToken;

    // Constructors

    public User() {
    }

    public User(
            String name,
            String email,
            String password,
            String role
    ) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getGithubId() {
        return githubId;
    }

    public String getGithubUsername() {
        return githubUsername;
    }

    public String getGithubAccessToken() {
        return githubAccessToken;
    }

    // Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(
            String name
    ) {
        this.name = name;
    }

    public void setEmail(
            String email
    ) {
        this.email = email;
    }

    public void setPassword(
            String password
    ) {
        this.password = password;
    }

    public void setRole(
            String role
    ) {
        this.role = role;
    }

    public void setGithubId(
            String githubId
    ) {
        this.githubId = githubId;
    }

    public void setGithubUsername(
            String githubUsername
    ) {
        this.githubUsername = githubUsername;
    }

    public void setGithubAccessToken(
            String githubAccessToken
    ) {
        this.githubAccessToken = githubAccessToken;
    }
}
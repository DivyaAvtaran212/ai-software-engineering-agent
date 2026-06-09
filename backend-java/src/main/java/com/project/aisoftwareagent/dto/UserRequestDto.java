package com.project.aisoftwareagent.dto;

public class UserRequestDto {

    private String name;
    private String email;

    public UserRequestDto() {
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
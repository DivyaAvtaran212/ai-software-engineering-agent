package com.project.aisoftwareagent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.aisoftwareagent.entity.User;

public interface UserRepository
        extends JpaRepository<User, Long> {
}
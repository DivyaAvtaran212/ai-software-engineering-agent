package com.project.aisoftwareagent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.aisoftwareagent.entity.RepositoryEntity;

public interface RepositoryEntityRepository
        extends JpaRepository<RepositoryEntity, Long> {
}

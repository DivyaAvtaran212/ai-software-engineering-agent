package com.project.aisoftwareagent.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.aisoftwareagent.dto.RepositoryRequestDto;
import com.project.aisoftwareagent.entity.RepositoryEntity;
import com.project.aisoftwareagent.service.GithubRepositoryService;

@RestController
@RequestMapping("/api/repositories")
public class RepositoryController {

    private final GithubRepositoryService service;

    public RepositoryController(
            GithubRepositoryService service
    ) {
        this.service = service;
    }

    @PostMapping("/connect")
    public RepositoryEntity connectRepository(
            @RequestBody
            RepositoryRequestDto request
    ) {
        return service.connectRepository(
                request
        );
    }
}
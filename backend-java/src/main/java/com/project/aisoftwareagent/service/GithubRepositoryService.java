package com.project.aisoftwareagent.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.aisoftwareagent.dto.RepositoryRequestDto;
import com.project.aisoftwareagent.entity.RepositoryEntity;
import com.project.aisoftwareagent.repository.RepositoryEntityRepository;

@Service
public class GithubRepositoryService {

    private final RestTemplate restTemplate;
    private final RepositoryEntityRepository repository;

    public GithubRepositoryService(
            RestTemplate restTemplate,
            RepositoryEntityRepository repository
    ) {
        this.restTemplate = restTemplate;
        this.repository = repository;
    }

    public RepositoryEntity connectRepository(
            RepositoryRequestDto request
    ) {

        String url =
                "https://api.github.com/repos/"
                        + request.getOwner()
                        + "/"
                        + request.getRepoName();

        Map<String, Object> response =
                restTemplate.getForObject(
                        url,
                        Map.class
                );

        RepositoryEntity repo =
                new RepositoryEntity();

        repo.setName(
                (String) response.get("name")
        );

        repo.setOwner(
                request.getOwner()
        );

        repo.setDescription(
                (String) response.get("description")
        );

        repo.setLanguage(
                (String) response.get("language")
        );

        repo.setRepoUrl(
                (String) response.get("html_url")
        );

        repo.setDefaultBranch(
                (String) response.get("default_branch")
        );

        return repository.save(repo);
    }
}
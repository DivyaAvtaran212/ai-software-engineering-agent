package com.project.aisoftwareagent.service;

import org.springframework.stereotype.Service;

import com.project.aisoftwareagent.entity.User;
import com.project.aisoftwareagent.repository.UserRepository;

@Service
public class GithubOAuthService {

    private final UserRepository userRepository;

    public GithubOAuthService(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    public User createOrUpdateGithubUser(
            String githubId,
            String githubUsername
    ) {

        return userRepository
                .findByGithubId(githubId)
                .orElseGet(() -> {

                    User user = new User();

                    user.setGithubId(githubId);

                    user.setGithubUsername(
                            githubUsername
                    );

                    user.setName(
                            githubUsername
                    );

                    user.setEmail(
                            githubUsername
                                    + "@github.local"
                    );

                    user.setRole("USER");

                    return userRepository.save(user);
                });
    }
}
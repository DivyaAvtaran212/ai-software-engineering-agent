package com.project.aisoftwareagent.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.aisoftwareagent.dto.UserRequestDto;
import com.project.aisoftwareagent.entity.User;
import com.project.aisoftwareagent.exception.ResourceNotFoundException;
import com.project.aisoftwareagent.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserRequestDto request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: " + id
                        ));
    }
}
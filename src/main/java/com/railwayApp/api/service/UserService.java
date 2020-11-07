package com.railwayApp.api.service;

import com.railwayApp.api.domain.User;
import com.railwayApp.api.dto.UserProfile;
import com.railwayApp.api.repo.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User getUser(String username) {
        User user = userRepo
                .findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User with username '" + username + "' not found"));
        return user;
    }

    public UserProfile getUserProfile(String username) {
        User user = getUser(username);
        return new UserProfile(user);
    }

}

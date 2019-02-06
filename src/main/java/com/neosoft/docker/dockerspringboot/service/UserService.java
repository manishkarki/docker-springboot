package com.neosoft.docker.dockerspringboot.service;

import com.neosoft.docker.dockerspringboot.model.User;
import com.neosoft.docker.dockerspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author mkarki
 */
@Component
public class UserService {

    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.repo = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setId(getRandomUserId(user));
        repo.save(user);
    }

    private Long getRandomUserId(User user) {
        Long leftLimit = 1L;
        Long rightLimit = 2000L;
        int offset = user.getUserName().chars()
                .sum();

        return (leftLimit + (long)(Math.random() *(offset + rightLimit - leftLimit)));
    }

}

package com.neosoft.docker.dockerspringboot.service;

import com.neosoft.docker.dockerspringboot.model.User;
import com.neosoft.docker.dockerspringboot.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author mkarki
 */
@Service
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.repo = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setId(getRandomUserId(user));
        return repo.save(user);
    }

    private Long getRandomUserId(User user) {
        Long leftLimit = 1L;
        Long rightLimit = 2000L;
        int offset = user.getUserName().chars()
                .sum();
        long userId = (leftLimit + (long)(Math.random() *(offset + rightLimit - leftLimit)));
        LOGGER.info("user id was calculated to be:{}", userId);
        return userId;
    }

}

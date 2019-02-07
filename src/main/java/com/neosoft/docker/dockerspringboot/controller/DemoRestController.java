package com.neosoft.docker.dockerspringboot.controller;

import com.neosoft.docker.dockerspringboot.model.User;
import com.neosoft.docker.dockerspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mkarki
 */

@RestController
public class DemoRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/docker/spring")
    public String demo() {
        return "docker spring app";
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
        return userService.save(user);
    }
}

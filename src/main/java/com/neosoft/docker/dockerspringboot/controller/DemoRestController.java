package com.neosoft.docker.dockerspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mkarki
 */

@RestController
public class DemoRestController {

    @GetMapping("/docker/spring")
    public String demo() {
        return "docker spring app";
    }
}

package com.neosoft.docker.dockerspringboot.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(DemoRestController.class)
public class DemoRestControllerTest {

    @Test
    public void testPostMappingOfUserRecord() {
    }
}
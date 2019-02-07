package com.neosoft.docker.dockerspringboot;

import com.neosoft.docker.dockerspringboot.model.Role;
import com.neosoft.docker.dockerspringboot.model.User;
import com.neosoft.docker.dockerspringboot.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class DockerSpringbootApplication {

//    @Bean
//    public CommandLineRunner setupDefaultUser(UserService service) {
//        return args -> service.save(new User(
//                "user", //username
//                "user", //password
//                Arrays.asList(new Role("USER"), new Role("ACTUATOR"))
//        ));
//    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

	public static void main(String[] args) {
		SpringApplication.run(DockerSpringbootApplication.class, args);
	}

}

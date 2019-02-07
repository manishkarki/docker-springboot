package com.neosoft.docker.dockerspringboot.repository;

import com.neosoft.docker.dockerspringboot.model.Role;
import com.neosoft.docker.dockerspringboot.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author mkarki
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testUserIsSaved() {
        User user = new User(
                "user", //username
                "user", //password
                Arrays.asList(new Role("USER"), new Role("ACTUATOR")));
        entityManager.persist(user);
        entityManager.flush();

        User retrievedUser = userRepository.findByUserName(user.getUserName()).get();
        assertThat(retrievedUser.getUserName(), is(equalTo(retrievedUser.getUserName())));
    }

}
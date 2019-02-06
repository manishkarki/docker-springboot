package com.neosoft.docker.dockerspringboot.repository;

import com.neosoft.docker.dockerspringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author mkarki
 */
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUserName(String userName);
}

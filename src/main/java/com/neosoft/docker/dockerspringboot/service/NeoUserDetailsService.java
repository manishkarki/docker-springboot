package com.neosoft.docker.dockerspringboot.service;

import com.neosoft.docker.dockerspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * @author mkarki
 */
@Service
public class NeoUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public NeoUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUserName(username)
                .map(user -> new org.springframework.security.core.userdetails.User(
                        user.getUserName(),
                        user.getPassword(),
                        user.isActive(),
                        user.isActive(),
                        user.isActive(),
                        user.isActive(),
                        AuthorityUtils.createAuthorityList(
                                user.getRoles()
                                        .stream()
                                        .map(r -> "ROLE_" + r.getName().toUpperCase())
                                        .collect(Collectors.toList())
                                        .toArray(new String[]{}))))
                .orElseThrow(() -> new UsernameNotFoundException("No user with "
                        + "the name " + username + "was found in the database"));
    }
}

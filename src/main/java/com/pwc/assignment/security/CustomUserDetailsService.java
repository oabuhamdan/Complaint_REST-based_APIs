package com.pwc.assignment.security;

import com.pwc.assignment.data.entities.User;
import com.pwc.assignment.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        CustomUserDetails customUserDetails = new CustomUserDetails(user.orElseThrow(() -> new UsernameNotFoundException("Could not find user")));
        return org.springframework.security.core.userdetails.User.withUsername(customUserDetails.getUsername())
                .password(customUserDetails.getPassword())
                .authorities(customUserDetails.getAuthorities()).build();
    }
}

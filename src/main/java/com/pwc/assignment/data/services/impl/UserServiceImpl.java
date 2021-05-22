package com.pwc.assignment.data.services.impl;

import com.pwc.assignment.data.dto.UserDto;
import com.pwc.assignment.data.entities.User;
import com.pwc.assignment.data.entities.UserRoles;
import com.pwc.assignment.data.repositories.UserRepository;
import com.pwc.assignment.data.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;

    @Override
    public void registerUser(UserDto userDto) {
        String name = userDto.getName() == null ? "no_name" : userDto.getName();
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        String username = userDto.getUsername();

        Optional<User> userExists = userRepository.findByUsername(username);

        if (userExists.isPresent()) {
            throw new RuntimeException(username + " already registered.");
        }
        userRepository.save(new User(name, username, encodedPassword, UserRoles.USER));
    }

    @Override
    public User loginUser(UserDto user) {
        Optional<User> userExists = userRepository.findByUsername(user.getUsername());

        if (userExists.isPresent()) {
            String password = user.getPassword();
            if (!passwordEncoder.matches(password, userExists.get().getPassword())) {
                throw new RuntimeException("Invalid user name and password combination.");
            }
        } else {
            throw new RuntimeException("Invalid user name.");
        }

        return userExists.get();
    }

    @Override
    public void changeUserAuthority(String username, UserRoles newRole) {
        Optional<User> user = userRepository.findByUsername(username);
        user.map(u -> {
            u.setAuthority(newRole);
            return userRepository.save(u);
        }).orElseThrow(() -> new RuntimeException("Invalid username."));
    }

    @Override
    public List<User> listAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("No user found for this username"));
    }
}

package com.pwc.assignment.data.services;

import com.pwc.assignment.data.dto.UserDto;
import com.pwc.assignment.data.entities.User;
import com.pwc.assignment.data.entities.UserRoles;

import java.util.List;

public interface UserService {
    User loginUser(UserDto user);
    void registerUser(UserDto user);
    void changeUserAuthority(String username, UserRoles newRole);
    List<User> listAllUsers();
    User getUser(String username);
}

package com.pwc.assignment.web.controllers.rest.user;


import com.pwc.assignment.data.dto.UserDto;
import com.pwc.assignment.data.entities.User;
import com.pwc.assignment.data.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
public class RegistrationAndLoginController {
    @Autowired
    UserService userService;

    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void register(@Valid UserDto user, HttpServletResponse response) throws IOException {
        userService.registerUser(user);
        response.sendRedirect("/login");
    }

    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public User login(@Valid  UserDto user) {
        return userService.loginUser(user);
    }
}

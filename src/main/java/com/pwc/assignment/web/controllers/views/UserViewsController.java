package com.pwc.assignment.web.controllers.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewsController {
    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @GetMapping("/register")
    public String register() {
        return "user/register";
    }

    @GetMapping("/createNewComplaint")
    public String userComplaintsView() {
        return "user/createComplaint";
    }

    @GetMapping("/myComplaints")
    public String createNewComplaint() {
        return "user/userComplaints";
    }
}

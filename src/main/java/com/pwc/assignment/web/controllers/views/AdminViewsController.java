package com.pwc.assignment.web.controllers.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminViewsController {
    @GetMapping
    public String showHome() {
        return "admin/adminHome";
    }

    @GetMapping("/manageComplaints")
    public String login() {
        return "admin/manageComplaints";
    }

    @GetMapping("/manageUsers")
    public String register() {
        return "admin/manageUsers";
    }
}

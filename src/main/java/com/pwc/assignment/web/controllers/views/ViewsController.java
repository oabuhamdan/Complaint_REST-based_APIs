package com.pwc.assignment.web.controllers.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewsController {
    @GetMapping("/")
    public String showHome(){
        return "home";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/register")
    public String register(){
        return "register";
    }
    @GetMapping("/createNewComplaint")
    public String createNewComplaint(){
        return "createComplaint";
    }
}

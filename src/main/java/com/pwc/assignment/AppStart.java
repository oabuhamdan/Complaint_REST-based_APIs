package com.pwc.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages ={"com.pwc.assignment"})
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class, args);
    }
}

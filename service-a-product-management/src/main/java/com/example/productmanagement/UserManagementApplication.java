package com.example.usermanagement;

import org.springframework.boot.SpringApplication; // <-- Agrega este import
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserManagementApplication.class, args);
    }
}
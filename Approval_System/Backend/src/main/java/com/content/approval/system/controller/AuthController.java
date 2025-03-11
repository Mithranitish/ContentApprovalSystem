package com.content.approval.system.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.content.approval.system.dto.LoginRequest;
import com.content.approval.system.model.User;
import com.content.approval.system.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        User user = authService.authenticate(request.getUsername(), request.getPassword());
        return "JWT_TOKEN"; // Implement JWT token logic
    }
}

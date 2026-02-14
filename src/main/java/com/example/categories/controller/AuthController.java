package com.example.categories.controller;

import com.example.categories.entity.User;
import com.example.categories.service.JwtService;
import com.example.categories.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;

    public AuthController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    // ------------------ REGISTER ------------------
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestParam String username,
                                      @RequestParam String email,
                                      @RequestParam String password) {

        User user = userService.register(username, email, password);

        String token = jwtService.generateToken(user.getEmail());

        return ResponseEntity.ok(Map.of(
                "message", "User registered successfully",
                "token", token
        ));
    }

    // ------------------ LOGIN ------------------
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email,
                                   @RequestParam String password) {

        User user = userService.login(email, password);

        String token = jwtService.generateToken(user.getEmail());

        return ResponseEntity.ok(Map.of(
                "message", "Login successful",
                "token", token
        ));
    }
}
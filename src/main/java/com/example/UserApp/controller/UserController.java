package com.example.UserApp.controller;

import com.example.UserApp.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/start")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<String> login() {
        System.out.println("the users Login::::::::::");

        return ResponseEntity.ok().body("well doooone");
    }
    @GetMapping("/error")
    public ResponseEntity<String> error() {
        System.out.println("cant access..........XXXX");

        return ResponseEntity.ok().body("bad login");
    }
}

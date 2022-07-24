package com.example.UserApp.controller;

import com.example.UserApp.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<String> Homepage() {
        System.out.println("home page is appear successfully ");
        return ResponseEntity.ok().body("Home Page");
    }

    @GetMapping("/error")
    public ResponseEntity<String> error() {
        System.out.println("cant access..........XXXX");

        return ResponseEntity.ok().body("bad login");
    }

}

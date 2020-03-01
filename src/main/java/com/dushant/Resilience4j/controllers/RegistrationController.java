package com.dushant.Resilience4j.controllers;

import com.dushant.Resilience4j.dto.User;
import com.dushant.Resilience4j.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/v1/user")
    public ResponseEntity<String> createUser(@RequestBody User user){
        registrationService.createUser(user);
        return ResponseEntity.ok("User created");
    }
}

package com.dushant.Resilience4j.controllers;

import com.dushant.Resilience4j.dto.User;
import com.dushant.Resilience4j.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;


    @PostMapping("/v1/demo")
    public ResponseEntity<String> addUser(@RequestBody User user){
        String response = demoService.addUser(user);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/v1/demo")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = demoService.getAllUsers();
        return ResponseEntity.ok(users);
    }

}

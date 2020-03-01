package com.dushant.Resilience4j.services;

import com.dushant.Resilience4j.dto.User;

import java.util.List;

public interface DemoService {

    String addUser(User user);

    List<User> getAllUsers();
}

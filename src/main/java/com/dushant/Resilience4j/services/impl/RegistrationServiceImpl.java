package com.dushant.Resilience4j.services.impl;

import com.dushant.Resilience4j.dto.User;
import com.dushant.Resilience4j.services.RegistrationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private List<User> users = new ArrayList<>();

    @Override
    public User createUser(User user) {
        users.add(user);
        return user;
    }
}

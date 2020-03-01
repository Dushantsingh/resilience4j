package com.dushant.Resilience4j.services;

import com.dushant.Resilience4j.dto.User;

public interface RegistrationService {

    User createUser(User user);
}

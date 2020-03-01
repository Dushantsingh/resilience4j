package com.dushant.Resilience4j.services.impl;

import com.dushant.Resilience4j.clients.RegistrationServiceClient;
import com.dushant.Resilience4j.dto.User;
import com.dushant.Resilience4j.services.DemoService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DemoServiceImpl implements DemoService {

    @Autowired
    private RegistrationServiceClient registrationServiceClient;

    @Override
    @CircuitBreaker(name = "registrationService",fallbackMethod = "fallBackForCreateUser")
    public String addUser(User user) {
      String response =  registrationServiceClient.registerUser(user);
      return response;
    }

    @Override
    @RateLimiter(name = "service1",fallbackMethod = "userRateLimitFallBack")
    public List<User> getAllUsers() {
        List<User> user = new ArrayList<>();
        User user1 = new User();
        user1.setFirstName("A");
        user1.setLastName("b");
        user.add(user1);
        return user;
    }


    public List<User> userRateLimitFallBack(Throwable t){
        log.error("Rate limit error",t.toString());
        return new ArrayList<User>();
    }

    public String fallBackForCreateUser(User user, Throwable t){
        log.error("Inside fallBack of registration : {}",t.toString());
        return "Unable to create user.".concat(user.toString()).concat("Try again in some time");
    }



}

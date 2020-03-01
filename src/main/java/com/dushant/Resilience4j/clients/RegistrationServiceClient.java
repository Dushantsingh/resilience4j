package com.dushant.Resilience4j.clients;

import com.dushant.Resilience4j.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "registrationService", url = "${registrationService.baseUrl}")
@Service
public interface RegistrationServiceClient {

  @PostMapping("/v1/user")
  String registerUser(@RequestBody User user);
}

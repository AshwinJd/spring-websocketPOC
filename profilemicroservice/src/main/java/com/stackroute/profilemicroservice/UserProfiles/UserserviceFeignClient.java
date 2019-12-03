package com.stackroute.profilemicroservice.UserProfiles;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@FeignClient("helloworld-service")
public interface UserserviceFeignClient {

  @GetMapping("/api/v1/users")
  ArrayList<Users> getAllUsers();
}

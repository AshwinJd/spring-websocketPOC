package com.stackroute.profilemicroservice.UserProfiles;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1")
public class UserProfileController {

  @Autowired
  UserProfileService userProfileService;

  @GetMapping("/profiles")
  public ArrayList<Users> getAllProfileUsers(){
    return userProfileService.getAllUsers();
  }
}

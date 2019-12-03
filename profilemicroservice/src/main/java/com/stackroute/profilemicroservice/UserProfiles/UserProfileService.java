package com.stackroute.profilemicroservice.UserProfiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserProfileService {

  @Autowired
  UserserviceFeignClient userProxy;

  public ArrayList<Users> getAllUsers() {
    return userProxy.getAllUsers();
  }
}

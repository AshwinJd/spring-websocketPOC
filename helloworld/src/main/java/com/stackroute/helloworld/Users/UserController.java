package com.stackroute.helloworld.Users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class UserController {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  IUserService userService;

  @PostMapping("/users")
  @ResponseBody
  public ResponseEntity<Users> createNewUser(@RequestBody Users userObj) {
    userObj.setUserId(UUID.randomUUID());
    userObj.setCreatedOn(LocalDateTime.now());
    userObj.setCreatedBy("Owner");
    userObj.setUpdatedOn(LocalDateTime.now());
    userObj.setUpdatedBy("Owner");
    logger.info("User that is requested for creation::-" + userObj.toString());
    try {
      Users userResult = userService.addNewUser(userObj);
      logger.info("User object that is saved to the DB" + userResult.toString());
      return ResponseEntity.ok(userResult);
    } catch (Exception e) {
      logger.error("Error while saving new user to the database::-" + e.getMessage());
      return null;
    }
  }

  @GetMapping("/users")
  @ResponseBody
  public ArrayList<Users> getAllUsers() {
    try {
      ArrayList<Users> userList = userService.getAllUsers();
      return userList;
    } catch (Exception e) {
      logger.error("Error while fetching all the users in the system" + e.getMessage());
      return null;
    }
  }
}

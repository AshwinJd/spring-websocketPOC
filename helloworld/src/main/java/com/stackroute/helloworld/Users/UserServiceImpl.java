package com.stackroute.helloworld.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements IUserService {

  @Autowired
  IUserRepository userRepository;

  @Override
  public Users addNewUser(Users userObj) {
    return userRepository.insert(userObj);
  }

  @Override
  public ArrayList<Users> getAllUsers() {
    return userRepository.findAll();
  }
}

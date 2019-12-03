package com.stackroute.helloworld.Users;

import com.stackroute.helloworld.Users.Users;

import java.util.ArrayList;

public interface IUserService {
  Users addNewUser(Users userObj);
  ArrayList<Users> getAllUsers();
}

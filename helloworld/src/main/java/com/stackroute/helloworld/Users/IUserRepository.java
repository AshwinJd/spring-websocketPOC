package com.stackroute.helloworld.Users;

import com.stackroute.helloworld.Users.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface IUserRepository extends MongoRepository<Users, String> {
  ArrayList<Users> findAll();
}

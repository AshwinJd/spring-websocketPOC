package com.stackroute.helloworld.Users;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document(collection = "Users")
public class Users {
  private UUID userId;

  private String name;

  private int age;

  private String createdBy;

  private LocalDateTime createdOn;

  private LocalDateTime updatedOn;
  private String updatedBy;

  public UUID getUserId() {
    return userId;
  }


  public Users(UUID userId, String name, int age, String createdBy, LocalDateTime createdOn, LocalDateTime updatedOn, String updatedBy) {
    this.userId = userId;
    this.name = name;
    this.age = age;
    this.createdBy = createdBy;
    this.createdOn = createdOn;
    this.updatedOn = updatedOn;
    this.updatedBy = updatedBy;
  }


  @Override
  public String toString() {
    return "Users{" +
            ", userId=" + userId +
            ", name='" + name + '\'' +
            ", age=" + age +
            ", createdBy='" + createdBy + '\'' +
            ", createdOn=" + createdOn +
            ", updatedOn=" + updatedOn +
            ", updatedBy='" + updatedBy + '\'' +
            '}';
  }
  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public LocalDateTime getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(LocalDateTime createdOn) {
    this.createdOn = createdOn;
  }

  public LocalDateTime getUpdatedOn() {
    return updatedOn;
  }

  public void setUpdatedOn(LocalDateTime updatedOn) {
    this.updatedOn = updatedOn;
  }

  public String getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }

  public void setAge(int age) {
    this.age = age;
  }
}

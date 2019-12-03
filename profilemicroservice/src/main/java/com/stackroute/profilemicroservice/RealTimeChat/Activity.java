package com.stackroute.profilemicroservice.RealTimeChat;

public class Activity {
  String Id;
  String actor;
  String type;

  public Activity(String id, String actor, String type) {
    Id = id;
    this.actor = actor;
    this.type = type;
  }

  public String getId() {
    return Id;
  }

  public void setId(String id) {
    Id = id;
  }

  public String getActor() {
    return actor;
  }

  public void setActor(String actor) {
    this.actor = actor;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}

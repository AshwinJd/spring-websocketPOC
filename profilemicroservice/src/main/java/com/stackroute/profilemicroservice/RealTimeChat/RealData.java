package com.stackroute.profilemicroservice.RealTimeChat;

public class RealData {
  String character;
  int value;

  public RealData(String character, int value) {
    this.character = character;
    this.value = value;
  }

  public String getCharacter() {
    return character;
  }

  public void setCharacter(String character) {
    this.character = character;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "RealData{" +
            "character='" + character + '\'' +
            ", value=" + value +
            '}';
  }

  public void setValue(int value) {
    this.value = value;
  }
}

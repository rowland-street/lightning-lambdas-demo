package com.lightninglambdas;

public class UserIdParser {
  public String execute(final String filename) {

    String userId = filename.split("-")[0];
    return userId;
  }
}

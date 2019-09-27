package com.lightninglambdas.config;

public class EnvironmentProvider {
  public String execute() {
    return System.getenv("Environment");
  }
}

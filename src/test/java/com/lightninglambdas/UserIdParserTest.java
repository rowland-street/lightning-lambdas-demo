package com.lightninglambdas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserIdParserTest {
  /** Variables */
  private static final String filename;

  private static final String userId;

  /** Test fixture */
  private UserIdParser userIdParser;

  static {
    filename = "user1-event1";
    userId = "user1";
  }

  @BeforeEach
  public void setupTestFixture() {

    userIdParser = new UserIdParser();
  }

  @Test
  public void test1() {

    assertEquals(userId, userIdParser.execute(filename), "Should return the correct userId");
  }
}

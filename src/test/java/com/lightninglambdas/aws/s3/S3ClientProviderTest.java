package com.lightninglambdas.aws.s3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class S3ClientProviderTest {

  // Test Fixture
  private S3ClientProvider s3ClientProvider;

  @BeforeEach
  void setupTestFixture() {
    s3ClientProvider = new S3ClientProvider();
  }

  // @Test // - runs agains live AWS S3
  void test1() {
    assertTrue(
        s3ClientProvider.get().listBuckets().size() > 0,
        "can connect to AWS S3 through the client");
  }

  @Test
  void test2() {
    assertEquals(
        s3ClientProvider.get(),
        s3ClientProvider.get(),
        "S3Client provider should cache the client");
  }
}

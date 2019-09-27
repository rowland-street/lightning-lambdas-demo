package com.lightninglambdas.aws.s3;

import org.junit.jupiter.api.BeforeEach;

class S3FileWriterTest {

  // Values
  private static S3Bucket s3Bucket;
  private static String content;
  private static String fileName;

  static {
    s3Bucket = new S3Bucket("");
    content = "some text content";
    fileName = "/a/file/path";
  }

  // Test Fixture
  private S3FileWriter s3FileWriter;

  @BeforeEach
  void setupTestFixture() {
    s3FileWriter = new S3FileWriter(new S3ClientProvider());
  }

  // @Test - runs against AWS S3
  void test1() {
    s3FileWriter.execute(s3Bucket, fileName, content);
  }
}

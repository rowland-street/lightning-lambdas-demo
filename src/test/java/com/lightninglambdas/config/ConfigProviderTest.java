package com.lightninglambdas.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.lightninglambdas.aws.dynamo.DynamoTable;
import com.lightninglambdas.aws.s3.S3Bucket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConfigProviderTest {
  private static final Config expectedProductionConfig;

  private static final Config expectedStagingConfig;

  private EnvironmentProvider environmentProvider;

  private ConfigProvider configProvider;

  static {
    expectedStagingConfig =
        new Config(
            new S3Bucket("a-bucket-1"),
            new DynamoTable("us-west-3", "table-name-3", "someField-3"));
    expectedProductionConfig =
        new Config(
            new S3Bucket("a-bucket-0"),
            new DynamoTable("us-west-2", "table-name-2", "someField-2"));
  }

  @BeforeEach
  void setupTestFixture() {
    environmentProvider = mock(EnvironmentProvider.class);
    configProvider = new ConfigProvider(environmentProvider);
  }

  @Test
  void test1() {
    when(environmentProvider.execute()).thenReturn("staging");
    assertEquals(
        configProvider.execute(),
        expectedStagingConfig,
        "Correct config should be returned for the staging environment");
  }

  @Test
  void test2() {
    when(environmentProvider.execute()).thenReturn("production");
    assertEquals(
        configProvider.execute(),
        expectedProductionConfig,
        "Correct config should be returned for the production environment");
  }
}

package com.lightninglambdas.config;

import com.lightninglambdas.aws.dynamo.DynamoTable;
import com.lightninglambdas.aws.s3.S3Bucket;
import com.typesafe.config.ConfigFactory;

public class ConfigProvider {
  private final EnvironmentProvider environmentProvider;

  public ConfigProvider(final EnvironmentProvider environmentProvider) {
    this.environmentProvider = environmentProvider;
  }

  public Config execute() {
    final com.typesafe.config.Config config = ConfigFactory.load();
    final String environment = environmentProvider.execute();
    final S3Bucket usersBucket =
        new S3Bucket(config.getString(String.format("%s.usersBucket.bucketName", environment)));
    final DynamoTable usersTable =
        new DynamoTable(
            config.getString(String.format("%s.usersTable.region", environment)),
            config.getString(String.format("%s.usersTable.tableName", environment)),
            config.getString(String.format("%s.usersTable.idFieldName", environment)));
    return new Config(usersBucket, usersTable);
  }
}

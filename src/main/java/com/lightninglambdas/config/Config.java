package com.lightninglambdas.config;

import com.lightninglambdas.aws.dynamo.DynamoTable;
import com.lightninglambdas.aws.s3.S3Bucket;
import java.util.Objects;

public class Config {
  public final S3Bucket usersBucket;

  public final DynamoTable usersTable;

  public Config(final S3Bucket usersBucket, final DynamoTable usersTable) {
    this.usersBucket = usersBucket;
    this.usersTable = usersTable;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Config config = (Config) o;
    return Objects.equals(usersBucket, config.usersBucket)
        && Objects.equals(usersTable, config.usersTable);
  }

  @Override
  public int hashCode() {
    return Objects.hash(usersBucket, usersTable);
  }

  @Override
  public String toString() {
    return "Config{" + " usersBucket=" + usersBucket + " usersTable=" + usersTable + "}";
  }
}

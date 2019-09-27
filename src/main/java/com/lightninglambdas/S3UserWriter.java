package com.lightninglambdas;

import com.lightninglambdas.aws.s3.S3Bucket;
import com.lightninglambdas.aws.s3.S3FileWriter;
import com.lightninglambdas.config.Config;
import com.lightninglambdas.config.ConfigProvider;

public class S3UserWriter {
  private final ConfigProvider configProvider;

  private final S3BucketProvider s3BucketProvider;

  private final S3FileWriter s3Writer;

  public S3UserWriter(
      final ConfigProvider configProvider,
      final S3BucketProvider s3BucketProvider,
      final S3FileWriter s3Writer) {
    this.configProvider = configProvider;
    this.s3BucketProvider = s3BucketProvider;
    this.s3Writer = s3Writer;
  }

  public void execute(final String path, final String content) {
    final Config config = configProvider.execute();
    final S3Bucket s3Bucket = s3BucketProvider.execute(config);
    s3Writer.execute(s3Bucket, path, content);
  }
}

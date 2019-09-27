package com.lightninglambdas;

import com.lightninglambdas.aws.s3.S3Bucket;
import com.lightninglambdas.config.Config;

public class S3BucketProvider {
  public S3Bucket execute(final Config config) {

    return config.usersBucket;
  }
}

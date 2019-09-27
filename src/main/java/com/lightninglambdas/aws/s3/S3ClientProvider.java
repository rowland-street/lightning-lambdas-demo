package com.lightninglambdas.aws.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class S3ClientProvider {

  private static AmazonS3 client;

  public AmazonS3 get() {
    if (client == null) {
      client = AmazonS3ClientBuilder.standard().build();
    }

    return client;
  }
}

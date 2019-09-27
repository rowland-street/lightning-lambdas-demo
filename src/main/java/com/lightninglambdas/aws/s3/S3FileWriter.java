package com.lightninglambdas.aws.s3;

public class S3FileWriter {
  private final S3ClientProvider s3ClientProvider;

  public S3FileWriter(final S3ClientProvider s3ClientProvider) {
    this.s3ClientProvider = s3ClientProvider;
  }

  public void execute(final S3Bucket s3Bucket, final String path, final String content) {
    s3ClientProvider.get().putObject(s3Bucket.bucketName, path, content);
  }
}

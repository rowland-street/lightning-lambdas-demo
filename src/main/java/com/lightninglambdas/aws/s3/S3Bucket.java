package com.lightninglambdas.aws.s3;

import java.util.Objects;

public class S3Bucket {
  public final String bucketName;

  public S3Bucket(final String bucketName) {
    this.bucketName = bucketName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    S3Bucket s3Bucket = (S3Bucket) o;
    return bucketName.equals(s3Bucket.bucketName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bucketName);
  }

  @Override
  public String toString() {
    return "S3Bucket{" + "bucketName='" + bucketName + '\'' + '}';
  }
}

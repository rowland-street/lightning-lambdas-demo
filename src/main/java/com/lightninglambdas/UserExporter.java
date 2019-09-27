package com.lightninglambdas;

public class UserExporter {
  private final UserIdParser userIdParser;

  private final DynamoUserReader dynamoUserReader;

  private final S3UserWriter s3UserWriter;

  public UserExporter(
      final UserIdParser userIdParser,
      final DynamoUserReader dynamoUserReader,
      final S3UserWriter s3UserWriter) {
    this.userIdParser = userIdParser;
    this.dynamoUserReader = dynamoUserReader;
    this.s3UserWriter = s3UserWriter;
  }

  public void execute(final String filename) {
    final String userId = userIdParser.execute(filename);
    final String userJson = dynamoUserReader.execute(userId);
    s3UserWriter.execute(userId, userJson);
  }
}

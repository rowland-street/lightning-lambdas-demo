package com.lightninglambdas.startup;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.lightninglambdas.DynamoTableProvider;
import com.lightninglambdas.DynamoUserReader;
import com.lightninglambdas.S3BucketProvider;
import com.lightninglambdas.S3UserWriter;
import com.lightninglambdas.Unit_g43grewgrewf_root_0;
import com.lightninglambdas.Unit_g43grewgrewf_root_0_0;
import com.lightninglambdas.UserExporter;
import com.lightninglambdas.UserIdParser;
import com.lightninglambdas.UserStringifier;
import com.lightninglambdas.aws.dynamo.DynamoClientProvider;
import com.lightninglambdas.aws.dynamo.DynamoItemReader;
import com.lightninglambdas.aws.s3.S3ClientProvider;
import com.lightninglambdas.aws.s3.S3EventHandler;
import com.lightninglambdas.aws.s3.S3FileWriter;
import com.lightninglambdas.config.ConfigProvider;
import com.lightninglambdas.config.EnvironmentProvider;

public class S3Lambda implements RequestHandler<S3Event, Void> {
  private final S3EventHandler s3EventHandler;

  public S3Lambda() {
    this.s3EventHandler =
        new S3EventHandler() {
          private final Unit_g43grewgrewf_root_0 unit_g43grewgrewf_root_0 =
              new Unit_g43grewgrewf_root_0(
                  new Unit_g43grewgrewf_root_0_0(),
                  new UserExporter(
                      new UserIdParser(),
                      new DynamoUserReader(
                          new ConfigProvider(new EnvironmentProvider()),
                          new DynamoTableProvider(),
                          new DynamoItemReader(new DynamoClientProvider()),
                          new UserStringifier()),
                      new S3UserWriter(
                          new ConfigProvider(new EnvironmentProvider()),
                          new S3BucketProvider(),
                          new S3FileWriter(new S3ClientProvider()))));

          public void execute(final S3Event s3Event, final Context context) {
            unit_g43grewgrewf_root_0.execute(s3Event);
          }
        };
  }

  @Override
  public Void handleRequest(final S3Event s3Event, final Context context) {
    s3EventHandler.execute(s3Event, context);
    return null;
  }
}

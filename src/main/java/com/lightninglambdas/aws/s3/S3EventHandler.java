package com.lightninglambdas.aws.s3;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.S3Event;

public interface S3EventHandler {
  void execute(S3Event s3Event, Context context);
}

package com.lightninglambdas;

import com.lightninglambdas.aws.dynamo.DynamoTable;
import com.lightninglambdas.config.Config;

public class DynamoTableProvider {
  public DynamoTable execute(final Config config) {

    return config.usersTable;
  }
}

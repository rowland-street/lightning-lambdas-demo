package com.lightninglambdas;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.lightninglambdas.aws.dynamo.DynamoItemReader;
import com.lightninglambdas.aws.dynamo.DynamoTable;
import com.lightninglambdas.config.Config;
import com.lightninglambdas.config.ConfigProvider;

public class DynamoUserReader {
  private final ConfigProvider configProvider;

  private final DynamoTableProvider dynamoTableProvider;

  private final DynamoItemReader dynamoReader;

  private final UserStringifier userStringifier;

  public DynamoUserReader(
      final ConfigProvider configProvider,
      final DynamoTableProvider dynamoTableProvider,
      final DynamoItemReader dynamoReader,
      final UserStringifier userStringifier) {
    this.configProvider = configProvider;
    this.dynamoTableProvider = dynamoTableProvider;
    this.dynamoReader = dynamoReader;
    this.userStringifier = userStringifier;
  }

  public String execute(final String id) {
    final Config config = configProvider.execute();
    final DynamoTable dynamoTable = dynamoTableProvider.execute(config);
    final Item item = dynamoReader.execute(dynamoTable, id);
    final String userJson = userStringifier.execute(item);
    return userJson;
  }
}

package com.lightninglambdas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.lightninglambdas.aws.dynamo.DynamoItemReader;
import com.lightninglambdas.aws.dynamo.DynamoTable;
import com.lightninglambdas.config.Config;
import com.lightninglambdas.config.ConfigProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DynamoUserReaderTest {
  /** Variables */
  private static final String userId;

  private static final String json;

  private static final DynamoTable table;

  private static final Config config;

  private static final Item item;

  /** Mocked dependencies */
  private ConfigProvider configProvider;

  private DynamoItemReader dynamoReader;

  /** Test fixture */
  private DynamoUserReader dynamoUserReader;

  static {
    userId = "userId";
    json = "{\"name\":\"tom\"}";
    table = new DynamoTable("region", "tableName", "idField");
    config = new Config(null, table);
    item = new Item().withString("name", "tom");
  }

  @BeforeEach
  public void setupTestFixture() {
    configProvider = mock(ConfigProvider.class);
    dynamoReader = mock(DynamoItemReader.class);

    dynamoUserReader =
        new DynamoUserReader(
            configProvider, new DynamoTableProvider(), dynamoReader, new UserStringifier());
  }

  @Test
  public void test1() {
    when(configProvider.execute()).thenReturn(config);
    when(dynamoReader.execute(table, userId)).thenReturn(item);

    assertEquals(
        json,
        dynamoUserReader.execute(userId),
        "Given a config and a dynamo response it should return a json of that response");
  }
}

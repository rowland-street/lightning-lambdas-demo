package com.lightninglambdas;

import com.amazonaws.services.dynamodbv2.document.Item;

public class UserStringifier {
  public String execute(final Item item) {

    String userJson = item.toJSON();
    return userJson;
  }
}

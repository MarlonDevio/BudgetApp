package io.marlondevio.core;

import io.marlondevio.core.financial_entities.Category;
import java.util.HashSet;
import java.util.Set;

public class BankAccount {
  private static BankAccount instance;
  Set<Category> categorySet;
  private BankAccount(){
    this.categorySet = new HashSet<>();
  }

  public static BankAccount getInstance(){
    return instance == null ? new BankAccount() : instance;
  }

  public Set<Category> getCategorySet() {
    return categorySet;
  }
}

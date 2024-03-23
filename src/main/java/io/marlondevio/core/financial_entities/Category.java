package io.marlondevio.core.financial_entities;

import io.marlondevio.commands.Command;
import io.marlondevio.helpers.Helper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public abstract class Category {
  protected Map<String, Set<Transaction>> typesAndTransactionSet;
  private String name;

  public Category(String name) {
    setName(name);
    typesAndTransactionSet = new HashMap<>();
  }

  public Map<String, Set<Transaction>> getTypesAndTransactionSet() {
    return typesAndTransactionSet;
  }

  public void addTypeName(String typeName) {
   typesAndTransactionSet.computeIfAbsent(convertFirstLetterToUpper(typeName),
        t -> new HashSet<>());
  }

  public void addTransaction(String typeName, Transaction transaction) {
    addTypeName(typeName);
    getTransactionSet(typeName).add(transaction);
  }

  public void setName(String name) {
    this.name = convertFirstLetterToUpper(name);
  }


  protected Set<Transaction> getTransactionSet(String typeName) {
    String tName = convertFirstLetterToUpper(typeName);
    if (!typesAndTransactionSet.containsKey(tName)) {
      return null;
    }
    return typesAndTransactionSet.get(tName);
  }


  protected String convertFirstLetterToUpper(String typeName) {
    return Helper.firstLetterToUpperCase(typeName);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Category category)) {
      return false;
    }
    return Objects.equals(name, category.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}

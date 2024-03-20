package io.marlondevio.financial_entities;

import io.marlondevio.commands.Command;
import io.marlondevio.financial_entities.Transaction;
import io.marlondevio.helpers.Helper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Category implements Command {
  private Map<String, Set<Transaction>> typesAndTransactionSet;
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


  private Set<Transaction> getTransactionSet(String typeName) {
    String tName = convertFirstLetterToUpper(typeName);
    if (!typesAndTransactionSet.containsKey(tName)) {
      return null;
    }
    return typesAndTransactionSet.get(tName);
  }


  private String convertFirstLetterToUpper(String typeName) {
    return Helper.firstLetterToUpperCase(typeName);
  }
}

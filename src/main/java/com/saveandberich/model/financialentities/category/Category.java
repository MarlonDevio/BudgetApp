package com.saveandberich.model.financialentities.category;

import com.saveandberich.model.financialentities.transaction.Transaction;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Category class represents a category of transactions. It is an abstract class that provides
 * common functionality for different types of categories.
 */
public abstract class Category {

  protected final List<Transaction> transactionList;
  protected final String categoryName;
  protected String categorySubName;

  /**
   * Constructs a Category object with the specified category name.
   *
   * @param categoryName the name of the category
   */
  public Category(String categoryName) {
    this.categoryName = categoryName;
    transactionList = new ArrayList<>();
  }

  /**
   * This method is called when a transaction is added to the category's transaction list.
   * Subclasses can override this method to perform additional actions when a transaction is added.
   *
   * @param transaction the transaction that was added
   */
  protected abstract void transactionAddedDisplay(Transaction transaction);

  /**
   * Adds a transaction to the category's transaction list. This method also calls the
   * transactionAddedDisplay method to perform any necessary actions.
   *
   * @param transaction the transaction to be added
   */
  public boolean addTransactionToList(Transaction transaction) {
    if (transactionList.stream().anyMatch(tr -> tr.getId().equals(transaction.getId()))) {
      System.out.println("Duplicate transaction. Was not added!");
      return false;
    }
    transactionList.add(transaction);
    return true;
  }

  public boolean removeTransactionFromList(Transaction transaction) {
    return transactionList.remove(transaction);
  }

  /**
   * Returns the list of transactions in the category.
   *
   * @return the list of transactions
   */
  public List<Transaction> getTransactionList() {
    return transactionList;
  }

  /**
   * Returns the name of the category.
   *
   * @return the category name
   */
  public String getCategoryName() {
    return categoryName;
  }

  /**
   * Returns a string representation of the category.
   *
   * @return a string representation of the category
   */
  @Override
  public String toString() {
    return "I am " + categoryName;
  }

  public String getTotalAmount() {
    double total = transactionList.stream().mapToDouble(Transaction::getAmount).sum();
    return "Total " + categoryName + ": " + total;
  }

  public String getCompleteTransactionList() {
    return transactionList.stream()
        .map(transaction -> transaction.getDescription() + " - " + transaction.getAmount())
        .collect(Collectors.joining("\n"));
  }

  public void setCategorySubName(String subName) {
    categorySubName = subName;
  }
}

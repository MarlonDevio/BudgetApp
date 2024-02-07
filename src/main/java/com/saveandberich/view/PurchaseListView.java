package com.saveandberich.view;

import com.saveandberich.model.service.UpdatedInfo;

/**
 * This class represents a view for displaying a list of purchase transactions.
 * It extends the View class and overrides the display and update methods.
 */
public class PurchaseListView extends View {

  /**
   * Displays the list of purchase transactions.
   * Each transaction's description and amount are printed to the console.
   */
  @Override
  public void display() {
    transactionList
        .forEach(transaction -> System.out.println(transaction.getDescription() + " " + transaction.getAmount()));
  }

  /**
   * Updates the transaction list with the latest expense transactions.
   * 
   * @param info The updated information containing all expense transactions.
   */
  @Override
  public void update(UpdatedInfo info) {
    transactionList = info.getAllExpenseTransactions();
  }
}

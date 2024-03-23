package io.marlondevio.core.financial_entities;

public class Transaction {

  private static int counter;
  private final String id;
  private final int current;
  private String description;
  private double amount;

  {
    counter++;
    current = counter;
  }

  public Transaction(String description, double amount) {
    setDescription(description);
    if (!this.setAmount(amount)) {
      System.out.println("Value can not be less or equal to 0");
    }
    this.id = current + "-" + description.replaceAll(" ", "") + "-" + amount;
  }

  public boolean setAmount(double amount) {
    if (amount <= 0) {
      return false;
    }
    this.amount = amount;
    return true;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Transaction{");
    sb.append("description='").append(description).append('\'');
    sb.append('}');
    return sb.toString();
  }

  public String getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  private void setDescription(String description) {
    this.description =
        description.trim().substring(0, 1).toUpperCase() + description.trim().substring(1);
  }

  public double getAmount() {
    return amount;
  }
}

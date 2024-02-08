package com.saveandberich;

import com.saveandberich.model.financialentities.category.Category;
import com.saveandberich.model.financialentities.category.ExpenseCategory;
import com.saveandberich.model.financialentities.category.IncomeCategory;
import com.saveandberich.model.financialentities.transaction.Transaction;
import com.saveandberich.model.pattern.command.AddTransactionCommand;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

//    ViewController viewController = new ViewController();
//    viewController.init();

    Transaction tr1 = new Transaction("income", 500, "+");
    Transaction tr3 = new Transaction("income", 5322, "+");

    Category category = new IncomeCategory("income");

    Category category2 = new ExpenseCategory("expense");
    Transaction tr2 = new Transaction("expense", 250, "-");

    AddTransactionCommand addTransactionCommand = new AddTransactionCommand(tr1, category);

    addTransactionCommand.execute();
    addTransactionCommand.setTransaction(tr3);
    addTransactionCommand.execute();
    addTransactionCommand.execute();
    addTransactionCommand.undo();
    addTransactionCommand.execute();
    System.out.println(
        category.getCompleteTransactionList()
    );

    System.out.println("-----");
    List<Transaction> list = new ArrayList<>();
    list.add(tr1);
    list.add(tr3);
    list.add(tr2);

    list.forEach(li -> System.out.println(li.getAmount()));
    System.out.println("----");
    list.remove(tr1);
    list.forEach(li -> System.out.println(li.getAmount()));
    System.out.println("------");
    list.forEach(li -> System.out.println(li.getAmount()));

  }
}

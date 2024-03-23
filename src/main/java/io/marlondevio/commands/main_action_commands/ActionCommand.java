package io.marlondevio.commands.main_action_commands;

import io.marlondevio.commands.Command;
import io.marlondevio.core.BankAccount;
import io.marlondevio.helpers.Helper;

public abstract class ActionCommand implements Command {
  protected BankAccount bankAccount = BankAccount.getInstance();
  private String name;

  public ActionCommand(String name){
    setName(name);
  }


  @Override
  public void setName(String name) {
    this.name = Helper.firstLetterToUpperCase(name);
  }

  @Override
  public String toString() {
    return this.name;
  }
}

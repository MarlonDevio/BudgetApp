package io.marlondevio.commands.main_action_commands.purchase_commands;

import io.marlondevio.commands.Command;
import io.marlondevio.commands.main_action_commands.ActionCommand;

public abstract class PurchaseCommand extends ActionCommand implements Command {

  public PurchaseCommand(String name) {
    super(name);
  }


}

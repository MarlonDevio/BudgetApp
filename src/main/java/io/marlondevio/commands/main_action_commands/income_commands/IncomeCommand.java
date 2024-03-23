package io.marlondevio.commands.main_action_commands.income_commands;

import io.marlondevio.commands.Command;
import io.marlondevio.commands.main_action_commands.ActionCommand;

public abstract class IncomeCommand extends ActionCommand implements Command {

  @Override
  public void execute() {

  }

  public IncomeCommand(String name) {
    super(name);
  }
}

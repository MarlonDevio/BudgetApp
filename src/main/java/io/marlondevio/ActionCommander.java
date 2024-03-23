package io.marlondevio;

import io.marlondevio.commands.Command;
import io.marlondevio.commands.Commander;
import io.marlondevio.core.BankAccount;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ActionCommander implements Commander {
  private List<Command> commands;

  public ActionCommander(){
    this.commands = new ArrayList<>();
  }
  @Override
  public void addCommand(Command command) {
   commands.add(command);
  }

  @Override
  public List<Command> getCommands() {
    return this.commands;

    }

  }

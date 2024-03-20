package io.marlondevio.commands.main_action_commands;

import io.marlondevio.commands.Command;
import io.marlondevio.helpers.Helper;

public abstract class MainActionCommand implements Command {
  private String name;

  public MainActionCommand(String name){
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

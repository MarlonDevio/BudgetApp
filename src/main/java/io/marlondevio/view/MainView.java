package io.marlondevio.view;

import io.marlondevio.commands.Command;
import io.marlondevio.commands.Commander;
import java.util.List;

public class MainView extends View {

  @Override
  public void display() {
    Commander commander = getCommander();
    List<Command> commandList = commander.getCommands();

    int commandNumber;
    for (int i = 0; i < commandList.size(); i++) {
      commandNumber = i == commandList.size() - 1 ? 0 : i + 1;
      System.out.println(commandNumber + ") " + commandList.get(i));
    }
  }
}

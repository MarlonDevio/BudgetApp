package io.marlondevio;


import io.marlondevio.commands.Command;
import io.marlondevio.commands.Commander;
import io.marlondevio.commands.main_action_commands.ActionCommander;
import io.marlondevio.commands.main_action_commands.Exit;
import io.marlondevio.commands.main_action_commands.IncomeCommand;
import io.marlondevio.commands.main_action_commands.PurchaseCommand;
import io.marlondevio.commands.main_action_commands.PurchaseListCommand;
import io.marlondevio.commands.main_action_commands.ShowBalance;
import io.marlondevio.view.MainView;
import io.marlondevio.view.View;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    ActionCommander actionCommander = new ActionCommander();
    // 1) initializing Commands
    Command incomeCommand = new IncomeCommand("Add Income");
    Command purchaseCommand = new PurchaseCommand("Add Purchase");
    Command purchaseListCommand = new PurchaseListCommand("Show list of purchases");
    Command balanceCommand = new ShowBalance("Balance");
    Command exitCommand = new Exit("Exit");

    // 2) Initializing commander and adding commands
    Commander commander = actionCommander;

    commander.addCommand(incomeCommand);
    commander.addCommand(purchaseCommand);
    commander.addCommand(purchaseListCommand);
    commander.addCommand(balanceCommand);
    commander.addCommand(exitCommand);
    List<Command> commandList = commander.getCommands();

    // 3) Initializing MainView
    View mainView = new MainView();

    // 4) set commander to display the proper view
    mainView.setCommander(commander);
    mainView.display();

    // 5) get user input for mainaction
    int inp = 0;
    Command command = null;
    do {
      try {
        inp = getIntInput();
        command = commandList.get(inp-1);
      } catch (NumberFormatException e) {
        System.out.println(e.getMessage());
      } catch (IndexOutOfBoundsException e){
        System.out.println(e.getMessage());
      }
    } while(inp < 0 || inp > commandList.size() || inp == 0);
    System.out.println(command);
  }
  

  public static String getInput() {
    return scanner.nextLine();
  }

  public static int getIntInput() throws NumberFormatException {
    return Integer.parseInt(getInput());
  }
}

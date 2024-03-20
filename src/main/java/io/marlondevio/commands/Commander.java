package io.marlondevio.commands;

import java.util.List;

public interface Commander {
  public void addCommand(Command command);


  public List<Command> getCommands();


//public void add (){
//  addCommand("Show income");
//  addCommand("Show purchases");
//  addCommand("Show purchaselist");
//  addCommand("Balance");
//  addCommand("Exit");
// }


}

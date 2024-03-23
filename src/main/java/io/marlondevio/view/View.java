package io.marlondevio.view;

import io.marlondevio.commands.Commander;

public abstract class View {
private Commander commander;

public void setCommander(Commander commander){
  this.commander = commander;
}

public Commander getCommander(){
  return this.commander;
}
public abstract void display();


}

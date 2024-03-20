package io.marlondevio.commands;

public interface Command {
  void execute();
  void setName(String name);
}

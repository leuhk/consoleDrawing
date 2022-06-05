package com.consoleDrawing.command;

import java.util.Arrays;

import com.consoleDrawing.exception.InvalidParamsException;

public class CommandFactory {

  public Command getCommand(String commandLine) throws InvalidParamsException {
    commandLine = commandLine.trim();
    String[] split = commandLine.split("\\s+");
    String main = split[0].toUpperCase();
    String[] params = Arrays.copyOfRange(split, 1, split.length);

    switch (main) {
      case "Q":
        return new QuitCommand();
      case "C":
        return new CreateCommand(params);
      case "L":
        return new DrawLineCommand(params);
      case "R":
        return new DrawRectangleCommand(params);
      case "B":
        return new BucketFillCommand(params);
      default:
        throw new InvalidParamsException("Command Invalid");
    }

  }
}

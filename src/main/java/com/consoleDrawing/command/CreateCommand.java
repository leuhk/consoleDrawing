package com.consoleDrawing.command;

import com.consoleDrawing.exception.*;

public class CreateCommand implements Command {

  private int height;
  private int width;

  public CreateCommand(String[] params) {
    if (params.length != 2) {
      throw new InvalidParamsException("Create Command expects 2 paramaters only");
    }
    try {
      // add checking for negative interger
      width = Integer.parseInt(params[0]);
      height = Integer.parseInt(params[1]);
      if (width < 0 || height < 0) {
        throw new InvalidParamsException("Number must be a postive interger");
      }
    } catch (IllegalArgumentException e) {
      throw new InvalidParamsException("Width and Height must be an interger where N>=0");
    }
  }

  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }
}

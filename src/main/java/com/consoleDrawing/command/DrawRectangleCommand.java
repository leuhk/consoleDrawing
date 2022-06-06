package com.consoleDrawing.command;

import com.consoleDrawing.exception.InvalidParamsException;

public class DrawRectangleCommand extends DrawEntityCommand {
  private int x1;
  private int y1;
  private int x2;
  private int y2;

  public DrawRectangleCommand(String[] params) {
    if (params.length != 4) {
      throw new InvalidParamsException("Draw Rectangle command expects 4 paramaters only");
    }
    try {
      x1 = Integer.parseInt(params[0]);
      y1 = Integer.parseInt(params[1]);
      x2 = Integer.parseInt(params[2]);
      y2 = Integer.parseInt(params[3]);
      if (x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0) {
        throw new InvalidParamsException("Number must be a postive interger");
      }
    } catch (IllegalArgumentException e) {
      throw new InvalidParamsException("Width and Height must be an interger where N>=0");
    }
  }

  public int getX1() {
    return x1;
  }

  public int getY1() {
    return y1;
  }

  public int getX2() {
    return x2;
  }

  public int getY2() {
    return y2;
  }

}

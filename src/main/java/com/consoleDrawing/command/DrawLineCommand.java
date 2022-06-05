package com.consoleDrawing.command;

import com.consoleDrawing.exception.InvalidParamsException;

public class DrawLineCommand extends DrawEntityCommand {

  private int x1;
  private int y1;
  private int x2;
  private int y2;

  public DrawLineCommand(String[] params) {
    if (params.length != 4) {
      throw new InvalidParamsException("Draw Line Command expects 4 paramaters only");
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

  public DrawLineCommand setX1(int x1) {
    this.x1 = x1;
    return this;
  }

  public int getY1() {
    return y1;
  }

  public DrawLineCommand setY1(int y1) {
    this.y1 = y1;
    return this;
  }

  public int getX2() {
    return x2;
  }

  public DrawLineCommand setX2(int x2) {
    this.x2 = x2;
    return this;
  }

  public int getY2() {
    return y2;
  }

  public DrawLineCommand setY2(int y2) {
    this.y2 = y2;
    return this;
  }

}

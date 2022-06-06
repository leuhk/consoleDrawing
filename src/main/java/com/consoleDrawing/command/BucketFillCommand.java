package com.consoleDrawing.command;

import com.consoleDrawing.exception.InvalidParamsException;

public class BucketFillCommand extends DrawEntityCommand {
  private int x;
  private int y;
  private char character;

  public BucketFillCommand(String[] params) {
    if (params.length != 3) {
      throw new InvalidParamsException("Bucket fill command expect 3 paramters");
    }
    if (params[2].length() != 1) {
      throw new InvalidParamsException("Color character should only be 1 character");
    }

    try {
      x = Integer.parseInt(params[0]);
      y = Integer.parseInt(params[1]);
      if (x < 0 || y < 0) {
        throw new InvalidParamsException("Number must be a postive interger");
      }
      character = params[2].charAt(0);
    } catch (IllegalArgumentException e) {
      throw new InvalidParamsException("x or y should be >0");
    }
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public char getCharacter() {
    return character;
  }

}

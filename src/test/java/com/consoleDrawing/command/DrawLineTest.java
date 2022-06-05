package com.consoleDrawing.command;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.consoleDrawing.exception.InvalidParamsException;

public class DrawLineTest {

  @Test
  public void testDrawLineCommand1() throws Exception {
    String[] params = new String[] { "6", "3", "6", "4" };
    new DrawLineCommand(params);
  }

  @Test(expected = InvalidParamsException.class)
  public void testDrawLineCommand2() throws Exception {
    try {
      String[] params = new String[] { "1", "2", "3" };
      new DrawLineCommand(params);
    } catch (InvalidParamsException e) {
      String message = "Draw Line Command expects 4 paramaters only";
      assertEquals(message, e.getMessage());
      throw e;
    }
  }

  @Test(expected = InvalidParamsException.class)
  public void testDrawLineCommand3() throws Exception {
    try {
      String[] params = new String[] { "-20", "-10", "1", "2" };
      new DrawLineCommand(params);
    } catch (InvalidParamsException e) {
      String message = "Number must be a postive interger";
      assertEquals(message, e.getMessage());
      throw e;
    }
  }

  @Test(expected = InvalidParamsException.class)
  public void testDrawLineCommand4() throws Exception {
    String[] params = new String[] { "abc", "def" };
    new DrawLineCommand(params);
  }

  @Test
  public void testGetX1() {
    String[] params = new String[] { "6", "3", "6", "4" };
    DrawLineCommand command = new DrawLineCommand(params);
    assertEquals("Getting X1", 6, command.getX1());
  }

  @Test
  public void testGetX2() {
    String[] params = new String[] { "6", "3", "6", "4" };
    DrawLineCommand command = new DrawLineCommand(params);
    assertEquals("Getting X2", 6, command.getX2());
  }

  @Test
  public void testGetY1() {
    String[] params = new String[] { "6", "3", "6", "4" };
    DrawLineCommand command = new DrawLineCommand(params);
    assertEquals("Getting Y1", 3, command.getY1());
  }

  @Test
  public void testGetY2() {
    String[] params = new String[] { "6", "3", "6", "4" };
    DrawLineCommand command = new DrawLineCommand(params);
    assertEquals("Getting Y2", 4, command.getY2());
  }
}

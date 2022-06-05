package com.consoleDrawing.command;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.consoleDrawing.exception.InvalidParamsException;

public class DrawRectangleCommandTest {
  @Test
  public void testDrawRectangleCommand1() throws Exception {
    String[] params = new String[] { "14", "1", "18", "3" };
    new DrawRectangleCommand(params);
  }

  @Test(expected = InvalidParamsException.class)
  public void testDrawRectangleCommand2() throws Exception {
    String[] params = new String[] { "1", "2", "3" };
    new DrawRectangleCommand(params);
  }

  @Test(expected = InvalidParamsException.class)
  public void testDrawRectangleCommand3() throws Exception {
    String[] params = new String[] { "14", "1", "-18", "3" };
    new DrawRectangleCommand(params);
  }

  @Test(expected = InvalidParamsException.class)
  public void testDrawRectangleCommand4() throws Exception {
    String[] params = new String[] { "abc", "def" };
    new DrawRectangleCommand(params);
  }

  @Test
  public void testGetX1() {
    String[] params = new String[] { "14", "1", "18", "3" };
    DrawRectangleCommand command = new DrawRectangleCommand(params);
    assertEquals("Getting X1", 14, command.getX1());
  }

  @Test
  public void testGetX2() {
    String[] params = new String[] { "14", "1", "18", "3" };
    DrawRectangleCommand command = new DrawRectangleCommand(params);
    assertEquals("Getting X2", 18, command.getX2());
  }

  @Test
  public void testGetY1() {
    String[] params = new String[] { "14", "1", "18", "3" };
    DrawRectangleCommand command = new DrawRectangleCommand(params);
    assertEquals("Getting Y1", 1, command.getY1());
  }

  @Test
  public void testGetY2() {
    String[] params = new String[] { "14", "1", "18", "3" };
    DrawRectangleCommand command = new DrawRectangleCommand(params);
    assertEquals("Getting Y2", 3, command.getY2());
  }

}

package com.consoleDrawing.command;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.consoleDrawing.exception.InvalidParamsException;

public class CreateCommandTest {

  @Test
  public void testCreateCommand() throws Exception {
    String[] params = new String[] { "1", "2" };
    new CreateCommand(params);
  }

  @Test(expected = InvalidParamsException.class)
  public void testCreateCommand2() throws Exception {
    try {
      String[] params = new String[] { "1", "2", "3" };
      new CreateCommand(params);
    } catch (InvalidParamsException e) {
      String message = "Create Command expects 2 paramaters only";
      assertEquals(message, e.getMessage());
      throw e;
    }

  }

  @Test(expected = InvalidParamsException.class)
  public void testCreateCommand3() throws Exception {
    try {
      String[] params = new String[] { "-20", "-10" };
      new CreateCommand(params);
    } catch (InvalidParamsException e) {
      String message = "Number must be a postive interger";
      assertEquals(message, e.getMessage());
      throw e;
    }
  }

  @Test(expected = InvalidParamsException.class)
  public void testCreateCommand4() throws Exception {
    try {
      String[] params = new String[] { "abc", "def" };
      new CreateCommand(params);
    } catch (InvalidParamsException e) {
      String message = "Width and Height must be an interger where N>=0";
      assertEquals(message, e.getMessage());
      throw e;
    }
  }

  @Test
  public void testGetHeight() {
    String[] params = new String[] { "20", "4" };
    CreateCommand command = new CreateCommand(params);
    assertEquals("Getting Height", 4, command.getHeight());
  }

  @Test
  public void testGetWidth() {
    String[] params = new String[] { "20", "4" };
    CreateCommand command = new CreateCommand(params);
    assertEquals("Getting Width", 20, command.getWidth());
  }

}

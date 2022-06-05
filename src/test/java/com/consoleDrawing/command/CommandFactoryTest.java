package com.consoleDrawing.command;

import static org.junit.Assert.assertEquals;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.consoleDrawing.exception.InvalidParamsException;

public class CommandFactoryTest {

  private CommandFactory commandFactory;

  @Before
  public void setUp() throws Exception {
    commandFactory = new CommandFactory();
  }

  @Test
  public void getCommand1() throws Exception {
    Command command = commandFactory.getCommand("Q");
    Assert.assertThat(command, CoreMatchers.instanceOf(QuitCommand.class));
  }

  @Test
  public void getCommand2() throws Exception {
    Command command = commandFactory.getCommand("C 20 4");
    Assert.assertThat(command, CoreMatchers.instanceOf(CreateCommand.class));
  }

  @Test
  public void getCommand3() throws Exception {
    Command command = commandFactory.getCommand("L 1 2 6 2");
    Assert.assertThat(command, CoreMatchers.instanceOf(DrawLineCommand.class));
  }

  @Test
  public void getCommand4() throws Exception {
    Command command = commandFactory.getCommand("R 14 1 18 3");
    Assert.assertThat(command, CoreMatchers.instanceOf(DrawRectangleCommand.class));
  }

  @Test
  public void getCommand5() throws Exception {
    Command command = commandFactory.getCommand("B 10 3 o");
    Assert.assertThat(command, CoreMatchers.instanceOf(BucketFillCommand.class));
  }

  @Test(expected = InvalidParamsException.class)
  public void getCommand6() throws Exception {
    commandFactory.getCommand("AAAA");
  }

  @Test(expected = InvalidParamsException.class)
  public void getCommand7() throws Exception {
    try {
      commandFactory.getCommand("Test Fail");
    } catch (InvalidParamsException e) {
      String message = "Command Invalid";
      assertEquals(message, e.getMessage());
      throw e;
    }

  }

}

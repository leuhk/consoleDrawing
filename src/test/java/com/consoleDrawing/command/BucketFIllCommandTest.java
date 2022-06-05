package com.consoleDrawing.command;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.consoleDrawing.exception.InvalidParamsException;

public class BucketFIllCommandTest {

  @Test
  public void testBucketFillCommand1() throws Exception {
    String[] params = new String[] { "10", "3", "o" };
    new BucketFillCommand(params);
  }

  @Test(expected = InvalidParamsException.class)
  public void testBucketFillCommand2() throws Exception {
    String[] params = new String[] { "1", "2", "a", "e" };
    new BucketFillCommand(params);
  }

  @Test(expected = InvalidParamsException.class)
  public void testDrawRectangleCommand3() throws Exception {
    String[] params = new String[] { "10", "-2", "o" };
    new BucketFillCommand(params);
  }

  @Test
  public void testGetX() {
    String[] params = new String[] { "10", "3", "o" };
    BucketFillCommand command = new BucketFillCommand(params);
    assertEquals("Getting X", 10, command.getX());
  }

  @Test
  public void testGetY() {
    String[] params = new String[] { "10", "3", "o" };
    BucketFillCommand command = new BucketFillCommand(params);
    assertEquals("Getting Y", 3, command.getY());
  }

  @Test
  public void testGetCharacter() {
    String[] params = new String[] { "10", "3", "o" };
    BucketFillCommand command = new BucketFillCommand(params);
    assertEquals("Getting character", 'o', command.getCharacter());
  }
}

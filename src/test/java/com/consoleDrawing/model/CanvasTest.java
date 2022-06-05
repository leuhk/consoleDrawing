package com.consoleDrawing.model;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.consoleDrawing.exception.InvalidParamsException;

public class CanvasTest {
  private Canvas canvas;

  @Before
  public void setUp() throws Exception {
    canvas = new Canvas(20, 4);
  }

  // empty canvas
  @Test
  public void create() throws Exception {

    Assert.assertEquals(canvas.render(),
        "----------------------\n" +
            "|                    |\n" +
            "|                    |\n" +
            "|                    |\n" +
            "|                    |\n" +
            "----------------------");
  }

  // add horizontal line
  @Test
  public void addHorizontalLine() throws Exception {
    canvas.addLine(1, 2, 6, 2);
    Assert.assertEquals(canvas.render(),
        "----------------------\n" +
            "|                    |\n" +
            "|xxxxxx              |\n" +
            "|                    |\n" +
            "|                    |\n" +
            "----------------------");
  }

  // add horizontal line
  @Test
  public void addVerticalLine() throws Exception {
    canvas.addLine(1, 2, 6, 2);
    canvas.addLine(6, 3, 6, 4);

    Assert.assertEquals(canvas.render(),
        "----------------------\n" +
            "|                    |\n" +
            "|xxxxxx              |\n" +
            "|     x              |\n" +
            "|     x              |\n" +
            "----------------------");

  }

  // add rectangle
  @Test
  public void addRectangle() throws Exception {
    canvas.addRectangle(14, 1, 18, 3);

    Assert.assertEquals(canvas.render(),
        "----------------------\n" +
            "|             xxxxx  |\n" +
            "|             x   x  |\n" +
            "|             xxxxx  |\n" +
            "|                    |\n" +
            "----------------------");

  }

  // add lines and rectangle
  @Test
  public void addLinesAndRectangles() throws Exception {
    canvas.addLine(1, 2, 6, 2);
    canvas.addLine(6, 3, 6, 4);
    canvas.addRectangle(14, 1, 18, 3);
    Assert.assertEquals(canvas.render(),
        "----------------------\n" +
            "|             xxxxx  |\n" +
            "|xxxxxx       x   x  |\n" +
            "|     x       xxxxx  |\n" +
            "|     x              |\n" +
            "----------------------");
  }

  // Fill canvas
  @Test
  public void fillCanvas() throws Exception {
    canvas.bucketFill(5, 2, 'o');
    Assert.assertEquals(canvas.render(),
        "----------------------\n" +
            "|oooooooooooooooooooo|\n" +
            "|oooooooooooooooooooo|\n" +
            "|oooooooooooooooooooo|\n" +
            "|oooooooooooooooooooo|\n" +
            "----------------------");
  }

  // Add Lines, Add rectangle and Fill
  @Test
  public void combine() throws Exception {
    canvas.addLine(1, 2, 6, 2);
    canvas.addLine(6, 3, 6, 4);
    canvas.addRectangle(14, 1, 18, 3);
    canvas.bucketFill(10, 3, 'o');
    Assert.assertEquals(canvas.render(),
        "----------------------\n" +
            "|oooooooooooooxxxxxoo|\n" +
            "|xxxxxxooooooox   xoo|\n" +
            "|     xoooooooxxxxxoo|\n" +
            "|     xoooooooooooooo|\n" +
            "----------------------");
  }

  @Test(expected = IllegalArgumentException.class)
  public void addLineException() throws IllegalArgumentException {
    try {
      canvas.addLine(1, 3, 6, 2);
    } catch (IllegalArgumentException e) {
      String message = "Draw line does not support diagonal line at the moment";
      assertEquals(message, e.getMessage());
      throw e;
    }
  }

  @Test(expected = InvalidParamsException.class)
  public void addLineException2() throws InvalidParamsException {
    try {
      canvas.addLine(0, 3, 0, 2);
    } catch (InvalidParamsException e) {
      String message = "Line is not within the canvas";
      assertEquals(message, e.getMessage());
      throw e;
    }
  }

  @Test(expected = InvalidParamsException.class)
  public void bucketFillException2() throws InvalidParamsException {
    try {
      canvas.bucketFill(0, 3, 'o');
    } catch (InvalidParamsException e) {
      String message = "Bucket Fill point is not within the canvas";
      assertEquals(message, e.getMessage());
      throw e;
    }
  }

}

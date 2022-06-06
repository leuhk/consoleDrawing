package com.consoleDrawing.model;

import com.consoleDrawing.exception.InvalidParamsException;

public class Canvas {

  private final char HORIZONTAL_EDGE_CHAR = '-';
  private final char VERTICAL_EDGE_CHAR = '|';
  private final char LINE_CHAR = 'x';
  private final char EMPTY_CHAR = ' ';
  private int height;
  private int width;
  private char[][] canvasArray;
  private String horizontalEdge = "";

  public Canvas(int w, int h) {
    width = w;
    height = h;
    canvasArray = new char[this.height][this.width];

    // add empty canvas
    for (int row = 0; row < canvasArray.length; row++) {
      for (int col = 0; col < canvasArray[row].length; col++) {
        canvasArray[row][col] = EMPTY_CHAR;
      }
    }

    // add horizontal edges
    for (int i = 0; i < this.width + 2; i++) {
      horizontalEdge += HORIZONTAL_EDGE_CHAR;
    }
  };

  public String render() {
    StringBuilder builder = new StringBuilder();
    builder.append(horizontalEdge).append("\n");

    for (int i = 0; i < this.height; i++) {
      builder.append(VERTICAL_EDGE_CHAR);
      for (int j = 0; j < this.width; j++) {
        builder.append(canvasArray[i][j]);
      }
      builder.append(VERTICAL_EDGE_CHAR);
      builder.append("\n");
    }

    builder.append(horizontalEdge);
    return builder.toString();
  };

  public void addLine(int x1, int y1, int x2, int y2) {

    if (isOutofRange(x1, y1) || isOutofRange(x2, y2)) {
      throw new InvalidParamsException("Line is not within the canvas");
    }

    if (x1 != x2 && y1 != y2) {
      throw new IllegalArgumentException("Draw line does not support diagonal line at the moment");
    }
    if ((x1 == x2 && y1 > y2) || (y1 == y2 && x1 > x2)) {
      int tempX = x1;
      int tempY = y1;
      x1 = x2;
      y1 = y2;
      x2 = tempX;
      y2 = tempY;
    }
    drawLine(x1, y1, x2, y2);
  }

  public void addRectangle(int x1, int y1, int x2, int y2) {

    if (isOutofRange(x1, y1) || isOutofRange(x2, y2)) {
      throw new InvalidParamsException("Rectangle is not within the canvas");
    }

    if (x1 == x2 || y1 == y2) {
      throw new IllegalArgumentException("Provided paramters is not a sqaure!");
    }
    if (y1 > y2) {
      int tempY = y1;
      y1 = y2;
      y2 = tempY;
    }
    if (x1 > x2) {
      int tempX = x1;
      x1 = x2;
      x2 = tempX;
    }

    // Top edge
    drawLine(x1, y1, x2, y1);
    // Bottom edge
    drawLine(x1, y2, x2, y2);
    // Left edge
    drawLine(x1, y1, x1, y2);
    // Right edge
    drawLine(x2, y1, x2, y2);
  }

  public void bucketFill(int x, int y, char ch) {

    if (isOutofRange(x, y)) {
      throw new InvalidParamsException("Bucket Fill point is not within the canvas");
    }

    fill(x - 1, y - 1, ch);
  }

  private void fill(int x, int y, char ch) {
    // prevent out of range
    if (x < 0 || x >= width || y < 0 || y >= height) {
      return;
    }
    // Base case
    if (canvasArray[y][x] == LINE_CHAR || canvasArray[y][x] == ch) {
      return;
    }
    canvasArray[y][x] = ch;
    // Recursion
    fill(x + 1, y, ch);
    fill(x - 1, y, ch);
    fill(x, y - 1, ch);
    fill(x, y + 1, ch);
  }

  private void drawLine(int x1, int y1, int x2, int y2) {
    for (int row = y1 - 1; row <= y2 - 1 && row < height; row++) {
      for (int col = x1 - 1; col <= x2 - 1 && col < width; col++) {
        canvasArray[row][col] = LINE_CHAR;
      }
    }
  }

  private boolean isOutofRange(int x, int y) {
    return x < 1 || x > width || y < 1 || y > height;
  }
}

# Console drawing

## Description
A simple console drawing programing to draw on a blank canvas.

the program should work as follows:
 1. Create a new canvas
 2. Start drawing on the canvas by issuing various commands
 3. Quit

| Command       | Description   |
| ------------- |:-------------:|
| C w h       | Should create a new canvas of width w and height h. |
| L x1 y1 x2 y2 | Should create a new line from (x1,y1) to (x2,y2). Currently only horizontal or vertical lines are supported. Horizontal and vertical lines will be drawn using the 'x' character.      |
| R x1 y1 x2 y2 | Should create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2). Horizontal and vertical lines will be drawn using the 'x' character.      |
| B x y c       | Should fill the entire area connected to (x,y) with "colour" c. The behavior of this is the same as that of the "bucket fill" tool in paint programs.|
| Q             | Should quit the program.|

## Prerequisites
Java [JDK 8+] and Apache Maven

## Installation
To run:
```
mvn exec:java
```
run test case:
```
mvn test
```
compile and package:
```
mvn clean package
```
Run Jar
```
java -jar target/consoleDrawing-1.0.jar
```

## Sample I/O

Below is a sample run of the program. User input is prefixed with enter command:

```
enter command: C 20 4
----------------------
|                    |
|                    |
|                    |
|                    |
----------------------

enter command: L 1 2 6 2
----------------------
|                    |
|xxxxxx              |
|                    |
|                    |
----------------------

enter command: L 6 3 6 4
----------------------
|                    |
|xxxxxx              |
|     x              |
|     x              |
----------------------

enter command: R 14 1 18 3
----------------------
|             xxxxx  |
|xxxxxx       x   x  |
|     x       xxxxx  |
|     x              |
----------------------

enter command: B 10 3 o
----------------------
|oooooooooooooxxxxxoo|
|xxxxxxooooooox   xoo|
|     xoooooooxxxxxoo|
|     xoooooooooooooo|
----------------------

enter command: Q
```

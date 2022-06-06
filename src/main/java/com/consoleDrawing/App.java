package com.consoleDrawing;

import java.util.Scanner;
import com.consoleDrawing.exception.*;
import com.consoleDrawing.model.*;
import com.consoleDrawing.command.*;

public class App {

    private static Scanner scanner;
    private static CommandFactory commandFactory;
    private static Canvas canvas = null;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        commandFactory = new CommandFactory();
        printHelp();
        while (true) {
            System.out.println("Enter command:");
            process(scanner.nextLine());
        }

    }

    private static void process(String commandLine) {
        Command command = null;

        try {
            command = commandFactory.getCommand(commandLine);

            if (command instanceof QuitCommand) {
                quit();
            }

            if (command instanceof CreateCommand) {
                int width = ((CreateCommand) command).getWidth();
                int height = ((CreateCommand) command).getHeight();
                canvas = new Canvas(width, height);
                System.out.println(canvas.render());
            }

            if (command instanceof DrawEntityCommand) {
                if (canvas == null) {
                    System.out.println("You need to create a canvas first");
                    return;
                }
                if (command instanceof DrawLineCommand) {

                    canvas.addLine(
                            ((DrawLineCommand) command).getX1(),
                            ((DrawLineCommand) command).getY1(),
                            ((DrawLineCommand) command).getX2(),
                            ((DrawLineCommand) command).getY2());
                }

                if (command instanceof DrawRectangleCommand) {
                    canvas.addRectangle(
                            ((DrawRectangleCommand) command).getX1(),
                            ((DrawRectangleCommand) command).getY1(),
                            ((DrawRectangleCommand) command).getX2(),
                            ((DrawRectangleCommand) command).getY2());

                }
                if (command instanceof BucketFillCommand) {
                    canvas.bucketFill(
                            ((BucketFillCommand) command).getX(),
                            ((BucketFillCommand) command).getY(),
                            ((BucketFillCommand) command).getCharacter());
                }
                System.out.println(canvas.render());
            }

        } catch (InvalidParamsException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void quit() {
        scanner.close();
        System.out.println("Exiting....");
        System.exit(0);
    }

    private static void printHelp() {
        String help = "The work as follows:\n"
                + "1. Create a new canvas \n"
                + "2. Draw on the canvas by issuing various commands \n"
                + "3. Quit \n\n\n"
                + "|Command 		|Description|\n"
                + "|----|----|\n"
                + "|C w h          | Create a new canvas of width w and height h.|\n"
                + "|L x1 y1 x2 y2  | Draw a new line from (x1,y1) to (x2,y2). Currently, only|\n"
                + "|               | horizontal or vertical lines are supported. Horizontal and vertical lines|\n"
                + "|               | will be drawn using the 'x' character.|\n"
                + "|R x1 y1 x2 y2  | Draw a rectangle whose upper left corner is (x1,y1) and|\n"
                + "|               | lower right corner is (x2,y2). Horizontal and vertical lines will be drawn|\n"
                + "|               | using the 'x' character.|\n"
                + "|B x y c        | Fill the entire area connected to (x,y) with \"colour\" c. The|\n"
                + "|               | behaviour of this is the same as that of the \"bucket fill\" tool in paint|\n"
                + "|               | programs.|\n"
                + "|Q              | Quit|\n";
        System.out.println(help);
    }
}

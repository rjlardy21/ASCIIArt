//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: AsciiArt.java
// Files: Node.java, DrawingStackIterator.java, StackADT.java, AsciiTest.java, DrawingChange.java,
//////////////////// Canvas.java, DrawingStack.java
// Course: CS300 Fall 2018
//
// Author: Reece Lardy
// Email: RLardy@wisc.edu
// Lecturer's Name: Alexander Brooks
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Nick Hayden
// Partner Email: nhayden@wisc.edu
// Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// X Write-up states that pair programming is allowed for this assignment.
// X We have both read and understand the course Pair Programming Policy.
// X We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.Scanner;

public class AsciiArt {
  public static void printMenu() {
    System.out.println("======== MENU ========");
    System.out.println("[1] Create a new canvas");
    System.out.println("[2] Draw a character");
    System.out.println("[3] Undo drawing");
    System.out.println("[4] Redo drawing");
    System.out.println("[5] Show current canvas");
    System.out.println("[6] Show drawing history");
    System.out.println("[7] Exit");
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    boolean playing = true;
    int height = 0;
    int width = 0;
    Canvas can = null;
    int x = 0;
    int y = 0;
    char c = ' ';
    while (playing) {
      printMenu();
      int command = input.nextInt();
      if (command == 1) {
        System.out.println("Height: ");
        height = input.nextInt();
        System.out.println("Width: ");
        width = input.nextInt();
        can = new Canvas(width, height);
      } else if (command == 2) {
        try {
          System.out.println("Row: ");
          y = input.nextInt();
          if (y >= height) {
            System.out.println("Row must be smaller than height.");
            break;
          }
          System.out.println("Col: ");
          x = input.nextInt();
          if (x >= width) {
            System.out.println("Column must be smaller than width.");
            break;
          }
          System.out.println("Char: ");
          c = input.next().charAt(0);
          can.draw(y, x, c);
        } catch (Exception e) {
          System.out.println("Must create a canvas before drawing.");
          break;
        }
      } else if (command == 3) {
        try {
          can.undo();
        } catch (Exception e) {
          System.out.println("Must create a canvas before using undo.");
          break;
        }
      } else if (command == 4) {
        try {
          can.redo();
        } catch (Exception e) {
          System.out.println("Must create a canvas before using redo.");
          break;
        }
      } else if (command == 5) {
        try {
          can.printDrawing();
        } catch (Exception e) {
          System.out.println("Must create a canvas before drawing it.");
          break;
        }
      } else if (command == 6) {
        try {
          can.printHistory();
        } catch (Exception e) {
          System.out.println("Must create a canvas before printing history.");
          break;
        }
      } else if (command == 7) {
        playing = false;
        System.out.println("Goodbye!");
      }
    }
    input.close();
  }
}

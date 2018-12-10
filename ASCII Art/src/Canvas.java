//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Canvas.java
// Files: DrawingStack.java, Node.java, DrawingStackIterator.java, StackADT.java, AsciiTest.java,
//////////////////// DrawingChange.java, AsciiArt.java
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
/**
 * This class allows users to create a canvas with inputted height and width, and allows them to
 * make, undo, and redo drawings
 * 
 * @author Reece Lardy
 */
public class Canvas {
  private final int width; // width of the canvas
  private final int height; // height of the canvas
  private char[][] drawingArray; // 2D character array to store the drawing
  private final DrawingStack undoStack; // store previous changes for undo
  private final DrawingStack redoStack; // store undone changes for redo
  private StringBuilder canvasString; // store canvas string representation

  /**
   * Constructor for Canvas
   * 
   * @param width for the width of the canvas
   * @param height for the height of the canvas
   */
  public Canvas(int width, int height) {
    // Throws IllegalArgumentException if width or height is 0 or negative
    if (width <= 0) {
      throw new IllegalArgumentException("Width cannot be 0 or negative.");
    }
    if (height <= 0) {
      throw new IllegalArgumentException("Height cannot be 0 or negative.");
    }
    // A Canvas is initially blank (use the space ' ' character)
    this.width = width;
    this.height = height;
    drawingArray = new char[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        drawingArray[i][j] = ' ';
      }
    }
    // create 2 new empty drawingstacks, 1 for undo, 1 for redo
    undoStack = new DrawingStack();
    redoStack = new DrawingStack();
    // create new stringBuilder
    canvasString = new StringBuilder();
  }

  /**
   * Constructor for Canvas
   * 
   * @param row for the y coord of the canvas
   * @param col for the x coord of the canvas
   * @param c for the character to be drawn
   */
  public void draw(int row, int col, char c) {
    // This method should throw an IllegalArgumentException if the drawing position is outside the
    // canvas
    if (row > height || col > width) {
      throw new IllegalArgumentException("Drawing position is outside of canvas.");
    }
    // If that position is already marked with a different character, overwrite it.
    char prevchar = drawingArray[row][col];
    // After making a new change, add a matching DrawingChange to the undoStack so that we can undo
    // if needed.
    undoStack.push(new DrawingChange(col, row, prevchar, c));
    // After making a new change, the redoStack should be empty.
    while (!redoStack.isEmpty()) {
      redoStack.pop();
    }
    // Draw a character at the given position
    drawingArray[row][col] = c;
  }

  /**
   * Undo the most recent drawing change
   * 
   * @return true if undo is successful, false otherwise
   */
  public boolean undo() {
    // If there is nothing to undo, return false.
    if (undoStack.isEmpty()) {
      return false;
    } else {
      DrawingChange toRedo = undoStack.pop();
      drawingArray[toRedo.y][toRedo.x] = toRedo.prevChar;
      // An undone DrawingChange should be added to the redoStack so that we
      // can redo if needed.
      redoStack.push(toRedo);
      // Return true if successful.
      return true;
    }
  }

  /**
   * Redo the most recent undone drawing change.
   * 
   * @return true if redo is successful, false otherwise
   */
  public boolean redo() {
    // If there is nothing to undo, return false.
    if (redoStack.isEmpty()) {
      return false;
    } else {
      DrawingChange toUndo = redoStack.pop();
      drawingArray[toUndo.y][toUndo.x] = toUndo.newChar;
      // A redone DrawingChange should be added (back) to the undoStack so that
      // we can undo again if needed.
      undoStack.push(toUndo);
      // Return true if successful.
      return true;
    }
  }

  /**
   * Return a string of the entire canvas
   * 
   * @return result, the string holding the entire canvas
   */
  public String toString() {
    //clear the stringbuilder at the start of each toString call
    canvasString.delete(0, canvasString.length());
    // initialize 2 strings to hold result and character value of drawingArray
    String charhold = "";
    // iterate through drawingArray
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        // if character at drawingArray position is blank
        if (drawingArray[i][j] == ' ') {
          // add a _ to result string
          canvasString.append("_");
        } else {
          // otherwise, put character at drawingArray position in charhold as a string and
          // concatenate it to result
          charhold = Character.toString(drawingArray[i][j]);
          canvasString.append(charhold);
        }
      }
      // after iterating through each column, add a newline to the result string
      canvasString.append(System.lineSeparator());
    }
    // Return a printable string version of the Canvas
    return canvasString.toString();
  }

  /**
   * Prints out the string version of the canvas
   */
  public void printDrawing() {
    // print out a call of toString
    System.out.println(this.toString());
  }

  /**
   * Prints out the history of the canvas
   */
  public void printHistory() {
    // initialize int i to 0
    int i = 0;
    // create temp node holding the top of undoStack
    Node<DrawingChange> temp = undoStack.top;
    // while i is less than undoStack size
    while (i < undoStack.size) {
      // print out what was drawn and at which row and column
      System.out.println("Drew: " + temp.getData().newChar + " at row: " + temp.getData().y
          + " at column: " + temp.getData().x);
      // increment temp and i
      temp = temp.getNext();
      i++;
    }
  }
}

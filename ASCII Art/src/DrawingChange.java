//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: DrawingChange.java
// Files: DrawingStack.java, Node.java, DrawingStackIterator.java, StackADT.java, AsciiTest.java,
//////////////////// Canvas.java, AsciiArt.java
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
 * This class allows users to create Drawing Changes with specific input parameters
 * 
 * @author Reece Lardy
 */
public class DrawingChange {
  public final int x; // x coordinate for a change
  public final int y; // y coordinate for a change
  public final char prevChar; // previous character in the (x,y)
  public final char newChar; // new character in the (x,y)

  /**
   * Constructor for DrawingChange
   * 
   * @param x, the x coordinate of drawing
   * @param y, the y coordinate of drawing
   * @param prevChar, the character of drawing before change
   * @param newChar, the character of drawing after change
   */
  public DrawingChange(int x, int y, char prevChar, char newChar) {
    // initialize variables to input parameters;
    this.x = x;
    this.y = y;
    this.prevChar = prevChar;
    this.newChar = newChar;
  }
}

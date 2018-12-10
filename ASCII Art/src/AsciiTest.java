//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: AsciiTest.java
// Files: DrawingStack.java, Node.java, DrawingStackIterator.java, StackADT.java,
//////////////////// DrawingChange.java, Canvas.java, AsciiArt.java
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
public class AsciiTest {
  /**
   * This test should create a stack, push a DrawingChange onto the stack, and then use peek to
   * verify that the correct item is at the top of the stack.
   * 
   * @return true if all tests passed, false otherwise
   */
  public static boolean testStackPushPeek() {
    DrawingStack testStack = new DrawingStack();
    DrawingChange test1 = new DrawingChange(100, 100, 'a', 'n');
    testStack.push(test1);
    if (!(testStack.peek().equals(test1))) {
      System.out.println(
          "testStackPushPeek: peek() on test Stack did not return the expected DrawingChange.");
      return false;
    }
    return true;
  }

  public static boolean runStackTestSuite() {
    DrawingStack testStack = new DrawingStack();
    DrawingChange test1 = new DrawingChange(100, 100, 'a', 'n');
    try {
      testStack.push(null);
      System.out.println("runStackTestSuite null push call failed.");
      return false;
    } catch (IllegalArgumentException e) {
    }
    testStack.push(test1);
    if (testStack.isEmpty()) {
      System.out.println("runStackTestSuite isEmpty call failed.");
      return false;
    }
    if (testStack.size() != 1) {
      System.out.println("runStackTestSuite size call failed.");
      return false;
    }

    return true;
  }

  public static boolean testCanvas() {
    Canvas testCanvas = new Canvas(10, 10);
    if (testCanvas.undo()) {
      System.out.println("testCanvas undo test failed.");
      return false;
    }
    testCanvas.draw(0, 0, 'e');
    testCanvas.draw(0, 0, 'f');
    if (!testCanvas.undo()) {
      System.out.println("testCanvas undo test failed.");
      return false;
    }
    if (!testCanvas.redo()) {
      System.out.println("testCanvas redo test failed.");
      return false;
    }
    if (testCanvas.redo()) {
      System.out.println("testCanvas redo test failed.");
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    boolean totTest = true;
    if (!testStackPushPeek()) {
      totTest = false;
    }
    if (!runStackTestSuite()) {
      totTest = false;
    }
    if (!testCanvas()) {
      totTest = false;
    }
    if (totTest) {
      System.out.println("All Tests Passed!");
    }
  }
}

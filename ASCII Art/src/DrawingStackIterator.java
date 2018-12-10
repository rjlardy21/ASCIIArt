//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: DrawingStackIterator.java
// Files: DrawingStack.java, Node.java, AsciiTest.java, StackADT.java, DrawingChange.java,
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
import java.util.Iterator; // import iterator

/**
 * This class returns an iterator over a stack of DrawingChanges
 * 
 * @author Reece Lardy
 * @implements Iterator<DrawingChange>
 */
public class DrawingStackIterator implements Iterator<DrawingChange> {
  // create variable to be initialized by constructor
  public Node<DrawingChange> first;

  /**
   * Constructor for DrawingStackIterator
   */
  DrawingStackIterator(Node<DrawingChange> top) {
    // initialize first node to top of stack parameter
    first = top;
  }

  /**
   * Checks to see if the node has a next node
   * 
   * @return true if the node has a next node, false otherwise
   */
  @Override
  public boolean hasNext() {
    // if node next is not null
    if (first.getNext() != null) {
      // return true
      return true;
    }
    // return false otherwise
    return false;
  }

  /**
   * Returns the node's next node data
   * 
   * @return next node if the node has a next node, null otherwise
   */
  @Override
  public DrawingChange next() {
    // if next node is not null
    if (first.getNext() != null) {
      // return data of the next node
      return first.getNext().getData();
    }
    // if next node is null, return null
    return null;
  }

}

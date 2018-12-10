//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: DrawingStack.java
// Files: Node.java, DrawingStackIterator.java, StackADT.java, AsciiTest.java, DrawingChange.java,
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
 * This class is a Stack of drawing changes to be used by the various classes of ASCII Art
 * 
 * @author Reece Lardy
 * @implements StackADT.java
 */
public class DrawingStack implements StackADT<DrawingChange> {
  // create variables to be initialized by constructor
  protected Node<DrawingChange> top;
  protected int size;

  /**
   * Constructor for DrawingStack
   */
  public DrawingStack() {
    // initialize variables
    top = null;
    size = 0;
  }

  /**
   * Add an element to this stack
   * 
   * @param element an element to be added
   * @throws IllegalArgumentException if the input element is null
   */
  @Override
  public void push(DrawingChange element) throws IllegalArgumentException {
    // throw illegal argument exception if input parameter is null
    if (element == null) {
      throw new IllegalArgumentException("Push parameter cannot be null.");
    }
    // create new node to add to stack
    Node<DrawingChange> toAdd = new Node<DrawingChange>(element, null);
    // if the stack is empty, make the new node the top of the stack
    if (top == null) {
      top = toAdd;
    } else {
      // if the stack is not empty, set the next node of toAdd node to current top of stack, then
      // set the top of the stack = to the new node
      toAdd.setNext(top);
      top = toAdd;
    }
    // increment size of stack
    size++;
  }

  /**
   * Remove the element on the stack top and return it
   * 
   * @return the element removed from the stack top
   * @see pop() in StackADT.java
   */
  @Override
  public DrawingChange pop() {
    // initialize the node to be popped to the top of the stack
    Node<DrawingChange> toPop = top;
    // set the top of the stack to the second item in the stack
    top = toPop.getNext();
    // decrement size
    size--;
    // return the data of the node being popped
    return toPop.getData();
  }

  /**
   * Get the element on the stack top
   * 
   * @return the element on the stack top
   * @see peek() in StackADT.java
   */
  @Override
  public DrawingChange peek() {
    // return the data of the node on top of the stack
    return top.getData();
  }

  /**
   * Returns true if this stack contains no elements.
   * 
   * @return true if this stack contains no elements, otherwise false
   * @see isEmpty() in StackADT.java
   */
  @Override
  public boolean isEmpty() {
    // if the top is equal to null, return true, otherwise, return false
    return (size == 0);
  }

  /**
   * Get the number of elements in the stack
   * 
   * @return the size of the stack
   * @see size() in StackADT.java
   */
  @Override
  public int size() {
    // return size of stack
    return size;
  }

  /**
   * Returns an iterator of the stack
   * 
   * @return iterator of the stack
   * @see iterator() in StackADT.java
   */
  @Override
  public Iterator<DrawingChange> iterator() {
    // initialize iterator to a method call of drawingstackiterator with the top node of the stack
    // as the input parameter
    DrawingStackIterator iter = new DrawingStackIterator(top);
    // return the iterator
    return iter;
  }

}

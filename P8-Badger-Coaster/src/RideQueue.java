//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:   P08 Badger Coaster
// Files:   BoardingGroup, RideQueue, ThemeParkApp
// Course:  CS300, Spring 2020
//
// Author:  Nolan Smith
// Email:   nosmith@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   __ Write-up states that pair programming is allowed for this assignment.
//   __ We have both read and understood the course Pair Programming Policy.
//   __ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course 
// staff must fully acknowledge and credit those sources here.  If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons:         NONE
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////
import java.util.NoSuchElementException;

public class RideQueue implements QueueADT<BoardingGroup> {

  private BGNode front = null;
  private BGNode back = null;
  private int capacity;
  private int numOfPeople = 0;
  private int numOfGroups = 0;
  
  /*
   * Creates an empty RideQueue with designated capacity
   */
  public RideQueue(int capacity) {
    this.capacity = capacity;
  }

  /*
   * Determines whether or not this queue is empty
   * 
   * @returns true when empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    if(front == null) return true;
    return false;
  }

  /*
   * Gives number of BoardingGroup nodes in this queue
   * 
   * @returns current number of nodes in queue
   */
  @Override
  public int size() {
    int count = 0;
    BGNode cur = front;
    if(front == null) return 0;
    else count++;
    while(cur.getNext() != null) {
      count++;
      cur = cur.getNext();
    }
    return count;
  }

  /*
   * Adds the new group to queue
   * 
   * @throws IllegalStateException if not enough room for group
   */
  @Override
  public void enqueue(BoardingGroup newGroup) {
    BGNode lastGroup = null;
    BGNode frontVip = null;
    if((numOfPeople + newGroup.getNumRiders()) > capacity) throw new IllegalStateException("Not enough room in queue to add group with this many people!");
    if(size() == 0) {
      front = new BGNode(newGroup);
      back = front;
      numOfGroups++;
      numOfPeople += newGroup.getNumRiders();
    } else
    if(size() >= 1) {
      if(newGroup.isVip()) {
        frontVip = new BGNode(newGroup, front);
        front = frontVip;
        numOfGroups++;
        numOfPeople += newGroup.getNumRiders();
      } else {
      lastGroup = back;
      lastGroup.setNext(new BGNode(newGroup));
      back=lastGroup.getNext();
      numOfGroups++;
      numOfPeople += newGroup.getNumRiders();
      }
    } 
  }

  /*
   * empties the queue
   */
  @Override
  public void clear() {
    front=null;
    back=null;
    numOfGroups = 0;
    numOfPeople = 0;
  }

  /*
   * Returns BoardingGroup at front of queue without removing 
   * 
   * @throws NoSuchElementException when queue is empty
   * 
   * @returns BoardingGroup at front of the line
   */
  @Override
  public BoardingGroup peek() {
    if(isEmpty()) throw new NoSuchElementException("The Ride Queue is empty!");
    return front.getGroup();
  }

  /*
   * Returns BoardingGroup at front of this queue and removes it
   * 
   * @throws NoSuchElementException when trying to remove group from an empty queue
   * 
   * @returns BoardingGroup at the front of the queue that was removed
   */
  @Override
  public BoardingGroup dequeue() {
    BGNode curNode = front;
    if(isEmpty()) throw new NoSuchElementException("Unable to remove group from Ride Queue as it was aleady empty.");
    front = front.getNext();
    numOfGroups--;
    numOfPeople -= curNode.getGroup().getNumRiders();
    return curNode.getGroup();
  }

  /*
   * Returns a string representation of this queue
   * 
   * @returns this queue represented as a String
   */
  public String toString() {
    String s = "Number of People in Queue: " + numOfPeople + "\n";
    s += "Number of Groups in Queue: " + numOfGroups + "\n";
    s += "Group Names in Queue: ";
    BGNode current = front;
    while (current != null) {
    String groupName = current.getGroup().getName();
    s += groupName + " ";
    current = current.getNext();
    }
    return s;

  }
  
}




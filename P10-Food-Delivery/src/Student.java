//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:   P10 food Delivery
// Files:   Student, FoodRobot, Delivery, DeliveryQueue
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
public class Student {
  private int x;
  private int y;
  private int id;
  
  public Student(int x, int y, int id) {
    this.x = x;
    this.y = y;
    this.id = id;
  }
  
  /*
   * @returns int - x value
   */
  public int getX() {
    return x;
  }
  
  /*
   * @returns int - y value
   */
  public int getY() {
    return y;
  }
  
  /*
   * @returns int - studentId
   */
  public int getId() {
    return id;
  }
  
  /*
   * @returns String representation of Student
   */
  @Override
  public String toString() {
    return id + "(" + x + "," + y + ")";
  }
}

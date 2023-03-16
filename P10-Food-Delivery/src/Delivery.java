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
public class Delivery implements Comparable{
  private int studentId;
  private String robotName;
  private int distance;
  
  public Delivery(Student stud, FoodRobot rob) {
    studentId = stud.getId();
    robotName = rob.getName();
    distance = Math.abs(stud.getX() - rob.getX()) + Math.abs(stud.getY() - rob.getY());
  }
  
  /*
   * Compares this Delivery object to either a Delivery, Student, or FoodRobot object. 
   * If equal(studentId/foodRobot name) returns true, else false
   * 
   * @returns true if objects share a studentId or RobotName
   */
  @Override
  public boolean equals(Object o) {
    if(o instanceof Delivery) { // if object o is Delivery
      if(((Delivery) o).studentId == studentId) {
        return true;
      } else
        if(((Delivery) o).robotName.compareToIgnoreCase(robotName) == 0) {
          return true;
        } else
          return false;
    } else
    if(o instanceof Student) { // if object o is Student
      if(((Student) o).getId() == studentId) {
        return true;
      } else return false;
    } else
    if(o instanceof FoodRobot) { // if object o is FoodRobot
      if(((FoodRobot) o).getName().compareToIgnoreCase(robotName) == 0){
        return true;
      } else return false;
    }
    return false;
  }
  
  /*
   * @returns String representation of Delivery
   */
  @Override
  public String toString() {
    return "The distance between " + studentId + " and " + robotName + 
        " is " + distance;
  }
  
  /*
   * @returns -1 when object called on has higher priority than argument, 1 when vice versa is true
   */
  @Override
  public int compareTo(Object o) {
    if(((Delivery) o).distance > distance) {
      return -1;
    } 
    if(((Delivery) o).distance < distance) {
      return 1;
    }
    if(((Delivery) o).distance == distance) {
      if(((Delivery) o).studentId < studentId) {
        return 1;
      }
      if(((Delivery) o).studentId > studentId) {
        return -1;
      }
      if(((Delivery) o).studentId == studentId) {
        if(((Delivery) o).robotName.compareToIgnoreCase(robotName) < 0) {
          return 1;
        } else return -1;
      }
    }
    return -1;
   }
  
}

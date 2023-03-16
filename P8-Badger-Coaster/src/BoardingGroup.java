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
public class BoardingGroup {

  private String name;
  private int numOfRiders;
  private boolean isVip;
  
  public BoardingGroup(String name, int riders) {
    this.name = name;
    numOfRiders = riders;
    isVip = false;
  }
  
  /*
   * @returns name of Boarding Group
   */
  public String getName() {
    return name;
  }
  
  /*
   * @returns Number of Riders
   */
  public int getNumRiders() {
    return numOfRiders;
  }
  
  /*
   * @returns true if Group is a VIP, false if not
   */
  public boolean isVip() {
    return isVip;
  }
  
  /*
   * Sets isVip to true
   */
  public void setVipStatus() {
    isVip = true;
  }
  
  
}

//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:   P05 WinterCarnival
// Files:   WinterCarnival, FrozenStatue, StarshipRobot, DancingBadger
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
import java.io.File;

public class FrozenStatue {

  protected float x; //
  protected float y;
  protected boolean isFacingRight;
  protected String imageName;
  
  /*
   * This constructor sets the x and y positions from the float[] it is passed, isFacingRight to true
   * and also sets the imageName to the appropriate "FrozenStatue"
   */
  public FrozenStatue(float[] a) {
    x = a[0]; // sets x position
    y = a[1]; // sets y position
    isFacingRight = true;
    imageName = "images" + File.separator + "frozenStatue.png";
  }
  
  public void update(SimulationEngine engine) {
    engine.draw(imageName, x, y, isFacingRight);
  }
  
}

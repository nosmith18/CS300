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

public class DancingBadger extends StarshipRobot{

  protected DanceStep[] danceSteps;
  protected int stepIndex;
  
  
  public DancingBadger(float[] a, DanceStep[] danceSteps) {
    super(new float[][] { a , danceSteps[0].getPositionAfter(a)}); // sends new float[][] with start and destination based on step
    imageName = "images"+File.separator+"dancingBadger.png";
    speed = 2;
    isFacingRight = true;
    this.danceSteps = danceSteps;
    stepIndex = 1;
  }
  
  @Override
  protected void updateDestination() {
    float[] currPos = new float[] {x,y}; // float[] of cureent position
    destination = danceSteps[stepIndex].getPositionAfter(currPos); // sets new destination
    stepIndex++;
    if(stepIndex==danceSteps.length) stepIndex = 0; // checks if stepIndex is too large for DanceSteps and sets back to 0
  }
}

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

public class StarshipRobot extends FrozenStatue {

  protected float[][] beginAndEnd;
  protected float[] destination;
  protected float speed;

  /*
   * This constructor method takes in a 2D arraylist of floats representing the starting
   * position and destination of a robot object to be drawn in the WinerCarnival Window.
   */
  public StarshipRobot(float[][] a) {
    super(a[0]); // passes the start position to the super constructor
    beginAndEnd = a;
    destination = a[1]; 
    speed = 6;
    imageName = "images" + File.separator + "starshipRobot.png";
  }

  /*
   * This method updates the position of the object it is called 
   * on by moving it towards destination using increments of the speed variable
   * 
   * @return true when distance between initial position and destination
   * is less than 2x its speed, otherwise false
   */
  protected boolean moveTowardDestination() {
    float newX; // new X position after move
    float newY; // new y position after move
    float oldX = x; 
    float oldY = y;
    
    int dist = (int) Math.sqrt((x - destination[0])*(x - destination[0]) 
        + (y - destination[1])*(y - destination[1]));; //Distance btwn current position and destination
    
    if(destination[0]<x) isFacingRight = true;
    else {isFacingRight = false;}
    
    newX = oldX + ((speed*(destination[0] - oldX))/dist); // calculates where new X position is after the move increment
    newY = oldY + ((speed*(destination[1] - oldY))/dist); // calculates where new Y position is after the move increment
    
    x = newX;
    y = newY;
    
    if(dist<(speed*2)) {return true;}
    else return false;
  }
  
  /*
   * This method flips the destination and current position so that the robot object will
   * now move back towards what was it's initial position.
   */
  protected void updateDestination() {
    if(destination==beginAndEnd[1]) { // Checks what current position is equal to(start or destination)
    destination = beginAndEnd[0];
    x = beginAndEnd[1][0]; 
    y = beginAndEnd[1][1];
    }else 
      if(destination==beginAndEnd[0]) {
      destination = beginAndEnd[1];
      x = beginAndEnd[0][0];
      y = beginAndEnd[0][1];
      }
    if(isFacingRight==true) { isFacingRight = false;}
    else isFacingRight = true;
  }
  /*
   * This method overrides FrozenStatue's update method and calls the moveTowardDestination() method
   * to move the robot objects across the window. This method also calls updateDestination() when
   * a robot object is nearing its destination.
   */
  @Override
  public void update(SimulationEngine engine) {
    if(moveTowardDestination()) {updateDestination();}
    super.update(engine);
  }
  
  
  
}

//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:   P06 Alphabet Train
// Files:   AlphabetList, LinkedCart, AlphabetListTester
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
public class LinkedCart {
  private final Cart CART;
  private LinkedCart previous;
  private LinkedCart next;
  
  /*
   * Creates a new LinkedCart object with specific data cart and null 
   * for both previous and next linked carts
   * 
   * @param Cart - data of this LinkedCart
   */
  public LinkedCart(Cart cart){
    this.CART = cart;
    previous = null;
    next = null;
  }
  /*
   * Creates a new LinkedCart object with specific data cart, previous 
   * and next linked carts
   * 
   * @param cart - data of this linkedCart 
   *        previous - reference to the previous linked cart
   *        next - reference to the next linked cart
   */
  public LinkedCart(Cart cart, LinkedCart previous, LinkedCart next) {
    this.CART = cart;
    this.previous = previous;
    this.next = next;
  }
  /*
   * Returns a reference to the data cart of this linked cart
   * 
   * @return data of this LinkedCart
   */
  public Cart getCart() {
    return CART;
  }
  /*
   * Returns a reference to the previous cart
   * 
   * @return the previous LinkedCart
   */
  public LinkedCart getPrevious() {
    return previous;
  }
  /*
   * Sets the previous LinkedCart attached to this LinkedCart
   * 
   * @param LinkedCart to be set to previous
   */
  public void setPrevious(LinkedCart previous) {
    this.previous = previous;
  }
  /*
   * Returns a reference to the next LinkedCart attached to this LinkedCart
   * 
   * @return next LinkedCart
   */
  public LinkedCart getNext() {
    return next;
  }
  /*
   * Sets the next LinkedCart attached to this LinkedCart
   * 
   * @param LinkedCart to be set to next
   */
  public void setNext(LinkedCart next) {
    this.next = next;
  }
  
}

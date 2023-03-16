//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:   P03 Elastic Piggy Bank
// Files:   ElasticBank, Coin, Elastic Tester
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

import java.util.Random;

public class ElasticBank {
  private Coin[] coins;
  private int size=0;
  private int expansionsLeft = 2;
  private static Random rand = new Random();
  
  public ElasticBank() {
    coins = new Coin[10];
  }
  public ElasticBank(int initialCapacity) {
    coins = new Coin[initialCapacity];
  }

  /*
   * @return Returns the length/capacity of the coins array(int)
   */
  public int capacity() {
    return coins.length;
  }
  
  /*
   * @return Returns the number of expansions left(int)
   */
  public int getExpansions() {
    return expansionsLeft;
  }
  
  /*
   * This method counts the number of coins currently in the Elastic Bank
   * 
   * @return Returns an int representing the number of filled indexes(coins in array)
   */
  public int getSize() {
    int size=0; // Counts number of filled indexes
    for(Coin c : coins) {
      if(c != null) {
        size++;
      }
    }
    this.size=size; // Sets private size variable to this value
    return size;
  }
  
  /*
   * This method adds of the value of all coins in coins array, excluding null(unfilled indexes)
   * 
   * @return Int value of all coins in array
   */
  public int getBalance() {
    int balance=0; // adds up total value of all coins in the bank
    for(Coin c : coins) {
      if(c!=null) { 
      balance += c.getValue();
      }
    }
    return balance; 
  }
  
  /*
   * This method creates a local String variable which is eventually returned 
   *     after all names and values of coins have been added
   *     
   * @return Returns a string of all Coin objects (Name, Value) (Name1, Value1) (etc...)
   */
  public String getCoins() {
    String coinList=""; // local string variable
    for(Coin c : coins) {
      if(c!=null)
      coinList = coinList + "(" + c.getName() + ", " + c.getValue() + ") "; 
    }
    return coinList;
  }
  
  /*
   * This method removes one coin from the coins array using a randomIndex 
   * 
   * @return Returns the length/capacity of the coins array
   */
  public Coin removeCoin() {
    int numCoin=0; //Counts number of coins in Bank
    if(size==0) { // If coins is empty
      System.out.println("Failed to remove coin, no coins in Piggy Bank!");
      return null;
    }
    for(int i=0; i<coins.length; i++) { // Counts the number of Coin objects in coins
      if(coins[i]!=null)
        numCoin++;
    }
    
    int randIndex = rand.nextInt(numCoin); // Makes random index between 0 and the number of coins
    String coinName = coins[randIndex].getName(); // saves name of Coin
    int coinValue = coins[randIndex].getValue(); // saves value of Coin
    Coin rCoin = new Coin(coinName, coinValue); // instantiates new Coin object with name and value to be returned
    coins[randIndex]=null;
    size--;
    return rCoin;
  }
  
  /*
   * This method empties the coins array by setting each index to null and setting size to 0
   */
  public void empty() {
    for(int i=0; i<coins.length; i++) {
      coins[i] = null;
    }
    size=0;
  }
  
  /*
   * This method adds a Coin object to the coins array. If the array is full and an expansion is available, the array expands its capacity.
   *     If the array is full and expansionsLeft=0, coins is emptied and the one Coin is added at first index.
   * 
   * @param Coin object
   * 
   */
  public void addCoin(Coin c) {
    int numFilled=0; // counts number of Coin objects in array
    for(int i=0; i<coins.length; i++) {
      if(coins[i]==null) {
        coins[i]=c;
        size++;
        return;
      }
      else numFilled++; // counts number of filled spots (Coin objects in array)
      if(numFilled==coins.length && expansionsLeft==0) {
        empty(); // empties if array is full and no expansions left
        coins[0]=c;
        size++;
        return;
      }
      
      if(numFilled==coins.length && expansionsLeft>0) { // Array is full 
        //BREAK POINT
        Coin[] newCoins = new Coin[coins.length+10]; // new coins array with increased capacity(by 10)
        for(int j=0; j<coins.length; j++) {
          newCoins[j]=coins[j]; // copies over all Coin objects into new array
        }
        coins=newCoins;
        coins[i+1]=c; // Adds coin at next index (first of new expansion)
        expansionsLeft--; // decrements expansionsLeft
        size++;
        return;
      }
    }
  }
  
  
}

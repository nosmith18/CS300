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

public class ElasticTester {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(testCoinInstantiableClass());
    System.out.println(testBalanceAccessors());
    System.out.println(testCapacity());
    System.out.println(testGetCoins());
    System.out.println(testRemoveCoin());
    
    
  }
  
  /*
   * This method tests if the Coin class is working correctly, including its submethods getName() and getValue()
   * 
   * @return Returns false if methods do not work correctly
   * @return Returns true is methods work correctly
   */
  public static boolean testCoinInstantiableClass () {
    Coin penny = new Coin("PENNY", 1);
    Coin quarter = new Coin("QUARTER", 25);
    if (!penny.getName().equals("PENNY")) return false;
    if (penny.getValue() != 1) return false;
    if (!quarter.getName().equals("QUARTER")) return false;
    if (quarter.getValue() != 25) return false;
    return true;
  }
  
  /*
   * This method tests if the getBalance() and addCoin() methods work
   * 
   * @return Returns false if methods do not work correctly
   * @return Returns true is methods work correctly
   */
  public static boolean testBalanceAccessors () {
    ElasticBank one = new ElasticBank(5);
    ElasticBank two = new ElasticBank(7);
    one.addCoin(new Coin("PENNY", 1));
    two.addCoin(new Coin("NICKEL", 5));
    // Checks after one coin is added
    if (one.getBalance() != 1) return false;
    if (two.getBalance() != 5) return false;
    //Checks after multiple are added
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("DIME", 10));
    one.addCoin(new Coin("NICKEL", 5));
    if(one.getBalance() != 41) return false;
    return true;
    }
  
  /*
   * This method tests if the capacity() method works
   * 
   * @return Returns false if method doesn't work correctly
   * @return Returns true is methods work correctly
   */
  public static boolean testCapacity() {
    ElasticBank one = new ElasticBank(4); // Checks when given a value
    if(one.capacity()!=4) return false;
    ElasticBank two = new ElasticBank(11);
    if(two.capacity()!=11) return false;
    ElasticBank three = new ElasticBank(); // Checks when not given a value(should be 10)
    if(three.capacity()!=10) return false;
    return true;
  }
  
  /*
   * This test method tests if the getCoins() method works
   * 
   * @return Returns false if the returned String does not match the expected output
   * @return Returns true is returned strings are correct
   */
  public static boolean testGetCoins() {
    ElasticBank one = new ElasticBank(5);
    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("NICKEL", 5));
    one.addCoin(new Coin("QUARTER",25));
    if(one.getCoins().compareTo("(PENNY, 1) (NICKEL, 5) (QUARTER, 25) ")!=0) return false;
    one.addCoin(new Coin("QUARTER",25));
    one.addCoin(new Coin("QUARTER",25));
    one.addCoin(new Coin("QUARTER",25)); // Expansion used here for 6th coin
    if(one.getCoins().compareTo("(PENNY, 1) (NICKEL, 5) (QUARTER, 25) (QUARTER, 25) (QUARTER, 25) (QUARTER, 25) ")!=0) return false;
    
    System.out.println(one.getCoins()); // Second check to see if Piggy Bank expands beyond the original 5 coin slots
    System.out.println(one.getExpansions()); // Check for only 1 expansion left
    
    
    return true;
  }
  
  /*
   * This test method checks that the removeCoin() method as well as addCoin(), Empty(), and proper extension of the array
   * 
   * @return Returns false if methods do not work correctly
   * @return Returns true is methods work correctly
   */
  public static boolean testRemoveCoin() {
    ElasticBank one = new ElasticBank(1); // Capacity 1 array has 21 coins added causing two expansions and an empty
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("DIME", 10));
    one.addCoin(new Coin("NICKEL", 5));
    one.addCoin(new Coin("QUARTER", 25));
    System.out.println(one.getCoins());
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("QUARTER", 25));
    System.out.println(one.getCoins());
    one.addCoin(new Coin("QUARTER", 25));
    one.addCoin(new Coin("NICKEL", 5));
    one.addCoin(new Coin("PENNY", 1));
    one.addCoin(new Coin("DIME", 10));
    //BREAK POINT
    one.addCoin(new Coin("NICKEL", 5));
    one.addCoin(new Coin("QUARTER", 25));
    if(one.removeCoin().getName().compareTo("QUARTER")==0) {
      System.out.println("Successfully removed a Quarter!");
      return true;
    }
    if(one.removeCoin().getName().compareTo("PENNY")==0) {
      System.out.println("Successfully removed a Penny!");
      return true;
    }
    if(one.removeCoin().getName().compareTo("NICKEL")==0) {
      System.out.println("Successfully removed a Nickel!");
      return true;
    }
    if(one.removeCoin().getName().compareTo("DIME")==0) {
      System.out.println("Successfully removed a Dime!");
      return true;
    }
    
    return false;
  }
  
}

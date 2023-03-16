//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:   P04 ExceptionalBankTester
// Files:   ExceptionalBank, ExceptionalBankTester
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
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.NoSuchElementException;
import java.util.zip.DataFormatException;

public class ExceptionalBankTester {
  
  public static void main(String[] args) {
    System.out.println(testExceptionalBankConstructor());
    System.out.println(testAddCoin());
    System.out.println(testGoodExceptionalBankConstructor());
    System.out.println(testRemoveCoinEmptyBank());
    System.out.println(testAddCoinsValidFormat());
    System.out.println(testAddCoinsInvalidDataFormat());
    System.out.println(testAddCoinsNoSuchElement());
    System.out.println(testAddCoinsIllegalArgument());
    System.out.println(testLoadCoinsNullReference());
    System.out.println(testLoadCoinsFileNotFound());
    System.out.println(testLoadCoinsFileFound());
    
  }
  
  
  /**
  * This method checks whether the ExceptionalBank constructor throws an
  * IllegalArgumentException with appropriate error message, when it is passed
  * a zero or a negative capacity. This test must fail if another kind of exception
  * is thrown for such test scenario.
  *
  * @return true when this test verifies a correct functionality, and false otherwise
  */
  public static boolean testExceptionalBankConstructor() {
    try {
      // create an exceptional bank with a negative capacity
      ExceptionalBank bank = new ExceptionalBank(-10);
      System.out.println(
          "Problem detected. The constructor call of the ExceptionalBank class did not "
              + "throw an IllegalArgumentException when it is passed a negative capacity.");
      return false; // return false if no exception has been thrown
    } catch (IllegalArgumentException e1) {
      // check that the caught IllegalArgumentException includes
      // an appropriate error message
      if (e1.getMessage() == null // your test method should not throw
          // a NullPointerException,but must return false if e1.getMessage is null
          || !e1.getMessage().toLowerCase().contains("must be a non-zero positive integer")) {
        System.out.println(
            "Problem detected. The IllegalArgumentException thrown by the constructor "
                + "call of the ExceptionalBank class when it is passed a negative capacity "
                + "does not contain an appropriate error message.");
        return false;
      }
      return true;
    } catch (Exception e2) {
      // an exception other than IllegalArgumentException has been thrown
      System.out.println(
      "Problem detected. An unexpected exception has been thrown when calling the "
          + "constructor of the ExceptionBank class with a negative argument. "
          + "An IllegalArgumentException was expected to be thrown. "
          + "But, it was NOT the case.");
      e2.printStackTrace(); // to help locate the error within the bad ExceptionalBank
      // constructor code.
      return false;
    }
  }
  
  /*
   * This method checks whether the ExceptionalBank.addCoin() method throws an 
   * IllegalArgumentException with an appropriate error message, when it is passed 
   * a null reference.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddCoin() {
    try {
      ExceptionalBank bank = new ExceptionalBank(); // Creates bank with capacity of 10
      Coin c = null; // Null coin
      bank.addCoin(c);
    } catch (IllegalArgumentException e) {
      if(e.getMessage() == null) {
        System.out.println("Problem Detected. The IllegalArgumentException thrown does not "
            + "contain a correct error message.");
        return false;
      }
      return true;
    } catch (Exception e1) { // Checks for any other exceptions that are thrown
      System.out.println(
          "Problem detected. An unexpected exception has been thrown when calling the "
              + "constructor of the ExceptionBank class with a negative argument. "
              + "An IllegalArgumentException was expected to be thrown. "
              + "But, it was NOT the case.");
          e1.printStackTrace(); // to help locate the error within the bad addCoin code
          return false;
    }
    return false;
  }
  
  /*
   * This method checks whether the ExceptionalBank constructor creates without errors 
   * an empty exceptional bank with capacity 20 when it is passed 20 as input parameter. 
   * This test must fail if any exception is thrown for such test scenario.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGoodExceptionalBankConstructor() {
    try {
      ExceptionalBank bank = new ExceptionalBank(20); // Creates bank with capacity of 20
    } catch (Exception e) {
      System.out.println("Problem detected. No exception should be thrown when creating bank of size 20.");
      return false;
    }
    return true;
  }
  
  /*
   * This method checks whether the ExceptionalBank.removeCoin() method throws a NoSuchElementException
   * with an appropriate error message, when it is called on an empty bank.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testRemoveCoinEmptyBank() {
    try {
      ExceptionalBank bank = new ExceptionalBank(20); // Creates an empty bank(no coins) with capacity of 20
      bank.removeCoin();
    } catch (NoSuchElementException e) {
      if(e.getMessage() == null) {
        System.out.println("Problem Detected. The exception thrown did not contain a correct error message.");
        return false;
      }
      return true;
    } catch (Exception e) {
      System.out.println("An unexpected exception was thrown.");
      return false;
    }
    return false;
  }
  
  /*
   * This method checks whether the ExceptionalBank.addCoins() works appropriately when it is passed a String with 
   * a valid format. You can consider the following test scenarios, for instance. First, Create a new ExceptionalBank 
   * with initial capacity 20. Then, call .addCoins("QUARTER:2"). Then, verify that 2 quarters have been added to 
   * the bank without errors. Then, call .addCoins(" Penny : 3 "); Then, verify that 3 pennies have been added to the 
   * bank without errors. You can consider further scenarios. No exceptions must be thrown by the call of .addCoins() 
   * method with valid input arguments.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddCoinsValidFormat() {
    try {
      // BREAK POINT
    ExceptionalBank bank = new ExceptionalBank(20);
    bank.addCoins("QUARTER:2");
    System.out.println(bank.getSummary());
    bank.addCoins(" PEnny : 4 ");
    System.out.println(bank.getSummary());
    } catch (Exception e) {
      System.out.println(e);
      return false;
    }
    return true;
  }
  
  /*
   * This method checks whether ExceptionalBank.addCoins() method throws a DataFormatException with an appropriate error 
   * message when it is passed an incorrectly formatted string object, for instance "quarter: five", or ": 6", or "DIME:-5"
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddCoinsInvalidDataFormat() {
    try {
      //BREAKPOINT
      String s = "penny:ten";
      ExceptionalBank bank = new ExceptionalBank(20);
      bank.addCoins(s);
    }catch (DataFormatException e) {
      System.out.println(e.getMessage());
      if(e.getMessage()==null) {
        System.out.println("Problem Detected. The exception thrown did not contain a correct error message.");
        return false;
      }
      return true;
    } catch (Exception e1) {
      System.out.println("An unexpected exception was thrown.");
      
      return false;
    }
    return false;
  }
  
  /*
   * This method checks whether ExceptionalBank.addCoins() method throws a NoSuchElementException with an appropriate error 
   * message when it is passed a String object with a correct format (meaning "string:positive_number"), but with a coin name 
   * not defined in the enum Coin's constants. For instance, when it is passed "blabla:10".
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddCoinsNoSuchElement() {
    try {
      String s = "NotACoin:10";
      ExceptionalBank bank = new ExceptionalBank(20);
      bank.addCoins(s);
    }catch (NoSuchElementException e) {
      if(e.getMessage()==null) {
        System.out.println("Problem Detected. The exception thrown did not contain a correct error message.");
        return false;
      }
      return true;
    } catch (Exception e1) {
      System.out.println("An unexpected exception was thrown.");
      return false;
    }
    return false;
  }
  
  /*
   * This method checks whether ExceptionalBank.addCoins() method throws an IllegalArgumentException with an appropriate error 
   * message when it is passed a null reference as input argument.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testAddCoinsIllegalArgument() {
    try {
    String nullString = null;
    ExceptionalBank bank = new ExceptionalBank(20);
    bank.addCoins(nullString);
    } catch (IllegalArgumentException e) {
      if(e.getMessage()==null) {
        System.out.println("Problem Detected. The exception thrown did not contain a correct error message.");
        return false;
      }
      return true;
    } catch (Exception e1) {
      System.out.println("An unexpected exception was thrown.");
      return false;
    }
    return false;
  }
  
  /*
   * This method checks whether ExceptionalBank.loadCoins() method throws a NullPointerException when it is passed a null reference.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testLoadCoinsNullReference() {
    try {
    File file = null;
    ExceptionalBank bank = new ExceptionalBank(20);
    bank.loadCoins​(file);
    } catch (NullPointerException e) {
      System.out.println(e.getMessage());
      return true;
    } catch (Exception e1) {
      System.out.println("An Unexpected excepton was thrown");
      System.out.println(e1.getMessage());
      return false;
    }
    return false;
  }
  
  /*
   * This method checks whether ExceptionalBank.loadCoins() method throws a FileNotFoundException when it is passed a non found file.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise.
   */
  public static boolean testLoadCoinsFileNotFound() {
    try {
      File file = new File("");
      ExceptionalBank bank = new ExceptionalBank(20);
      bank.loadCoins​(file);
    } catch(FileNotFoundException e) {
      System.out.println(e.getMessage());
      return true;
    } catch (Exception e1) {
      System.out.println("An Unexpected excepton was thrown");
      System.out.println(e1.getMessage());
      return false;
    }
    return false;
  }
  
  /*
   * This method checks whether ExceptionalBank.loadCoins() method loads appropriately without throwing any exception when it is passed a found file.
   * 
   * @return true when this test verifies correct functionality, false otherwise.
   */
  public static boolean testLoadCoinsFileFound() {
    try {
      //BREAKPOINT
      ExceptionalBank bank = new ExceptionalBank(20);
      bank.loadCoins​(new File("sample1.txt"));
      if(bank.getSummary().compareToIgnoreCase("PENNY:4\nNICKEL:2\nDime:5\nQUARTER:10")==0) return true;
      else return false;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return false;
    }
  }
  
}







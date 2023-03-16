//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:   P09 Patient Record System
// Files:   PatientRecordTree, PatientRecordTreeTester
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
import java.util.NoSuchElementException;

/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * PatientRecordTree.
 *
 */

public class PatientRecordTreeTester {

  /**
   * Checks the correctness of the implementation of both addPatientRecord() and toString() methods
   * implemented in the PatientRecordTree class. This unit test considers at least the following
   * scenarios. (1) Create a new empty PatientRecordTree, and check that its size is 0, it is empty,
   * and that its string representation is an empty string "". (2) try adding one patient record and
   * then check that the addPatientRecord() method call returns true, the tree is not empty, its
   * size is 1, and the .toString() called on the tree returns the expected output. (3) Try adding
   * another patientRecord which is older that the one at the root, (4) Try adding a third patient
   * Record which is younger than the one at the root, (5) Try adding at least two further patient
   * records such that one must be added at the left subtree, and the other at the right subtree.
   * For all the above scenarios, and more, double check each time that size() method returns the
   * expected value, the add method call returns true, and that the .toString() method returns the
   * expected string representation of the contents of the binary search tree in an ascendant order
   * from the oldest patient to the youngest one. (6) Try adding a patient whose date of birth was
   * used as a key for a patient record already stored in the tree. Make sure that the
   * addPatientRecord() method call returned false, and that the size of the tree did not change.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddPatientRecordToStringSize() {
    PatientRecordTree test = new PatientRecordTree();
    //BREAKPOINT
    if(test.isEmpty() != true) return false;
    if(test.size() != 0) return false;
    if(test.toString().compareTo(new String("")) != 0) return false; // ^^^ Tests for (1)
    if(!test.addPatientRecord(new PatientRecord("Nolan", "08/06/2000"))) return false;
    System.out.println(test.size());
    System.out.println(test.toString()); 
    test.addPatientRecord(new PatientRecord("Joe", "02/22/2004"));
    System.out.println(test.height());
    System.out.println(test.size());
    System.out.println(test.toString()); // adds older patient
    System.out.println(test.addPatientRecord(new PatientRecord("a", "02/22/2005"))); // adds to right subtree
    System.out.println(test.addPatientRecord(new PatientRecord("b", "02/22/1999"))); // adds to left subtree
    System.out.println(test.addPatientRecord(new PatientRecord("c", "02/22/1990"))); // adds to left subtree
    System.out.println(test.addPatientRecord(new PatientRecord("d", "02/22/2001"))); // adds to right subtree
    System.out.println(test.height()); // should be 3
    System.out.println(test.size()); // should be 6
    System.out.println(test.toString()); // checks toString
    if(test.addPatientRecord(new PatientRecord("d", "02/22/2001")) != false) return false; //tests for patient addition with same DOB
    System.out.println(test.size());
    return true;
  }

  /**
   * This method checks mainly for the correctness of the PatientRecordTree.lookup() method. It must
   * consider at least the following test scenarios. (1) Create a new PatientRecordTree. Then, check
   * that calling the lookup() method with any valid date must throw a NoSuchElementException. (2)
   * Consider a PatientRecordTree of height 3 which consists of at least 5 PatientRecordNodes. Then,
   * try to call lookup() method to search for the patient record at the root of the tree, then a
   * patient records at the right and left subtrees at different levels. Make sure that the lookup()
   * method returns the expected output for every method call. (3) Consider calling .lookup() method
   * on a non-empty PatientRecordTree with a date of birth not stored in the tree, and ensure that
   * the method call throws a NoSuchElementException.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddPatientRecordAndLookup() {
    PatientRecordTree test = new PatientRecordTree();
    try { // Empty Tree
      test.lookup(new String("01/01/2000")); 
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
    }
    
    test.addPatientRecord(new PatientRecord("d", "02/22/2001"));
    test.addPatientRecord(new PatientRecord("a", "02/22/2005")); // adds to right subtree
    test.addPatientRecord(new PatientRecord("b", "02/22/1999")); // adds to left subtree
    test.addPatientRecord(new PatientRecord("c", "02/22/1990")); // adds to left subtree
    try {
      test.lookup(new String("01/01/2000"));
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage()); 
    }
    
    try {
      System.out.println(test.lookup(new String("02/22/2001"))); // prints out lookup match
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage()); 
    }
    
    return true;
  }

  /**
   * Checks for the correctness of PatientRecordTree.height() method. This test must consider
   * several scenarios such as, (1) ensures that the height of an empty patient record tree is zero.
   * (2) ensures that the height of a tree which consists of only one node is 1. (3) ensures that
   * the height of a PatientRecordTree with the following structure for instance, is 4.
   *       (*)
   *     /    \
   *  (*)      (*)
   *    \     /  \
   *    (*) (*)  (*)
   *             /
   *           (*)
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {
    PatientRecordTree test = new PatientRecordTree();
    test.addPatientRecord(new PatientRecord("a", "02/22/2005")); // adds to right subtree
    if(test.height() != 1) return false;
    test.addPatientRecord(new PatientRecord("b", "02/22/1999")); // adds to left subtree
    if(test.height() != 2) return false;
    test.addPatientRecord(new PatientRecord("c", "02/22/1990")); // adds to left subtree
    if(test.height() != 3) return false;
    test.addPatientRecord(new PatientRecord("d", "02/22/2001")); // adds to right subtree
    if(test.height() != 3) return false;
    return true;
  }

  /**
   * Checks for the correctness of PatientRecordTree.getRecordOfYoungestPatient() method.
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetRecordOfYoungestPatient() {
    PatientRecordTree test = new PatientRecordTree();
    test.addPatientRecord(new PatientRecord("a", "02/22/2005")); // adds to right subtree    
    test.addPatientRecord(new PatientRecord("b", "02/22/1999")); // adds to left subtree  
    test.addPatientRecord(new PatientRecord("c", "02/22/1990")); // adds to left subtree
    test.addPatientRecord(new PatientRecord("d", "02/22/2001")); // adds to right subtree
    System.out.println(test.getRecordOfYoungestPatient());
    if(test.getRecordOfYoungestPatient().compareTo(new PatientRecord("a", "02/22/2005")) != 0) return false;
    return true;
  }

  /**
   * Checks for the correctness of PatientRecordTree.getRecordOfOldestPatient() method.
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetRecordOfOldestPatient() {
    PatientRecordTree test = new PatientRecordTree();
    test.addPatientRecord(new PatientRecord("a", "02/22/2005")); // adds to right subtree    
    test.addPatientRecord(new PatientRecord("b", "02/22/1999")); // adds to left subtree  
    test.addPatientRecord(new PatientRecord("c", "02/22/1990")); // adds to left subtree
    test.addPatientRecord(new PatientRecord("d", "02/22/2001")); // adds to right subtree
    System.out.println(test.getRecordOfOldestPatient());
    if(test.getRecordOfOldestPatient().compareTo(new PatientRecord("c", "02/22/1990")) != 0) return false;
    return true;
  }

  /**
   * Calls the test methods
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println(testAddPatientRecordToStringSize());
    System.out.println(testAddPatientRecordAndLookup());
    System.out.println(testHeight());
    System.out.println(testGetRecordOfYoungestPatient());
    System.out.println(testGetRecordOfOldestPatient());
  }

}

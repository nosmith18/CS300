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
 * This class implements a binary search tree (BST) which stores a set of patient records.
 * The left subtree contains the patient records of all the patients who are older than the
 * patient who's PatientRecord is stored at a parent node.
 * The right subtree contains the patient records of all the patients who are younger than the 
 * patient who's PatientRecord is stored at a parent node.
 *
 */
public class PatientRecordTree {
  private PatientRecordNode root = null; // root of this binary search tree
  private int size = 0; // total number of patient records stored in this tree.

  /**
   * Checks whether this binary search tree (BST) is empty
   * 
   * @return true if this PatientRecordTree is empty, false otherwise
   */
  public boolean isEmpty() {
    if(root == null) return true;
    return false;
  }

  /**
   * Returns the number of patient records stored in this BST.
   * 
   * @return the size of this PatientRecordTree
   */
  public int size() {
    return size;
  }

  /**
   * Recursive helper method to add a new PatientRecord to a PatientRecordTree rooted at current.
   * 
   * @param current The "root" of the subtree we are inserting newRecord into.
   * @param newRecord The PatientRecord to be added to a BST rooted at current.
   * @return true if the newRecord was successfully added to this PatientRecordTree, false otherwise
   */
  public static boolean addPatientRecordHelper(PatientRecord newRecord, PatientRecordNode current) {
    if(newRecord.equals(current.getPatientRecord())) return false;
    if(newRecord.compareTo(current.getPatientRecord()) < 0 ) { //if newPatient is older than current
      if(current.getLeftChild() != null) { 
        return addPatientRecordHelper(newRecord, current.getLeftChild());
      } else {
        current.setLeftChild(new PatientRecordNode(newRecord));
        return true;
      }
    } else // newPatient is younger than current
      if(current.getRightChild() != null) {
        return addPatientRecordHelper(newRecord, current.getRightChild()); //calls recurrence on rightChild
      } else {
        current.setRightChild(new PatientRecordNode(newRecord));
        return true;
      }
  }

  /**
   * Adds a new PatientRecord to this PatientRecordTree
   * 
   * @param newRecord a new PatientRecord to add to this BST.
   * @return true if the newRecord was successfully added to this BST, and returns false if there is
   *         a match with this PatientRecord already already stored in this BST.
   */
  public boolean addPatientRecord(PatientRecord newRecord) {
    if (isEmpty()) { // Add newRecord to an empty PatientRecordTree
      root = new PatientRecordNode(newRecord);
      size = 1;
      return true;
    } else { // Add newRecord to an non-empty PatientRecordTree
      if(addPatientRecordHelper(newRecord, root)) { //adds newRecord, if true increments size and returns true
        size++;
        return true;
      } else return false;     
    }
  }

  /**
   * Recursive helper method which returns a String representation of the BST rooted at current. An
   * example of the String representation of the contents of a PatientRecordTree is provided in the
   * description of the above toString() method.
   * 
   * @param current reference to the current PatientRecordNode within this BST.
   * @return a String representation of all the PatientRecords stored in the sub-tree
   *         PatientRecordTree rooted at current in increasing order with respect to the patients
   *         dates of birth. Returns an empty String "" if current is null.
   */
  public static String toStringHelper(PatientRecordNode current) {
    String names = "";
    if(current.getLeftChild() != null) { // Recursive call for left children 
      names += toStringHelper(current.getLeftChild());
    } 
    names += current.getPatientRecord().toString() + "\n"; // adds current node
    if(current.getRightChild() != null) { // recursive call for right children
      names += toStringHelper(current.getRightChild());
    }
    return names;
  }

  /**
   * Returns a String representation of all the PatientRecords stored within this BST in the
   * increasing order, separated by a newline "\n". For instance: 
   * "Sarah(1/2/1935)" + "\n" +
   * "George(5/27/1943)" + "\n" + 
   * "Adam(8/12/1972)" + "\n" + 
   * "Norah(11/23/1985)" + "\n" +
   * "William(6/4/1998)" + "\n" + 
   * "Nancy(9/12/2003)" + "\n" + 
   * "Sam(4/20/2019)" + "\n"
   * 
   * @return a String representation of all the PatientRecords stored within this BST sorted in an
   *         increasing order with respect to the dates of birth of the patients (i.e. from the
   *         oldest patient to the youngest patient). Returns an empty string "" if this BST is empty.
   */
  public String toString() {
    String s = "";
    if(isEmpty()) {
      return s;
    } else {
    PatientRecordNode cur = root; // cur equals root
    s += toStringHelper(cur); // calls recursive helper
    return s;
    }
  }

  /**
   * Search for a patient record (PatientRecord) given the date of birth as lookup key.
   * 
   * @param date a String representation of the date of birth of a patient in the format mm/dd/yyyy
   * @return the PatientRecord of the patient born on date.
   * @throws a NoSuchElementException with a descriptive error message if there is no PatientRecord
   *         found in this BST having the provided date of birth
   */
  public PatientRecord lookup(String date) {
    PatientRecord match = null;
    PatientRecord findRecord = new PatientRecord("", date);
    if(isEmpty()) {
      throw new NoSuchElementException("Record is empty!");
    }
    match = lookupHelper(findRecord, root);
    return match;
  }
  
  /**
   * Recursive helper method to lookup a PatientRecord given a reference PatientRecord with the same
   * date of birth in the subtree rooted at current
   * 
   * @param findRecord a reference to a PatientRecord target we are lookup for a match in the BST
   *        rooted at current.
   * @param current "root" of the subtree we are looking for a match to findRecord within it.
   * @return reference to the PatientRecord stored stored in this BST which matches findRecord.
   * @throws NoSuchElementException with a descriptive error message if there is no patient record
   *         whose date of birth matches date, stored in this BST.
   */
  private PatientRecord lookupHelper(PatientRecord findRecord, PatientRecordNode current) {
    if(findRecord.compareTo(current.getPatientRecord()) == 0) {
      return current.getPatientRecord(); //current patient equals findRecord
    }
    if(findRecord.compareTo(current.getPatientRecord()) < 0) { // findRecord is older than current
      if(current.getLeftChild() != null) {
        return lookupHelper(findRecord, current.getLeftChild());
      } else throw new NoSuchElementException("No patient with this DOB in system.");
    } else 
      if(current.getRightChild() != null) {
        return lookupHelper(findRecord, current.getRightChild());
      } else throw new NoSuchElementException("No patient with this DOB in system.");
  }
  
  /**
   * Computes and returns the height of this BST, counting the number of nodes (PatientRecordNodes)
   * from root to the deepest leaf.
   * 
   * @return the height of this Binary Search Tree
   */
  public int height() {
    if(isEmpty()) return 0;
    else return heightHelper(root);
  }

  /**
   * Recursive helper method that computes the height of the subtree rooted at current
   * 
   * @param current pointer to the current PatientRecordNode within a PatientRecordTree
   * @return height of the subtree rooted at current, counting the number of PatientRecordNodes
   */
  public static int heightHelper(PatientRecordNode current) {
    int leftHeight = 0;
    int rightHeight = 0;
    if(current.getLeftChild() == null && current.getRightChild() == null) {
      return 1;
    }
    if(current.getLeftChild() != null) {
      leftHeight += heightHelper(current.getLeftChild());
      leftHeight ++;
    }
    if(current.getRightChild() != null) {
      rightHeight += heightHelper(current.getRightChild());
      rightHeight ++;
    }
    if(leftHeight > rightHeight) return leftHeight; //checks which side is larger
    else return rightHeight;
  }


  /**
   * Returns the PatientRecord of the youngest patient in this BST.
   * 
   * @return the PatientRecord of the youngest patient in this BST and null if this tree is empty.
   */
  public PatientRecord getRecordOfYoungestPatient() {
    PatientRecord youngestPatient = null;
    PatientRecordNode cur = root;
    if(isEmpty()) {
      return null;
    }
    while(cur != null) {
      if(cur.getRightChild() != null) {
        cur = cur.getRightChild(); // sets cur to cur's leftChild
      } else {
        youngestPatient = cur.getPatientRecord(); // sets youngestPatient
        cur = null; // sets cur to break while loop
      }
    }
    return youngestPatient; 
  }

  /**
   * Returns the PatientRecord of the oldest patient in this BST.
   * 
   * @return the PatientRecord of the oldest patient in this BST, and null if this tree is empty.
   */
  public PatientRecord getRecordOfOldestPatient() {
    PatientRecord oldestPatient = null;
    PatientRecordNode cur = root;
    if(isEmpty()) {
      return null;
    }
    while(cur != null) {
      if(cur.getLeftChild() != null) {
        cur = cur.getLeftChild(); // sets cur to cur's rightChild
      } else {
        oldestPatient = cur.getPatientRecord(); // sets oldestPatient
        cur = null; // sets cur to break while loop
      }
    }
    return oldestPatient; 
  }

}

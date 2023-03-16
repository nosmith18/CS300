//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:   P07 File Finder
// Files:   ShallowFileIterator, DeepFileIterator, FilteredFileIterator, P07Tester
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

public class P07Tester {

  public static void main(String[] args) {
    File f = new File("filesystem");
    System.out.println(testShallowFileIterator(f));
    System.out.println(testDeepFileIterator(f));
    System.out.println(testFilteredFileIterator(f));
  }
  /*
   * this method tests ShallowFileIterator for correct result
   * 
   * @return true if method works correctly, else false
   */
  public static boolean testShallowFileIterator(File file) {
    try {
      String result = "";
      String expectedResults = "assignments, exam preparation, lecture notes, "
          + "reading notes, todo.txt, ";
      //BREAKPOINT
      ShallowFileIterator s = new ShallowFileIterator(file);
      while(s.hasNext()!=false) {
        result = result + s.next().getName() + ", ";
      }
      System.out.println(result);
      System.out.println(expectedResults);
      if(result.compareTo(expectedResults)!=0) return false;
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }
    return true;
  }
  /*
   * This method tests the DeepFileIterator for correct result
   * 
   * @return true if method works correctly, else returns false
   */
  public static boolean testDeepFileIterator(File file) {
    //BREAKPOINT
    File folder = new File(file.getPath() + File.separator + "assignments");
    try {
      String result = "";
      String expectedResults = "P01, PiggyBank.java, P02, CalendarPrinter.java, P03, "
          + "ElasticBank.java, P04, ExceptionalPiggyBank.java, P05, ExtendedVersion, "
          + "WinterCarnival.java, WinterCarnival.java, P06, AlphabetTrain.java, ";
      //BREAKPOINT
      DeepFileIterator s = new DeepFileIterator(folder);
      while(s.hasNext()!=false) {
        result = result + s.next().getName() + ", ";
      }
      System.out.println(result);
      System.out.println(expectedResults);
      if(result.compareTo(expectedResults)!=0) return false;
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }
    return true;
  }

public static boolean testFilteredFileIterator(File file) {
  try {
    String result = "";
    String expectedResults = "PiggyBank.java, CalendarPrinter.java, ElasticBank.java, "
        + "ExceptionalPiggyBank.java, WinterCarnival.java, WinterCarnival.java, "
        + "AlphabetTrain.java, codeSamples.java, ";
    //BREAKPOINT
    FilteredFileIterator f = new FilteredFileIterator(file, new String(".java"));
    result = result + f.next().getName() + ", ";
    while(f.hasNext()==true) {
      result = result + f.next().getName() + ", ";
    }
    System.out.println(result);
    System.out.println(expectedResults);
    if(result.compareTo(expectedResults)!=0) return false;
  } catch (FileNotFoundException e) {
    System.out.println(e.getMessage());
  }
  return true;
}



}


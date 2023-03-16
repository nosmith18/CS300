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
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;

public class ShallowFileIterator implements Iterator {
  private File[] folderContents;
  private int nextIndex;
  
  public ShallowFileIterator(File file) throws FileNotFoundException {
    try {  
    if(file.exists()==false) {
        throw new FileNotFoundException("This file does not exist.");
      }
//    if(file.isDirectory()==false) {
//      throw new FileNotFoundException("File could not be read.");
//    }
    } catch (SecurityException s) {
      throw new FileNotFoundException("This file cannot be read.");
    }
    folderContents=file.listFiles();
    Arrays.sort(folderContents);
    nextIndex=0;
  }
  /*
   *This method returns true if the iteration has more elements
   *
   * @return true if iteration has a next element, false otherwise
   */
  @Override
  public boolean hasNext() {
    while(nextIndex<folderContents.length) {
      if(folderContents[nextIndex]!=null) {
        return true;
      }
    }
    return false;
  }
  /*
   * This method return the next element of the iteration
   * 
   * @throws NoSuchElementException if iteration has no more elements
   * 
   * @return next element of iteration
   */
  @Override
  public File next() {
    if(hasNext()==true) {
    File o = folderContents[nextIndex].getAbsoluteFile();
    nextIndex++;
    return o;
    } else throw new NoSuchElementException("No more elements");
  }

}

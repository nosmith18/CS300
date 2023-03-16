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
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DeepFileIterator implements Iterator {
  private File[] folderContents;
  private int nextIndex;
  DeepFileIterator contentsIterator = null;
  
  public DeepFileIterator(File file) throws FileNotFoundException {    
  try {  
  if(file.exists()==false) {
      throw new FileNotFoundException("This file does not exist.");
    }
  } catch (SecurityException s) {
    throw new FileNotFoundException("This file cannot be read.");
  }
  folderContents=file.listFiles();
  Arrays.sort(folderContents);
  nextIndex=0;
}
/*
 * This method returns true if there is another element to be iterated
 * 
 * @return true if next file to iterate exists, false otherwise
 */
  @Override
  public boolean hasNext() {
    if(contentsIterator!=null && contentsIterator.hasNext()==true) {
      return true;
    }
    if(nextIndex<folderContents.length) {
      if(folderContents[nextIndex]!=null) {
        return true;
      }
    }
    return false;
  }

  /*
   * This method returns the next element of the iteration
   * 
   * @throws NoSuchElementException if iteration has no more elements
   * 
   * @return next element in iteration
   */
  @Override
  public File next() {
    int curIndex=0;
    try {
      if(contentsIterator==null) {
        curIndex=nextIndex;
        File o = folderContents[curIndex].getAbsoluteFile();
        if(folderContents[curIndex].isDirectory()==true) {
          contentsIterator = new DeepFileIterator(folderContents[nextIndex]);
        }
        nextIndex++;
        return o;
      }
      while(contentsIterator.hasNext()!=false) {
        return contentsIterator.next();
      }
      //BREAKPOINT
      if(contentsIterator.hasNext()==false) {
        contentsIterator=null;
        return next();
      }
    } catch (FileNotFoundException e) {
      System.out.print(e.getMessage());
    }
    throw new NoSuchElementException("Iteration has no more elements");   
  }
  
}

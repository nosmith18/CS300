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

public class FilteredFileIterator implements Iterator{

  private DeepFileIterator fileIterator;
  private String pattern;
  private File nextMatchingFile=null;
  
  public FilteredFileIterator(File file, String searchPattern) throws FileNotFoundException {
    if(file.exists()==false) throw new FileNotFoundException("File does not exist.");
    pattern=searchPattern;
    fileIterator = new DeepFileIterator(file);
    while(nextMatchingFile==null) {
      File f = fileIterator.next();
      if(f.getName().contains(pattern)) {
        nextMatchingFile=f;
      } 
    }
  }
  
  /*
   * This private helper method find the next valid file in the iteration and sets
   * nextMatchingFile to the found file. If no more matching Files exist, nextMatchingFile
   * is set to null.
   */
  private void findNextFile() {
    try{
      File f = fileIterator.next();
      if(f.getName().contains(pattern)) {
        nextMatchingFile=f;
      } else findNextFile();
    } catch (NoSuchElementException e) {
      nextMatchingFile=null;
    } catch (ArrayIndexOutOfBoundsException a) {
      nextMatchingFile=null;
    }
  }
  
  
  /*
   * Tells whether there is another file left in the iteration that contains the specified pattern
   * 
   * @return true if there exists another file, false if there are no more valid files
   */
  @Override
  public boolean hasNext() {
    findNextFile();
    if(nextMatchingFile==null) return false;
    return true;
  }

  /*
   * This method returns the nextMatchingFile if it exists.
   * 
   * @throws NoSuchElementException if iteration has no more elements
   * 
   * @return next valid File in iteration containing searchPattern
   */
  @Override
  public File next() {
    File curFile = nextMatchingFile;
    if(nextMatchingFile==null) {
      throw new NoSuchElementException("No more valid files in iteration.");
    } else return curFile;
  }
  
}

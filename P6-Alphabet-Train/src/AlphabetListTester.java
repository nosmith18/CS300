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
/**
* This class implements unit test methods to check the correctness of LinkedCart and AlphabetList
* classes defined in the CS300 Spring 2020 - P06 Alphabet Train programming assignment.
*
*/
public class AlphabetListTester {
 
  /**
   * Driver method defined in this AlphabetListTester class
   * 
   * @param args input arguments if any.
   */
  public static void main(String[] args) {
    System.out.println(testLinkedCart());
    System.out.println(testAlphabetListConstructorIsEmpty());
    System.out.println(testAlphabetListConstructorBadInput());
    System.out.println(testAlphabetListAddBadInput());
    System.out.println(testAlphabetListAdd());
    System.out.println(testAlphabetListRemove());
    System.out.println(runAllTests());
    
  }
  
 /**
  * This method should test and make use of at least the LinkedCart constructor, an accessor
  * (getter) method, and a mutator (setter) method defined in the LinkedCart class.
  * 
  * @return true when this test verifies a correct functionality, and false otherwise
  */
 public static boolean testLinkedCart() {
   LinkedCart test = new LinkedCart(new Cart("A"));
   if(test.getNext()!=null) {
     return false;
   }
   if(test.getPrevious()!=null) {
     return false;
   }
   LinkedCart testNext = new LinkedCart(new Cart("B"));
   test.setNext(testNext);
   if(test.getNext()!=testNext) {
     return false;
   }
   return true;
 }

 /**
  * This method checks for the correctness of both AlphabetList constructors and the instance
  * method isEmpty() when called on an empty alphabet list object.
  * 
  * @return true when this test verifies a correct functionality, and false otherwise
  */
 public static boolean testAlphabetListConstructorIsEmpty() {
   AlphabetList x = new AlphabetList();
   if(x.isEmpty()!=true) {
     return false;
   }
   
   return true;
 }

 /**
  * This method checks for the correctness of the AlphabetList(int) constructor when passed a
  * negative int value.
  * 
  * @return true when this test verifies a correct functionality, and false otherwise
  */
 public static boolean testAlphabetListConstructorBadInput() {
   try{
     AlphabetList x = new AlphabetList(-5);
   } catch (IllegalArgumentException e) {
     return true;
   }
   return false;
 }


 /**
  * This method checks for the correctness of the AlphabetList.add() method when it is passed bad
  * inputs. This method must consider at least the test scenarios provided in the detailed
  * description of these javadocs. (1) Try adding a null to the list; (2) Try adding a cart which
  * carries a non upper-case alphabet letter, for instance "Hello" or "1" or "a". (3) Try adding a
  * duplicate cart to the list.
  * 
  * @return true when this test verifies a correct functionality, and false otherwise
  */
 public static boolean testAlphabetListAddBadInput() {
   AlphabetList x = new AlphabetList();
   try{
     x.add(null);
   } catch(NullPointerException n) {
     n.getMessage();
     System.out.println("Correct exception was thrown when add() is passed a null reference.");
   }
   
   try {
     x.add(new Cart("a"));
   } catch (IllegalArgumentException i) {
     i.getMessage();
     System.out.println("Correct exception was thrown when add() is passed an invalid string");
   }
   
   x.add(new Cart("B"));
   
   try {
     x.add(new Cart("B"));
   } catch (IllegalStateException s) {
     s.getMessage();
     System.out.println("Correct exception was thrown when add() is passed a Cart already in the list");
   }
   return true;
 }

 /**
  * This method checks for the correctness of the AlphabetList.add() considering at least the test
  * scenarios provided in the detailed description of these javadocs. (1) Try adding a cart to an
  * empty list; (2) Try adding a cart which is expected to be added at the head of a non-empty
  * alphabet list; (3) Try adding a cart which is expected to be added at the end of a non-empty
  * alphabet list; (4) Try adding a cart which is expected to be added at the middle of a non-empty
  * alphabet list. For each of those scenarios, make sure that the size of the list is
  * appropriately updated after a call without errors of the add() method, and that the contents of
  * the list is as expected whatever if list is read in the forward or backward directions. You can
  * also check the correctness of AlphabetList.get(int), AlphabetList.indexOf(Cart), and
  * AlphabetList.size() in this test method.
  * 
  * @return true when this test verifies a correct functionality, and false otherwise
  */
 public static boolean testAlphabetListAdd() {
   AlphabetList x = new AlphabetList();
   x.add(new Cart("D")); //add to empty list
   System.out.println(x);
   if(x.size()!=1) return false; // size check
   x.add(new Cart("B"));
   System.out.println(x);
   if(x.size()!=2) return false; // size check
   x.add(new Cart("C"));
   System.out.println(x);
   x.add(new Cart("F"));
   System.out.println(x);
   x.add(new Cart("A"));
   System.out.println(x);
   x.add(new Cart("Z"));
   System.out.println(x);
   x.add(new Cart("E"));
   System.out.println(x);
   if(x.size()!=7) return false; // size check
   if(x.readForward().compareTo("ABCDEFZ")!=0) return false; //check for correct order forwards
   System.out.println("Read Forward: " + x.readForward());
   if(x.readBackward().compareTo("ZFEDCBA")!=0) return false; // check for correct order backwards
   System.out.println("Read Backward: " + x.readBackward());
   //BREAKPOINT
   x.add(new Cart("R"));
   x.add(new Cart("S"));
   System.out.println("Read Forward: " + x.readForward());
   System.out.println("Read Backward: " + x.readBackward());
   x.add(new Cart("Q"));
   x.add(new Cart("M"));
   x.add(new Cart("K"));
   System.out.println("Read Forward: " + x.readForward());
   System.out.println("Read Backward: " + x.readBackward());
   System.out.println(x);
   if(x.get(0).compareTo(new Cart("A"))!=0) return false; // checks AlphabetList.get();
   if(x.get(5).compareTo(new Cart("F"))!=0) return false; // checks AlphabetList.get();
   System.out.println(x.get(x.size()-1)); // checks AlphabetList.get()
   System.out.println(x.indexOf(new Cart("F"))); // checks AlphabetList.indexOf()
   return true;
 }

 /**
  * This method checks for the correctness of the AlphabetList.remove() considering at least the
  * test scenarios provided in the detailed description of these javadocs. (1) Try removing a cart
  * from an empty list or pass a negative index to AlphabetList.remove() method; (2) Try removing a
  * cart (at position index 0) from a list which contains only one cart; (3) Try to remove a cart
  * (position index 0) from a list which contains at least 2 carts; (4) Try to remove a cart from
  * the middle of a non-empty list containing at least 3 carts; (5) Try to remove the cart at the
  * end of a list containing at least two carts. For each of those scenarios, make sure that the 
  * size of the list is appropriately updated after a call without errors of the add() method, 
  * and that the contents of the list is as expected whatever if list is read in the forward or 
  * backward directions.
  * 
  * @return true when this test verifies a correct functionality, and false otherwise
  */
 public static boolean testAlphabetListRemove() {
   AlphabetList x = new AlphabetList();
   try {
   x.remove(0);
   } catch (IndexOutOfBoundsException e) {
     System.out.println(e.getMessage());
   }
   x.add(new Cart("A"));
   if(x.remove(0).compareTo(new Cart("A"))!=0) {
     return false;
   }
   System.out.println(x);
   x.add(new Cart("A"));
   x.add(new Cart("B"));
   x.add(new Cart("C"));
   //BREAKPOINT
   if(x.remove(1).compareTo(new Cart("B"))!=0) return false;
   if(x.size()!=2) return false;
   if(x.readForward().compareTo("AC")!=0) return false;
   x.add(new Cart("D"));
   x.add(new Cart("X"));
   x.add(new Cart("J"));
   System.out.println(x);
   x.remove(x.size()-1);
   System.out.println(x);
   return true;
 }


 /**
  * This method calls all the test methods defined and implemented in your AlphabetListTester
  * class.
  * 
  * @return true if all the test methods defined in this class pass, and false otherwise.
  */
 public static boolean runAllTests() {
   AlphabetList x = new AlphabetList();
   if(x.isEmpty()!=true) return false; //isEmpty
   if(x.capacity()!=26) return false; //capacity
   x.add(new Cart("B"));
   if(x.remove(0).compareTo(new Cart("B"))!=0) {
     return false;
   }
   System.out.println(x);
   x.add(new Cart("B"));
   x.add(new Cart("A")); //insertBefore
   x.add(new Cart("C")); // insertAfter
   if(x.readForward().compareTo("ABC")!=0) return false; //readForward
   if(x.readBackward().compareTo("CBA")!=0) return false; //readBackward
   if(x.remove(1).compareTo(new Cart("B"))!=0) return false;
   if(x.size()!=2) return false;
   x.add(new Cart("B"));
   x.add(new Cart("Z"));
   System.out.println(x); //toString
   x.remove(x.size()-1);
   System.out.println(x);
   if(x.get(0).compareTo(new Cart("A"))!=0) return false; //get
   if(x.indexOf(new Cart("B"))!=1) return false; //indexOf
   x.clear(); //clear
   return true;
 }
 
}

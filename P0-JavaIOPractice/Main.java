//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:   p0 JavaIOPractice
// Files:   Main
// Course:  CS400, Summer 2020
//
// Author:  Nolan Smith
// Email:   nosmith@wisc.edu
// Lecturer's Name: Florian Heimerl
//
// Program Description: 
//
///////////////////////////////////////////////////////////////////////////////
import java.io.File;
import java.util.Scanner;
public class Main {

  private static final Scanner scnr = new Scanner(System.in);
  private static final Scanner scnr2;
  private static final String title = "Nolan Smith | nosmith@wisc.edu";
  private static double total = 0.00;
  private static double hmbrg = 4.25;
  private static double chzbrg = 5.00;
  private static double chknTndr = 4.50;
  private static double fry = 3.00;
  private static double curds = 3.75;
  private static double drink = 1.5;
  static File f;
      
  public static void main(String [] args) {
    System.out.println(title);
    System.out.print("\nHello Customer! Please make a food selection(Type one item at a time)!\nOr enter \"file\" followed by the *filename* if you wish to use a file for your order.");
    System.out.print("\n1) Hamburger\n2) Cheeseburger\n3) Chicken Tenders\n4) Fries\n5) Cheese Curds\n");
    //System.out.print("\n\nEnter \"Complete Order\" for Checkout!");
    
    try {
    while(scnr.hasNext()) {
    String item = scnr.nextLine();
    if(item.contains("file")) {
      fileReader(item);
    }
    input(item);
    }
    } catch (IllegalStateException e) {}
  }
  /*
   * This method takes the input from the user and compares it to different menu items
   * in order to correctly calculate the total price of the order.
   * 
   *@param String item entered by user in console window
   *
   *
   */
  private static void input(String item) {
    if(item.contains("file")) {
      fileReader(f);
    }
    if(item.equalsIgnoreCase("hamburger")){
      total += hmbrg;
      System.out.println("\nHamburger Added.\nYour total is : $" + total);
      System.out.print("Make another selection or enter \"Complete Order\" to checkout:\n");
    } else
    if(item.equalsIgnoreCase("cheeseburger")){
      total += chzbrg;
      System.out.println("\nCheeseburger Added.\nYour total is : $" + total);
      System.out.print("Make another selection or enter \"Complete Order\" to checkout:\n");
    } else
    if(item.equalsIgnoreCase("chicken tenders")){
      total += chknTndr;
      System.out.println("\nChicken Tenders Added.\nYour total is : $" + total);
      System.out.print("Make another selection or enter \"Complete Order\" to checkout:\n");
    } else
    if(item.equalsIgnoreCase("fries")){
      total += fry;
      System.out.println("\nFries Added.\nYour total is : $" + total);
      System.out.print("Make another selection or enter \"Complete Order\" to checkout:\n");
    } else
    if(item.equalsIgnoreCase("cheese curds")){
      total += curds;
      System.out.println("\nCheese Curds Added.\nYour total is : $" + total);
      System.out.print("Make another selection or enter \"Complete Order\" to checkout:\n");
    } else
    if(item.equalsIgnoreCase("drink")){
      total += drink;
      System.out.println("\nCheese Curds Added.\nYour total is : $" + total);
      System.out.print("Make another selection or enter \"Complete Order\" to checkout:\n");
      } else
    if(item.equalsIgnoreCase("Complete Order")) {
      System.out.print("\nYour order is complete! Your Total is: $" + total + "\nPlease pull forward to the first window :)");
      scnr.close();
    } else
      System.out.println("\nCould not interpret your selection... Please re-enter!");
  }
  
  
  /*
   * This method
   */
  public static void fileReader(String file) {
      scnr2 = new Scanner()
      f = new File(scnr.nextLine());
  }
}

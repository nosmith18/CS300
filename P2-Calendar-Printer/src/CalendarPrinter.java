//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:   Calendar Printer
// Files:   (a list of all source files used by that program, including tests)
// Course:  CS300, Spring, 2020
//
// Author:  Nolan Smith
// Email:   nosmith@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name:    Dennis Kelly
// Partner Email:   dfkelly2@wisc.edu
// Partner Lecturer's Name: Gary Dahl
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _X_ Write-up states that pair programming is allowed for this assignment.
//   _X_ We have both read and understood the course Pair Programming Policy.
//   _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course 
// staff must fully acknowledge and credit those sources here.  If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons:         NONE
// Online Sources:  NONE besides the given algorithms and links in the Write-up
//
///////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.Scanner;

public class CalendarPrinter {

  /**
  * Driver for the CalendarPrinter Application. This program asks the user to enter
  * an initial month, an initial year, and the total number of months to create and
  * display in calendar form.
  * @param args is not used by this program
  */
  public static void main(String [] args) {
   // print welcome message
   Scanner in = new Scanner(System.in);
   System.out.println("Welcome to the Calendar Printer.");
   System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
   // read input from the user
   System.out.print("Enter the month to begin calendar: ");
   String monthString = in.nextLine().trim();
   System.out.print("Enter the year to begin calendar: ");
   String yearString = in.nextLine().trim();
   System.out.print("Enter the number of months to include in this calendar: ");
   String countString = in.nextLine().trim();
   // convert user input into usable form
   monthString = monthString.substring(0,3).toUpperCase();
   MonthOfYear month = null;
   for(int i=0;i<MonthOfYear.values().length;i++)

  if(monthString.equals(MonthOfYear.values()[i].name().substring(0,3).toUpperCase()))
   month = MonthOfYear.values()[i];
   Year year = new Year(Integer.parseInt(yearString.trim()));
   int count = Integer.parseInt(countString.trim());
   // create months and display them in calendar form
   System.out.println();
   createAndPrintMonths(month,year,count);
   // display thank you message
   System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
   System.out.println("Thanks, and have a nice day.");
   in.close();
  }
  
  /**
  * Calculates the number of centuries (rounded down) between year 0 and the
  * specified year. For example, the year 2034 has the century index of 20 (as do
  * the other years 2000-2099).
  * @param year to compute the century offset for
  * @return number of centuries between year 0 and the specified year
  */
  public static int fullCenturiesContained(Year year) {
    return year.intValue()/100;
  }
  
  /**
   * Calculates the number of years between the specified year and the first year of
   * its century. For example, the year 2034 has the offset within its century of 34
   * (as do 1234 and 9999934).
   * @param year to compute the offset within century for
   * @return number of years between the specified year and the first year of century
   */
   public static int yearOffsetWithinCentury(Year year) {
     return year.intValue()%100;
   }
   
   /**
   * This method computes whether the specified year is a leap year or not.
   * @param year is the year is being checked for leap-year-ness
   * @return true when the specified year is a leap year, and false otherwise
   */
   public static boolean isLeapYear(Year year) {
     int yearNum=year.intValue();
     System.out.println(yearNum%4);
     if(yearNum%4 != 0)
       return false;
     else if(yearNum%100 != 0)
         return true;
       else if(yearNum%400 != 0)
         return false;
     return true;
   }
   
   /**
   * Calculates the number of days in the specified month, while taking into
   * consideration whether or not the specified month is in a leap year.
   * Note: that this is calculated based on the month's monthOfYear and year, and
   * is NOT retrieved from the month's getDayCount() method. This is because this
   * method is used to generate the day objects that are stored within each month.
   * @param month to determine the number of days within (within its year)
   * @return the number of days in the specified month (between 28-31)
   */
   public static int numberOfDaysInMonth(Month month) {
     
     if(month.getMonthOfYear().equals(MonthOfYear.February)) {
       if(isLeapYear(month.getYear())==true) 
         return 29;
       else return 28;
     }
     if(month.getMonthOfYear().equals(MonthOfYear.April) || month.getMonthOfYear().equals(MonthOfYear.June) 
         || month.getMonthOfYear().equals(MonthOfYear.September) || month.getMonthOfYear().equals(MonthOfYear.November)) {
       return 30;
     }
     return 31;
   }
   
   
   /**
   * Calculates which day of the week the first day of the specified month falls on.
   * Note: that this is calculated based on the month's monthOfYear and year, and
   * is NOT retrieved from the month's getDayByDate(1) day. This is because this
   * method is used to generate the day objects that are stored within each month.
   * @param month within which we are calculate the day of week for the first day
   * @return DayOfWeek corresponding to the first day within the specified month
   */
   public static DayOfWeek calcFirstDayOfWeekInMonth(Month month) {
     int q = 0; // Day of the month 
     int h = 0; // Day of Week
     int m = 0; // Month of year int value
     int k = yearOffsetWithinCentury(month.getYear()); // Year value offset from century
     int j = fullCenturiesContained(month.getYear()); // Number of full centuries in year
     if(month.getMonthOfYear().ordinal()==0)
       m=13;
     if(month.getMonthOfYear().ordinal()==1)
       m=14;
     else 
       m=month.getMonthOfYear().ordinal();
     
     h = (q + (13*(m+1)/5) + k + k/4 + j/4 + 5*j)%7;
     
     switch(h) {
       case 0:
         return DayOfWeek.Saturday;
       case 1:
         return DayOfWeek.Sunday;
       case 2:
         return DayOfWeek.Monday;
       case 3:
         return DayOfWeek.Tuesday;
       case 4:
         return DayOfWeek.Wednesday;
       case 5:
         return DayOfWeek.Thursday;
       case 6:
         return DayOfWeek.Friday;
       default:
         return DayOfWeek.Saturday;
       } 
     
     }
   
   /**
   * Calculates the day of the week that follows the specified day of week.
   * For example, Thursday comes after Wednesday, and Monday comes after Sunday.
   * @param dayBefore is the day of week that comes before the day of week returned
   * @return day of week that comes after dayBefore
   */
   
   public static DayOfWeek dayOfWeekAfter(DayOfWeek dayBefore) {
     if(dayBefore.equals(DayOfWeek.Monday)) return DayOfWeek.Tuesday;
     if(dayBefore.equals(DayOfWeek.Tuesday)) return DayOfWeek.Wednesday;
     if(dayBefore.equals(DayOfWeek.Wednesday)) return DayOfWeek.Thursday;
     if(dayBefore.equals(DayOfWeek.Thursday)) return DayOfWeek.Friday;
     if(dayBefore.equals(DayOfWeek.Friday)) return DayOfWeek.Saturday;
     if(dayBefore.equals(DayOfWeek.Saturday)) return DayOfWeek.Sunday;
     return DayOfWeek.Monday;
   }
   
   /**
   * Calculates the month of the year that follows the specified month. For example,
   * July comes after June, and January comes after December.
   * @param monthBefore is the month that comes before the month that is returned
   * @return month of year that comes after monthBefore
   */
   public static MonthOfYear monthOfYearAfter(MonthOfYear monthBefore) {
     if(monthBefore.equals(MonthOfYear.January)) return MonthOfYear.February;
     if(monthBefore.equals(MonthOfYear.February)) return MonthOfYear.March;
     if(monthBefore.equals(MonthOfYear.March)) return MonthOfYear.April;
     if(monthBefore.equals(MonthOfYear.April)) return MonthOfYear.May;
     if(monthBefore.equals(MonthOfYear.May)) return MonthOfYear.June;
     if(monthBefore.equals(MonthOfYear.June)) return MonthOfYear.July;
     if(monthBefore.equals(MonthOfYear.July)) return MonthOfYear.August;
     if(monthBefore.equals(MonthOfYear.August)) return MonthOfYear.September;
     if(monthBefore.equals(MonthOfYear.September)) return MonthOfYear.October;
     if(monthBefore.equals(MonthOfYear.October)) return MonthOfYear.November;
     if(monthBefore.equals(MonthOfYear.November)) return MonthOfYear.December;
     return MonthOfYear.January;
   }
   
   /**
   * Creates a new month object and fully initializes with its corresponding days.
   * @param monthOfYear which month of the year this new month represents
   * @param year in which this month is a part
   * @return reference to the newly created month object
   */
   public static Month createNewMonth(MonthOfYear monthOfYear, Year year) {
     Month newMonth = new Month(monthOfYear, year);
     DayOfWeek specificDay = calcFirstDayOfWeekInMonth(newMonth);
     int date = 1;
     Day day = new Day(specificDay, date, newMonth);
     int numDays = numberOfDaysInMonth(newMonth);
     
     for(int i=0;i<=numDays; i++) {
       newMonth.addDay(day);
       specificDay=dayOfWeekAfter(specificDay);
       date++;
       day = new Day(specificDay, date, newMonth);
     }
     return newMonth;
   }
  
   /**
   * Prints the contents of the specified month object in calendar form. This
   * printout should begin with the Month an year of the month. The next line should
   * contain the three letter abbreviations for the seven days of the week. And then
   * the dates of each day of that month should follow: one week per line, with
   * periods in positions of days that are a part of the month before or after. For
   * example, January 2020 should be printed as follows:
   *
   * January 2020
   * MON TUE WED THU FRI SAT SUN
   * . . 1 2 3 4 5
   * 6 7 8 9 10 11 12
   * 13 14 15 16 17 18 19
   * 20 21 22 23 24 25 26
   * 27 28 29 30 31 . .
   *
   * @param month which is to be printed by this method
   */
   public static void printMonth(Month month) {
     int date = 1;
     System.out.println(month.getMonthOfYear() + " " + month.getYear());
     System.out.println("MON" + " " + "TUE" + " " + "WED" + " " + "THU" + " " + "FRI" + " " + "SAT" + " " + "SUN");
     switch (CalendarPrinter.calcFirstDayOfWeekInMonth(month)) {
     case Monday:
            break;
     case Tuesday:
            System.out.print(" .  ");
            break;
     case Wednesday:
            System.out.print(" .   .  ");
            break;
     case Thursday:
            System.out.print(" .   .   .  ");
            break;
     case Friday:
            System.out.print(" .   .   .   .  ");
            break;
     case Saturday:
            System.out.print(" .   .   .   .   .  ");
            break;
     case Sunday:
            System.out.print(" .   .   .   .   .   .  ");
            break; 
     }
     for (int i = 0; i < CalendarPrinter.numberOfDaysInMonth(month); i++) {
           System.out.print(date);    
           if(date < 10) 
             System.out.print("   ");
           else System.out.print("  ");
            if (month.getDayByDate(date).getDayOfWeek() == DayOfWeek.Sunday) {
                System.out.print("\n ");
            }
            if (date != CalendarPrinter.numberOfDaysInMonth(month)) {
            date++;
            }
     }
     switch (month.getDayByDate(date).getDayOfWeek()) {
     case Sunday:
            break;
     case Saturday:
            System.out.print(".   ");
            break;
     case Friday:
            System.out.print(".   .   ");
            break;
     case Thursday:
            System.out.print(".   .   .   ");
            break;
     case Wednesday:
            System.out.print(".   .   .   .   ");
            break;
     case Tuesday:
            System.out.print(".   .   .   .   .   ");
            break;
     case Monday:
            System.out.print(".   .   .   .   .   .   ");
            break;
     }
     System.out.println("");
   }

   
   /**
   * Creates an array list of months that are initialized with their full complement
   * of days. Prints out each of these months in calendar form, and then returns the
   * resulting ArrayList.
   * @param month of the year for the first month that is created and printed
   * @param year that the first month created and printed is a part of
   * @param count is the total number of sequential months created and printed
   * @return the array list of months that this method generates and prints.
   */
   public static ArrayList<Month> createAndPrintMonths(MonthOfYear month, Year year, int count){
     Month temp;
      ArrayList<Month> months = new ArrayList<Month>();
     for (int i = 0; i < count; i++) {
     temp = createNewMonth(month, year);
      months.add(temp);
      printMonth(temp);
     month = monthOfYearAfter(month);
     if (month == MonthOfYear.January) {
            year = new Year(year.intValue() + 1);
     }
     }
     return months;
   }
  
}

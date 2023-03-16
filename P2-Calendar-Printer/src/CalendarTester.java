public class CalendarTester {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(testFullCenturiesContained());
    System.out.println(testYearOffsetWithinCentury());
    System.out.println(testIsLeapYear());
    System.out.println(testNumberOfDaysInMonth());
    System.out.println(testCalcFirstDayOfWeekInMonth());
    System.out.println(testDayOfWeekAfter());
    System.out.println(testMonthOfYearAfter());
    System.out.println(testCreateNewMonth());
    
  }

  public static boolean testFullCenturiesContained () {
  if(CalendarPrinter.fullCenturiesContained(new Year(2)) != 0) return false;
  System.out.println("Number of Centuries was correct!");
  if(CalendarPrinter.fullCenturiesContained(new Year(2020)) != 20) return false;
  System.out.println("Number of Centuries was correct!");
  if(CalendarPrinter.fullCenturiesContained(new Year(44444)) != 444) return false;
  System.out.println("Number of Centuries was correct!");
  return true;
 }
  
  public static boolean testYearOffsetWithinCentury() {
    if(CalendarPrinter.yearOffsetWithinCentury(new Year(2007))!=7) return false;
    System.out.println("Year off of century was correct!");
    if(CalendarPrinter.yearOffsetWithinCentury(new Year(1997))!=97) return false;
    System.out.println("Year off of century was correct!");
    if(CalendarPrinter.yearOffsetWithinCentury(new Year(243567))!=67) return false;
    System.out.println("Year off of century was correct!");
    return true;
  }
  //BREAK POINT
  public static boolean testIsLeapYear() {
    if(CalendarPrinter.isLeapYear(new Year(2000))!=true) { // Checks a Leap Year year
      System.out.println("Method does not work correctly");
      return false; 
    }
    if(CalendarPrinter.isLeapYear(new Year(2100))!=false) { // Checks a non-leap year year
      System.out.println("Method does not work correctly");
      return false;
    }
    if(CalendarPrinter.isLeapYear(new Year(2001))!=false) { // Checks a non-leap year year
      System.out.println("Method does not work correctly");
      return false;
    }
    return true;
  }
  
  
  public static boolean testNumberOfDaysInMonth() {
    if(CalendarPrinter.numberOfDaysInMonth(new Month(MonthOfYear.February, new Year(2000)))!=29) return false; 
    System.out.println("Number of days was correct!");
    if(CalendarPrinter.numberOfDaysInMonth(new Month(MonthOfYear.August, new Year(2000)))!=31) return false;
    System.out.println("Number of days was correct!");
    if(CalendarPrinter.numberOfDaysInMonth(new Month(MonthOfYear.February, new Year(1997)))!=28) return false;
    System.out.println("Number of days was correct!");
    if(CalendarPrinter.numberOfDaysInMonth(new Month(MonthOfYear.September, new Year(2005)))!=30) return false;
    System.out.println("Number of days was correct!");
    return true;
  }
  
  public static boolean testCalcFirstDayOfWeekInMonth() {
    
    return true;
  }
  
  public static boolean testDayOfWeekAfter() {
    if(CalendarPrinter.dayOfWeekAfter(DayOfWeek.Friday).equals(DayOfWeek.Saturday)) {
      System.out.println("Correct day of week!");
    }
    if(CalendarPrinter.dayOfWeekAfter(DayOfWeek.Sunday).equals(DayOfWeek.Monday)) {
      System.out.println("Correct day of week!");
    }
    if(CalendarPrinter.dayOfWeekAfter(DayOfWeek.Monday).equals(DayOfWeek.Tuesday)) {
      System.out.println("Correct day of week!");
    }
    return true;
  }
  
  public static boolean testMonthOfYearAfter() {
    if(CalendarPrinter.monthOfYearAfter(MonthOfYear.March).equals(MonthOfYear.April)) {
      System.out.println("Correct month of year!");
    }
    if(CalendarPrinter.monthOfYearAfter(MonthOfYear.August).equals(MonthOfYear.September)) {
      System.out.println("Correct month of year!");
    }
    if(CalendarPrinter.monthOfYearAfter(MonthOfYear.December).equals(MonthOfYear.January)) {
      System.out.println("Correct month of year!");
    }
    return true;
  }

  public static boolean testCreateNewMonth() {
    
    return true;
  }
  
}

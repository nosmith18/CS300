
public class PiggyBankTester {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    /**
     * Calls the test methods implemented in this class and displays their output
     * 
     * @param args input arguments if any
     */
    System.out.println(getBalanceTestMethod());
    System.out.println(getCoinNameTestMethod());
    System.out.println(removeCoinTester());
    System.out.println(emptyPiggyBankTestMethod());
    System.out.println(withdrawTestMethod());
    System.out.println(getSpecificCoinCountTestMethod());

  }

  /**
   * Checks whether PiggyBank.getCoinName() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean getCoinNameTestMethod() {
    // consider all coin values as input arguments
    for (int i = 0; i < PiggyBank.COINS_VALUES.length; i++)
      if (!PiggyBank.getCoinName(PiggyBank.COINS_VALUES[i]).equals(PiggyBank.COINS_NAMES[i]))
        return true;
    // consider input argument which does not correspond to a coin value
    if (!PiggyBank.getCoinName(7).equals(PiggyBank.NO_SUCH_COIN))
      return true;
    if (!PiggyBank.getCoinName(-10).equals(PiggyBank.NO_SUCH_COIN))
      return true;
    return false;
  }

  /**
   * Checks whether PiggyBank.getBalance() method works as expected.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean getBalanceTestMethod() {
    // scenario 1 - empty piggy bank
    int[] coins = new int[10]; // array storing the coins held in a piggy bank
    int size = 0; // number of coins held in coins array
    if (PiggyBank.getBalance(coins, size) != 0) {
      System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
          + "return the expected output when passed an empty piggy bank.");
      return false;
    }
    // scenario 2 - non empty piggy bank
    coins = new int[] {10, 1, 5, 25, 1, 0, 0};
    size = 5;
    if (PiggyBank.getBalance(coins, size) != 42) {
      System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
          + "return the expected output when passed an piggy bank that holds "
          + "two pennies, a nickel, a dime, and a quarter.");
      return false;
    }
    // scenario 3 - another non empty piggy bank
    coins = new int[] {10, 1, 5, 25, 1, 0};
    size = 3;
    if (PiggyBank.getBalance(coins, size) != 16) {
      System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
          + "return the expected output when passed an piggy bank that holds "
          + "a penny, a nickel, and a dime, only.");
      return false;
    }
    return true;
  }

  public static boolean getSpecificCoinCountTestMethod() {

    int[] testArray = new int[20];
    testArray = new int[] {25, 10, 5, 10, 1, 1, 25, 5};
    int testSize = 7;
    if (PiggyBank.getSpecificCoinCount(1, testArray, testSize) != 2) { // tests a penny and a quarter from filled Piggy Bank
      return false;
    }
    if (PiggyBank.getSpecificCoinCount(25, testArray, testSize) != 2) {
      return false;
    }
    testArray = new int[] {};
    testSize = 0;
    if (PiggyBank.getSpecificCoinCount(1, testArray, testSize) != 0) { // test empty piggyBank
      return false;
    }

    return true;
  }

  public static boolean removeCoinTester() {
    int[] testArray = new int[] {25, 10, 5, 10, 1, 1, 25, 5}; 
    int testSize = 8; //size
    System.out.println(PiggyBank.removeCoin(testArray, testSize)); // test println message and new size of array after coin is removed
    return true;
  }

  public static boolean emptyPiggyBankTestMethod() { // println test to empty the piggy bank
    int[] coins = new int[20];
    int size = 7;
    coins = new int[] {5, 5, 5, 5, 5, 5, 5};
    System.out.println(PiggyBank.emptyPiggyBank(coins, size));

    return true;
  }


  public static boolean withdrawTestMethod() {
    int[] coins = new int[20];
    int amount = 0;
// BREAK POINT
    coins = new int[] {1, 1, 5, 5, 5, 10, 10, 25, 25};
    int size = 9;
    amount = 40;
    int[] checker = new int[] {6, 1, 1, 1, 0};
    int[] output = PiggyBank.withdraw(amount, coins, size);
    for (int i = 0; i < output.length; i++) {
      if (output[i] != checker[i]) {
        return false;
      }
    }

    //BREAK POINT
    coins = new int[] {5, 5, 25, 25}; // tests for 
    size = coins.length;
    amount = 6;
    checker = new int[]{2,0,0,1,1};
    output = PiggyBank.withdraw(amount, coins, size);
    for (int i = 0; i < output.length; i++) {
      if (output[i] != checker[i]) {
        return false;
      }
    }
    coins = new int[] {}; // This test checks to see if withdraw method prints out "Not enough change..." message
    size = coins.length;
    amount = 20;
    checker = new int[] {0,0,0,0,0};
    output = PiggyBank.withdraw(amount, coins, size);
    for (int i = 0; i < output.length; i++) {
      if (output[i] != checker[i]) {
        return true;
      }
    }
    return true;
  }


}

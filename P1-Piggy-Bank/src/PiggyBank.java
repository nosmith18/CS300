import java.util.Random;

public class PiggyBank {

  public final static int[] COINS_VALUES = {1, 5, 10, 25}; // coins values in cents
  // coins names
  public final static String[] COINS_NAMES = {"PENNY", "NICKEL", "DIME", "QUARTER"};
  public final static String NO_SUCH_COIN = "N/A"; // N/A string
  private final static Random RAND_GEN = new Random(100); // generator of random integers

  /**
   * Returns the name of a specified coin value
   * 
   * @param coin represents a coin value in cents.
   * @return the String name of a specified coin value if it is valid and N/A if the coin value is
   *         not valid
   */
  public static String getCoinName(int coin) {

    if (coin == 1)
      return "Penny";
    if (coin == 5)
      return "Nickel";
    if (coin == 10)
      return "Dime";
    if (coin == 25)
      return "Quarter";
    return "N/A"; // return an empty string
  }

  /**
   * Returns the balance of a piggy bank in cents
   * 
   * @param coins an oversize array which contains all the coins held in a piggy bank
   * @param size  the total number of coins stored in coins array
   * @return the total value of the coins held in a piggy bank in cents
   */
  public static int getBalance(int[] coins, int size) {
    int piggyBankBalance = 0; // count for total balance of piggy bank
    for (int i = 0; i < size; i++)
      piggyBankBalance += coins[i];
    return piggyBankBalance;
  }

  /**
   * Returns the total number of coins of a specific coin value held in a piggy bank
   *
   * @param coinValue the value of a specific coin
   * @param coins     an oversize array which contains all the coins held in a piggy bank
   * @param size      the total number of coins stored in coins array
   * @return the number of coins of value coinValue stored in the array coins
   */
  public static int getSpecificCoinCount(int coinValue, int[] coins, int size) {
    int coinCount = 0; // counter of specific coin
    if (size == 0)
      return 0;
    for (int i = 0; i < size; i++)
      if (coins[i] == coinValue) {
        coinCount++; // if coinValue is found in array, counter is increased
        
      }
    return coinCount;

  }

  /**
   * Displays information about the content of a piggy bank
   *
   * @param coins an oversize array storing the coins held in a piggy bank
   * @param size  number of coin held array coins
   */
  public static void printPiggyBank(int[] coins, int size) {
    System.out.println("QUARTERS: " + getSpecificCoinCount(25, coins, size));
    System.out.println("DIMES: " + getSpecificCoinCount(10, coins, size));
    System.out.println("NICKELS: " + getSpecificCoinCount(5, coins, size));
    System.out.println("PENNIES: " + getSpecificCoinCount(1, coins, size));
    System.out.println("Balance: $" + getBalance(coins, size) * 0.01);
  }

  /**
   * Adds a given coin to a piggy bank. This operation can terminate successfully or unsuccessfully.
   * For either cases, this method displays a descriptive message for either cases.
   *
   * @param coin  the coin value in cents to be added to the array coins
   * @param coins an oversize array storing the coins held in a piggy bank
   * @param size  the total number of coins contained in the array coins before this addCoin method
   *              is called.
   * @return the new size of the coins array after trying to add coin.
   */
  public static int addCoin(int coin, int[] coins, int size) {
    int newSize = size; //copy of size to return after method finshes
    if (coin == 1 || coin == 5 || coin == 10 || coin == 25) {
      coins[size] = coin;
      newSize++;
      System.out.println("\nAdded a " + getCoinName(coin));
      return newSize;
    }
    System.out.println("Coin could not be added to Piggy Bank.");
    return newSize;
  }

  /**
   * Removes an arbitrary coin from a piggy bank. This method may terminate successfully or
   * unsuccessfully. In either cases, a descriptive message is displayed.
   *
   * @param coins an oversize array which contains the coins held in a piggy bank
   * @param size  the number of coins held in the coins array before this method is called
   * @return the size of coins array after this method returns successfully
   */

  public static int removeCoin(int[] coins, int size) {
    int removedCoin = 0;    // Value of coin removed
    if (size == 0) {    // Test if Piggy Bank is empty
      System.out.println("Could not remove a coin because the Piggy Bank is empty!");
      return size;
    }

    int randomNumber = RAND_GEN.nextInt(size);  // Instantiates an int with random value between 0 (inclusive) and the size of the array (exclusive).
    removedCoin = coins[randomNumber];
    coins[randomNumber] = coins[size - 1];  // Changes value at index of removed coin into the last value in the array
    coins[size - 1] = 0;    // Turns last index of array into a 0
    size--;
    System.out.println("\nYou removed a " + getCoinName(removedCoin));
    System.out.println("Number of Coins in Piggy Bank: " + size);
    return size;
  }
  
  public static int removeSpecificCoin(int value, int numberToRemove, int[]coins, int size) {
    int coinsRemoved = 0; // Counts how many of specific coin are removed in order to resize array correctly
    int newSize=size; 
    while(numberToRemove>0) // number of coins of specified "value" (25,10,5,1) need to be removed
    for(int i=0; i<size; i++) {
      if(coins[i]==value) {
        coinsRemoved++;
        coins[i]=coins[size-coinsRemoved];
        coins[size-coinsRemoved]=0;
        i--;
        numberToRemove--;
      }
      if(numberToRemove==0)
        break;  
   }
    newSize-=coinsRemoved; // resized to account for the number of coinsRemoved
    return newSize;
  }

  /**
   * Removes all the coins in a piggy bank. It also displays the total value of the removed coins
   *
   * @param coins an oversize array storing the coins held in a piggy bank application
   * @param size  number of coins held in coins array before this method is called
   * @return the new size of the piggy bank after removing all its coins.
   */
  public static int emptyPiggyBank(int[] coins, int size) {
    int totalRemovedValue = 0;
    if (size == 0) {
      System.out.println("Zero coins were removed because the Piggy Bank is empty.");
      return 0;
    }
    for (int i = 0; i < size; i++) { // Adds value of removed coins up using a for loop
      totalRemovedValue += coins[i];
      coins[i] = 0; // Sets each removed coin's index in array to 0
    }
    System.out.println("All " + totalRemovedValue + " cents were removed from the Piggy Bank.");
    System.out.println("The number of coins in the Piggy Bank is: 0");
    return 0;
  }

  /**
   * Removes the least number of coins needed to fulfill a withdrawal request
   *
   * @param amount amount to withdraw given in cents
   * @param coins  an oversize array storing the coins held in a piggy bank
   * @param size   number of coins stored in coins array before this method is called
   * @return perfect size array of 5 elements, index 0 stores the new size of the piggy bank after
   *         this method returns. Indexes 1, 2, 3, and 4 store respectively the number of removed
   *         quarters, dimes, nickels, and pennies.
   */
  public static int[] withdraw(int amount, int[] coins, int size) {
    int newSize = size; //copy of the size of incoming coins array
    int[] piggyContents = new int[] {size,0,0,0,0}; // The array that will be returned for withdraw method 
    int amountToRemove = amount; //copy of amount to be removed
    
    int pennyRemoved = 0; // Counts of # of each coin removed 
    int nickelRemoved = 0;
    int dimeRemoved = 0;
    int quarterRemoved = 0;

    int pennyCount = getSpecificCoinCount(1, coins, newSize); // # of each coin in the Coins array(Piggy Bank)
    int nickelCount = getSpecificCoinCount(5, coins, newSize);
    int dimeCount = getSpecificCoinCount(10, coins, newSize);
    int quarterCount = getSpecificCoinCount(25, coins, newSize);

    if (amountToRemove > getBalance(coins, size)) { // Test if amountToRemove is bigger than the total amount in Piggy Bank
      System.out.println("Unable to draw " + amount + " cents. Not enough money in Piggy Bank!");
      return piggyContents;
    }
    
    if(amountToRemove == getBalance(coins, size)) { // Test if amountToRemover is equal to total value in Piggy Bank. If so, all coins are removed.
      System.out.println("All " + amountToRemove + " cents were removed. Your Piggy Bank is empty");
      piggyContents[0]=0;   // New Size of piggy bank is 0
      piggyContents[1]=quarterCount;    // # of removed coins equals initial number of each coin
      piggyContents[2]=dimeCount;
      piggyContents[3]=nickelCount;
      piggyContents[4]=pennyCount;
      emptyPiggyBank(coins,size);
      return piggyContents;
    }
    
    while (amountToRemove > 0) { //while loop that gradually removes coins from Piggy Bank. Removes largest to smallest.
      while(amountToRemove >= 25 && quarterCount > 0) {
        quarterRemoved++;
        quarterCount--;
        amountToRemove -= 25;
      }
      while (amountToRemove >= 10 && dimeCount > 0) {
        dimeRemoved++;
        dimeCount--;
        amountToRemove -= 10;
      }
      while (amountToRemove >= 5 && nickelCount > 0) {
        nickelRemoved++;
        nickelCount--;
        amountToRemove -= 5;
      }
      while (amountToRemove >= 1 && pennyCount > 0) {
        pennyRemoved++;
        pennyCount--;
        amountToRemove--;
      }
     break; // Meant to break from while loop due to lack of exact change, otherwise it loops forever in some cases
    }   
  

    size=removeSpecificCoin(25,quarterRemoved,coins,size);
    size=removeSpecificCoin(10,dimeRemoved,coins,size);
    size=removeSpecificCoin(5,nickelRemoved,coins,size);
    size=removeSpecificCoin(1,pennyRemoved,coins,size);
    
    int totalCoinsRemoved = (quarterRemoved + dimeRemoved + nickelRemoved + pennyRemoved);  // Adds all coins removed to calculate newSize of array
    
    if(amountToRemove==0) { // We have exact change and are done.
      
      newSize -= totalCoinsRemoved;
      
      piggyContents[0] = newSize;
      piggyContents[1] = quarterRemoved;
      piggyContents[2] = dimeRemoved;
      piggyContents[3] = nickelRemoved;
      piggyContents[4] = pennyRemoved;

      
      //System.out.println("All " + amount + " cents were removed from Piggy Bank");
      return piggyContents;
      
    }
    else {  //We do not have exact change in Piggy Bank
      System.out.println("Not exact change in the piggy bank!"); // I was told by Professor Kacem that we could print this instead ??
      return piggyContents; 
    }
    
     // This For Loop will compare the absolute values - I think this deals with the problem of removing the least amount of coins to go over the amount withdrawn
     // I was told to use just the above println statement 
    
//    while(amountToRemove>0) {
//      if(quarterCount!=0 && Math.abs(amountToRemove-25)<Math.abs(amountToRemove-10)) {
//        quarterCount--; 
//        quarterRemoved++; 
//        amountToRemove-=25;
//     } 
//      if(dimeCount!=0 && Math.abs(amountToRemove-10)<Math.abs(amountToRemove-5)) { 
//        dimeCount--; 
//        dimeRemoved++;
//        amountToRemove-=10;
//     } 
//      if(nickelCount!=0 && Math.abs(amountToRemove-5)<Math.abs(amountToRemove-1)) { 
//        nickelCount--; nickelRemoved++;
//      amountToRemove-=5;
//     } 
//      if(pennyCount>0) { 
//        pennyCount--; 
//        pennyRemoved++; 
//        amountToRemove--; 
//     }
//    }
//     if(amountToRemove<0 && pennyRemoved>0) { 
//       pennyRemoved--; 
//       pennyCount++; 
//      }
//      if(amountToRemove<-5 && nickelRemoved>0) { 
//        nickelRemoved--; 
//        nickelCount++; 
//      }
//      if(amountToRemove<-10 && dimeRemoved>0) { 
//        dimeRemoved--; 
//        dimeCount++; 
//      } 
//      if(amountToRemove<-25 && quarterRemoved>0) { 
//        quarterRemoved--; 
//        quarterCount++; 
//       }
    
  }
}

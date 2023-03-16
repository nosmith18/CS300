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
public class AlphabetList implements SortedListADT<Cart>{
  private static final Cart MIN_CART = new Cart("A");
  private static final Cart MAX_CART = new Cart("Z");
  private LinkedCart head=null;
  private LinkedCart tail=null;
  private int size=0;
  private int capacity;
  
  public AlphabetList (int capacity) {
    //LinkedList<Cart> alphabet = new LinkedList<Cart>();
    if(capacity<=0) {
      throw new IllegalArgumentException("The Capacity of this list must be a non-zero positive integer");
    }
    this.capacity = capacity;
  }
  public AlphabetList() {
    //LinkedList<Cart> alphabet = new LinkedList<Cart>();
    capacity = 26;
  }
  
  /*
   * Checks whether the list is empty
   * 
   * @return true if empty, false if not empty
   */
  @Override
  public boolean isEmpty() {
    if(size==0) return true;
    else return false;
  }
  /*
   * Returns the size of the list
   * 
   * @return number of carts linked in the list
   */
  @Override
  public int size() {
    int count = 0;
    LinkedCart curCart = head;
    while(curCart!=null) {
      count++;
      curCart = curCart.getNext();
    }
    return count;
  }
  /*
   * Returns the capacity of this list in terms of maximum number of 
   * carts which can be stored in it.
   * 
   * @return capacity of this list
   */
  public int capacity() {
    return capacity;
  }
  /*
   * Adds a new Cart to this sorted list
   * 
   * @param newCart to be added
   * 
   * @throw IllegalArgumentException with a descriptive error message if newCart does not 
   *        carry one upper-case letter in the range "A" .. "Z" or if this list contains already a 
   *        cart carrying the same letter. The descriptive error messages for these two cases can 
   *        be respectively "Can only add carts carrying one upper-case alphabetic letter in the range 
   *        "A .. Z.", and "Cannot duplicate letters or carts in this list."
   *        
   *        IllegalStateException - with the following error message "This list is full. Cannot add 
   *        another cart." if this list reached its capacity.
   */
  @Override
  public void add(Cart newObject) {
    //BREAKPOINT
    if(newObject==null) {
      throw new NullPointerException("Cannot pass null as an argument");
    }
    if(newObject.compareTo(MAX_CART)>0 || newObject.compareTo(MIN_CART)<0) {
      throw new IllegalArgumentException("Can only add carts carrying one upper-case alphabetic letter in the range A .. Z.");
    }
    if(size == capacity) {
      throw new IllegalStateException("This list is full.");
    }
    if(size==0) {
      this.head = new LinkedCart(newObject, null, tail); //Should tail be set to the next on Head?
      this.tail = head;
      size++;
    }else {
    if(newObject.compareTo(head.getCart())<0) { // New inserted before head
      insertBefore(newObject);
    }else {
    if(newObject.compareTo(tail.getCart())>0) { // New inserted after tail
      insertAfter(newObject);
    }else {
    LinkedCart curNode = head;
    int comp = newObject.compareTo(curNode.getCart());
    while(comp > 0 && comp != 0) {
      curNode = curNode.getNext(); 
      comp = newObject.compareTo(curNode.getCart());
    }
    if(comp==0) {
      throw new IllegalStateException("Cannot duplicate letters or carts in this list.");      
    } else {
      LinkedCart newCart = new LinkedCart(newObject, curNode.getPrevious(),curNode);
      curNode.getPrevious().setNext(newCart);
      curNode.setPrevious(newCart);
      size++;
    }
    }
    }
    }
  }
  /*
   * Returns the index of the cart carrying data within this list
   * 
   * @param findCart - cart to find in this list
   * 
   * @return the index of findCart within this list or -1 if it does not contain it
   */
  @Override
  public int indexOf(Cart findCart) {
    LinkedCart curCart = head;
    for(int i=0; i<size; i++) {
      if(curCart.getCart().compareTo(findCart)==0) {
        return i;
      }
      curCart = curCart.getNext();
    }
    return -1;
  }
  /*
   * Removes all the carts from this list. This list must be empty after this method returns.
   */
  @Override
  public void clear() {
    this.head = null;
    size = 0;
    this.tail = null;
  }
  /*
   * Returns the cart at position index of this list without removing it
   * 
   * @param index of cart to return
   * 
   * @return Cart at specified index
   * 
   * @throw IndexOutOFBoundsException if index is invalid
   */
  @Override
  public Cart get(int index) {
    int count=0;
    if(index<0 || index>=size) {
      throw new IndexOutOfBoundsException("Invalid Index");
    }
    LinkedCart curCart = head;
    while(curCart!=null) {
      if(count==index) {
        return curCart.getCart();
      }
      curCart = curCart.getNext();
      count++;
    }
    return null;
  }
  /*
   * Returns and removes the cart from this sorted list at the given index position
   * 
   * @param index of cart to be removed
   * 
   * @return the removed Cart
   * 
   * @throw IndexOutOfBoundsException if index is invalid
   */
  @Override
  public Cart remove(int index) {
    LinkedCart curCart = head;
    LinkedCart nextCart = null;
    LinkedCart prevCart = null;
    if(index<0 || index>=size) {
      throw new IndexOutOfBoundsException("Invalid Index");
    }
    if(index==0 && size==1) { // removes the head, sets next cart to head if Index is 0 to start
      head=null;
      tail=null;
      size--;
      return curCart.getCart();
    }
    if(size==2 && index==0) { // two cart, head removal
      curCart = head;
      head = tail;
      head.setNext(null);
      head.setPrevious(null);
      tail.setPrevious(null);
      tail.setNext(null);
      size--;
      return curCart.getCart();
    }
    if(size==2 && index==1) { // two cart, tail remoal
      curCart = tail;
      tail = head;
      head.setNext(null);
      head.setPrevious(null);
      tail.setPrevious(null);
      tail.setNext(null);
      size--;
      return curCart.getCart();
    }
    if(size>=3 && index==0) { // three cart, head removal
      curCart = head;
      head = head.getNext();
      head.setPrevious(null);
      size--;
      return curCart.getCart();
    }
    if(size>=3 && index==(size-1)) { // three cart, tail removal
      curCart = tail;
      tail = tail.getPrevious();
      tail.setNext(null);
      size--;
      return curCart.getCart();
    }
    int count = 0; //counts index of CurCart
      while(curCart!=null) { // removal of middle cart for size greater or equal to 3
        prevCart = curCart.getPrevious();
        nextCart = curCart.getNext();
        if(count==index) {
          prevCart.setNext(nextCart);
          nextCart.setPrevious(prevCart);
          size--;
          return curCart.getCart();
        }
        curCart = nextCart;
        prevCart = curCart.getPrevious();
        nextCart = curCart.getNext();
        count++;
      }
      return null;
    }

  
  /*
   * Returns a String representation of this list. Note that the implementation 
   * details of this method is provided in the assignment's specification.
   * 
   * @return String representation of this list
   */
  public String toString() {
    String string = "This list contains " + size + " cart(s)";
    if (size == 0) {
    return string;
    }
    string += ": [ ";
    LinkedCart currentCart = head;
    while (currentCart != null) {
    string += currentCart.getCart().toString() + " ";
    currentCart = currentCart.getNext();
    }
    string += "]";
    return string;
  }
  /*
   * This method inserts a new Linked Cart in front of the head
   */
  private void insertBefore(Cart newObject) {
    LinkedCart oldHead = head;
    head = new LinkedCart(newObject, null, oldHead);
    oldHead.setPrevious(head);
    size++;
  }
  /*
   * This method inserts a new Linked Cart behind the tail
   */
  private void insertAfter(Cart newObject) {
    LinkedCart oldTail = tail;
    tail = new LinkedCart(newObject, oldTail, null);
    oldTail.setNext(tail);
    size++;
  }
  
  /*
   * Reads the contents of this list in the forward direction starting from its head.
   * 
   * @return a String representation of the contents of this list read in the forward 
   * direction or an empty string if this list is empty. For instance, if the list contains 
   * the following letters "A", "B", "D", "M", and "O". This method MUST return the following string "ABDMO".
   */
  public String readForward() {
    String string = "";
    if (size == 0) {
    return string;
    }
    LinkedCart currentCart = head;
    while (currentCart != null) {
    string += currentCart.getCart().toString();
    currentCart = currentCart.getNext();
    }
    return string;
  }
  
  /*
   * Reads the contents of this list in the backward direction starting from its tail
   * 
   * @return a String representation of the contents of this list read in the backward direction or an 
   * empty string if this list is empty. For instance, if the list contains the following letters 
   * "A", "B", "D", "M", and "O". This method MUST return the following string "OMDBA".
   */
  public String readBackward() {
    String string = "";
    if (size == 0) {
    return string;
    }
    LinkedCart currentCart = tail;
    while (currentCart != null) {
    string += currentCart.getCart().toString();
    currentCart = currentCart.getPrevious();
    }
    return string;
  }
  
}

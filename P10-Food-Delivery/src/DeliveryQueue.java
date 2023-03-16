//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:   P10 food Delivery
// Files:   Student, FoodRobot, Delivery, DeliveryQueue
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

import java.util.NoSuchElementException;

public class DeliveryQueue {
  private static final int INITIAL_CAPACITY = 20;
  private Delivery[] heap;
  private int size;
  
  public DeliveryQueue() {
    size = 0;
    heap = new Delivery[INITIAL_CAPACITY];
  }
  
  /*
   * Adds delivery to queue, if queue is full it is expanded and then added. Calls percolateUp to reheapify.
   */
  public void offerDelivery(Delivery d) {
    if(isEmpty()) {
      heap[0] = d;
      size = 1;
    } else
      if(size == heap.length) {
        Delivery[] newHeap = new Delivery[heap.length + INITIAL_CAPACITY];
        for(int i=0; i<heap.length; i++) {
          newHeap[i] = heap[i];
        }
        heap = newHeap;
        heap[size] = d;
        percolateUp(size);
        size++;
      } else {
      heap[size] = d;
      percolateUp(size);
      size++;
      }
  }
  
  /*
   * Returns and removes highest priority Delivery from heap, calls percolateDown(0) after swap with heap[size]
   * 
   * @return Highest priority delivery 
   * @throws NoSuchElementException if queue is empty
   */
  public Delivery pollBestDelivery() {
    if(isEmpty()) {
      throw new NoSuchElementException("Warning: Empty Heap!");
    }
    Delivery best = heap[0];
    heap[0] = heap[size-1];
    heap[size-1] = null;
    size--;
    percolateDown(0);
    for(int i = 0; i<size; i++) {
      if(heap[i].equals(best)){
        heap[i] = heap[size-1];
        heap[size-1] = null;
        size--;
        i--;
      }
    }
    return best;
  }
  
  /*
   * Shows the next delivery to be made if queue is not empty
   * 
   * @return highest priority delivery in queue
   * @throws NoSuchElementException if queue is empty
   */
  public Delivery peek() {
    if(size == 0) {
      throw new NoSuchElementException("Warning: Empty Heap!");
    } else
    return heap[0];
  }
  
  /*
   * @returns size of heap array
   */
  public int getSize() {
    return size;
  }
  
  /*
   * @returns true if empty, false otherwise
   */
  public boolean isEmpty() {
    if(size == 0) {
      return true;
    } else return false;
  }
  
  /*
   * Recursively calls heap order violations up
   */
  public void percolateUp(int index) {
    int parent = getParentIndex(index);
    
    if(heap[parent].compareTo(heap[index]) == 1) { //Child is higher priority than parent
      swap(index, parent);
      percolateUp(parent);
    }
  }
  
  /*
   * Recursively calls heap order violations down
   */
  public void percolateDown(int index) {
    int leftChild = getLeftChildIndex(index);
    int rightChild = getRightChildIndex(index);
    if(rightChild <= heap.length) {
    if(heap[leftChild] != null && heap[rightChild] != null) {
      if(heap[rightChild].compareTo(heap[leftChild]) == 1) { // enters if left is higher priority than right
        if(heap[index].compareTo(heap[leftChild]) == 1) { // leftChild is higher priority than parent
        swap(index, leftChild);
        percolateDown(leftChild);
        }
      } else 
        if(heap[index].compareTo(heap[rightChild]) == 1) { //rightChild is higher priority than parent
          swap(index, rightChild);
          percolateDown(rightChild);
        }
    } else
    if(heap[leftChild] != null) {
      if(heap[index].compareTo(heap[leftChild]) == 1) { // leftChild is higher priority than parent
        swap(index, leftChild);
        percolateDown(leftChild);
      }
    }      
    }
  }
  
  /*
   * Eliminates all heap order violations from heap array
   */
  public void heapify() {
    for(int i = size/2; i>=0; i--) {
      percolateDown(i);
    }
  }
  
  /*
   * @returns parentIndex of child argument
   */
  private int getParentIndex(int index) {
    return (index-1)/2;
  }
  
  /*
   * @returns leftChild of parent argument
   */
  private int getLeftChildIndex(int parentIndex) {
    return parentIndex * 2 + 1;
  }
  
  /*
   * @returns rightChild of parent argument
   */
  private int getRightChildIndex(int parentIndex) {
    return parentIndex * 2 + 2;
  }
  
  /*
   * Swaps the two Deliveries at index arguments of the heap
   */
  private void swap(int first, int second) {
    Delivery swap = heap[first];
    heap[first] = heap[second];
    heap[second] = swap;
  }
  
  /*
   * toString method that returns summary of queue
   * 
   * @returns String summary of queue
   */
  public String toString() {
    String string = "This DeliveryQueue contains " + size + " elements";
    if (size == 0) {
      return string;
    }
    string += ": [ ";
    for(int i=0; i<size; i++) {
      string += "\n" + heap[i].toString();
    }
    string += " ]\n";
    return string;
  }
  
  
}

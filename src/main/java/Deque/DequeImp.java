package Deque;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Your implementation of an ArrayQueue.
 */
public class DequeImp<T> {

    /*
     * The initial capacity of the ArrayQueue.
     *
     * DO NOT MODIFY THIS VARIABLE.
     */
    public static final int INITIAL_CAPACITY = 4;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int front;
    private int size;

    private boolean isEmpty(){
        return size == 0;
    }

    private boolean isFull(){
        return size == backingArray.length;
    }

    private void shift(){
        T[] newArray = (T[])new Object[backingArray.length * 2];
        for(int i = 0; i < size; i++){
            newArray[i] = backingArray[(front + i) % backingArray.length];
        }
        front = 0;
        backingArray = newArray;
    }

    /**
     * This is the constructor that constructs a new ArrayQueue.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    public DequeImp() {
        // DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the back of the queue.
     *
     * If sufficient space is not available in the backing array, resize it to
     * double the current length. When resizing, copy elements to the
     * beginning of the new array and reset front to 0.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the queue
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void enqueue(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(data == null) throw new IllegalArgumentException("Error: The Data Is Empty");
        if(isFull()) shift();
        backingArray[(front + size++) % backingArray.length] = data;
    }

    /**
     * Removes and returns the data from the front of the queue.
     *
     * Do not shrink the backing array.
     *
     * Replace any spots that you dequeue from with null.
     *
     * If the queue becomes empty as a result of this call, do not reset
     * front to 0.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the queue
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    public T dequeue() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(isEmpty()) throw new NoSuchElementException("Error: The Deque Is Empty");
        T removed = backingArray[front];
        backingArray[front] = null;
        front = (front == backingArray.length - 1) ? 0 : front + 1;
        System.out.println("Front: " + front);
        size--;
        return removed;
    }

    /**
     * Returns the backing array of the queue.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the queue
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the queue.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the queue
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    public static void main(String[] args){
        DequeImp<Integer> imp = new DequeImp<>();
        imp.enqueue(5);
        imp.enqueue(6);
        imp.enqueue(7);
        imp.enqueue(8);
        imp.dequeue();
        imp.dequeue();
        imp.enqueue(9);
        imp.enqueue(10);
        Object[] array = imp.getBackingArray();
        System.out.println("***Before***");
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
        imp.enqueue(11);

        array = imp.getBackingArray();

        System.out.println("***After***");

        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
}
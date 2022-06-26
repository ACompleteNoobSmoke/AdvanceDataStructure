package Deque;

import java.util.NoSuchElementException;

public class ArrayQueue<T> {

    public static final int initCap= 9;

    private T[] backingArray;
    private int front;
    private int size;


    public ArrayQueue() {
        backingArray = (T[]) new Object[initCap];
    }

    //Helper Methods

    private boolean isFull() {
        return size == backingArray.length;
    }

    private boolean isEmpty(){
        return size == 0;
    }

    private boolean isNull(T data) {
        return data == null;
    }

    private int backingArrayLength(){
        if(backingArray == null) return 0;
        return backingArray.length;
    }

    public void enqueue(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (isNull(data)) throw new IllegalArgumentException("Error: The Data Is Empty");
        if(isEmpty()) front = 0;
        if (isFull()) {
        }
        backingArray[(front + size++) % backingArray.length] = data;
    }


    public T dequeue() {
        if(isEmpty()) throw new IllegalArgumentException("Error: The Queue Is Empty");
        T removedData = backingArray[front++];
        size--;
        return removedData;
    }

    public T[] getBackingArray() {
        return backingArray;
    }


    public int size() {
        return size;
    }
}


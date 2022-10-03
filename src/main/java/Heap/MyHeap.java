package Heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Your implementation of a MinHeap.
 */
public class MyHeap<T extends Comparable<? super T>> {

    /**
     * The initial capacity of the MinHeap.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;


    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    private boolean isEmpty(){ return size == 0; }
    private boolean isFull(){ return size == backingArray.length-1; }

    private void heapifyUp(){
        int currentIndex = size;
        int parentIndex = (currentIndex) / 2;
        while(parentIndex >= 1 && backingArray[currentIndex].compareTo(backingArray[parentIndex]) < 0){
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = (currentIndex) / 2;
        }
    }

    private void heapifyDown(int endIndex){
        if(endIndex == 0) return;
        int currentIndex = 1;
        while(currentIndex <= endIndex){
            int leftChildIndex = 2 * currentIndex;
            int rightChildIndex = 2 * currentIndex + 1;
            if(leftChildIndex > endIndex) break;

            int childIndexToSwap = rightChildIndex > endIndex
                    ? leftChildIndex
                    : backingArray[leftChildIndex].compareTo(backingArray[rightChildIndex]) < 0
                    ? leftChildIndex
                    : rightChildIndex;

            if(backingArray[currentIndex].compareTo(backingArray[childIndexToSwap]) < 0) break;
            swap(currentIndex, childIndexToSwap);
            currentIndex = childIndexToSwap;

        }
    }

    private void swap(int firstIndex, int secondIndex){
        T temp = backingArray[firstIndex];
        backingArray[firstIndex] = backingArray[secondIndex];
        backingArray[secondIndex] = temp;
    }

    /**
     * This is the constructor that constructs a new MinHeap.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    public MyHeap() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    private void resize(int newCapacity){
        T[] newArray = (T[]) new Comparable[newCapacity];
        for(int i = 0; i < backingArray.length; i++){
            newArray[i] = backingArray[i];
        }
        backingArray = newArray;
    }

    /**
     * Adds an item to the heap. If the backing array is full (except for
     * index 0) and you're trying to add a new item, then double its capacity.
     *
     * Method should run in amortized O(log n) time.
     *
     * @param data The data to add.
     * @throws java.lang.IllegalArgumentException If the data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(data == null) throw new IllegalArgumentException("Data Is Null");
        if(isEmpty()) backingArray[0] = null;
        if(isFull()) resize(2 * backingArray.length);
        backingArray[++size] = data;
        heapifyUp();
    }

    /**
     * Removes and returns the min item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     *
     * Method should run in O(log n) time.
     *
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the heap is empty.
     */
    public T remove() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(isEmpty()) throw new NoSuchElementException();
        T result = backingArray[1];
        backingArray[1] = backingArray[size--];
        backingArray[size + 1] = null;
        heapifyDown(size);
        return result;
    }

    /**
     * Returns the backing array of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}

package BinarySearch;

public class BinarySearch<T extends Comparable<T>>{
    private T[] dataArray;
    private int size;

    public BinarySearch(int capacity){
        this.size = 0;
        this.dataArray = (T[]) new Comparable[capacity];
    }

    private boolean isEmpty(){ return size == 0; }
    private boolean isFull(){ return size == dataArray.length; }
    private boolean isNull(Object obj){ return obj == null; }
}
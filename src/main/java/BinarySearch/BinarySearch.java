package BinarySearch;

public class BinarySearch<T extends Comparable<T>>{
    T[] array;
    int size;

    public BinarySearch(int capacity){
        this.array = (T[]) new Object[capacity];
        this.size = 0;
    }

    private boolean isEmpty(){ return size == 0; }
    private boolean isFull(){ return size == array.length; }

    public void insertData(T newData){
        if(isFull()) return;
        array[size++] = newData;
    }

    public T searchData(T searchData){
        if(isEmpty()) return null;
        int startIndex = 0;
        int endIndex = array.length - 1;
        return binarySearch(startIndex, endIndex, 0, searchData);
    }

    private T binarySearch(int startIndex, int endIndex, int midIndex, T searchData){
        if(startIndex > endIndex) return null;
        midIndex = Math.floorDiv((startIndex + endIndex), 2);
        if(array[midIndex].equals(searchData)) return array[midIndex];
        if(array[midIndex].compareTo(searchData) > 0) endIndex = midIndex - 1;
        else if(array[midIndex].compareTo(searchData) < 0) startIndex = midIndex + 1;
        return binarySearch(startIndex, endIndex, midIndex, searchData);
    }
}

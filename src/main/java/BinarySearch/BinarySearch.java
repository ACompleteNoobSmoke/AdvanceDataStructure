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

    public void insertData(T newData){
        if(isNull(newData)) throw new IllegalArgumentException("Data Is Null");
        if(isFull()) return;
        dataArray[size++] = newData;
    }

    public T searchData(T searchData){
        if(isNull(searchData)) throw new IllegalArgumentException("Data Is Null");
        if(isEmpty()) return null;
        int startIndex = 0, endIndex = dataArray.length - 1;
        return binarySearch(startIndex, endIndex, searchData);
    }

    private T binarySearch(int startIndex, int endIndex, T searchData){
        printArray(startIndex, endIndex);
        if(startIndex > endIndex) return null;
        int midIndex = Math.floorDiv((startIndex + endIndex), 2);
        if(dataArray[midIndex].equals(searchData)) return dataArray[midIndex];
        if(dataArray[midIndex].compareTo(searchData) > 0) endIndex = midIndex - 1;
        else if(dataArray[midIndex].compareTo(searchData) < 0) startIndex = midIndex + 1;
        return binarySearch(startIndex, endIndex, searchData);
    }

    private void printArray(int startIndex, int endIndex){
        if(isEmpty()) return;
        System.out.print("Current Array Iteration: ");
        for(int i = startIndex; i <= endIndex; i++)
            System.out.print(dataArray[i] + " ");
        System.out.println("]\n");
    }
}
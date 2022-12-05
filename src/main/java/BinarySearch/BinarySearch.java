package BinarySearch;

public class BinarySearch<T extends Comparable<T>>{
    private T[] dataArr;
    private int size;

    public BinarySearch(int capacity){
        this.size = 0;
        this.dataArr = (T[]) new Comparable[capacity];
    }

    private boolean isEmpty(){ return size == 0; }
    private boolean isFull(){ return size == dataArr.length; }
    private boolean isNull(Object obj){ return obj == null; }

    public void insertData(T newData){
        if(isNull(newData)) throw new IllegalArgumentException("Data Is Null");
        if(isFull()) return;
        dataArr[size++] = newData;
    }

    public T searchData(T data){
        if(isNull(data)) throw new IllegalArgumentException("Data Is Null");
        if(isEmpty()) return null;
        int startIndex = 0, endIndex = dataArr.length - 1;
        return binarySearch(startIndex, endIndex, data);
    }

    private T binarySearch(int startIndex, int endIndex, T data){
        printArray(startIndex, endIndex);
        if(startIndex > endIndex) return null;
        int midIndex = Math.floorDiv((startIndex + endIndex), 2);
        if(dataArr[midIndex].equals(data)) return dataArr[midIndex];
        if(dataArr[midIndex].compareTo(data) > 0) endIndex = midIndex - 1;
        else if(dataArr[midIndex].compareTo(data) < 0) startIndex = midIndex + 1;
        return binarySearch(startIndex, endIndex, data);
    }

    private void printArray(int startIndex, int endIndex){
        if(isEmpty()) return;
        System.out.print("Current Array Iteration: [ ");
        for(int i = startIndex; i <= endIndex; i++)
            System.out.print(dataArr[i] + " ");
        System.out.println("]\n");
    }
}
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

    private void printArray(int startIndex, int endIndex){
        if(isEmpty()) return;
        System.out.print("Current Array Iteration: [");
        for(int i = startIndex; i <= endIndex; i++)
            System.out.print(dataArray[i] + " ");
        System.out.println("]\n");
    }
}
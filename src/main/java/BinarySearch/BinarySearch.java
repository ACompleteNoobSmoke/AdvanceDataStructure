package BinarySearch;

public class BinarySearch<T extends Comparable<T>>{
    private T[] table;
    private int size;

    public BinarySearch(int capacity){
        this.size = 0;
        this.table = (T[]) new Comparable[capacity];
    }

    private boolean isEmpty(){ return size == 0; }
    private boolean isFull(){ return size == table.length; }

    public void insertData(T newData){
        if(newData == null) throw new IllegalArgumentException("Data Is Null");
        if(isFull()) return;
        table[size++] = newData;
    }

    public T searchData(T data){
        if(data == null) throw new IllegalArgumentException("Data Is Null");
        if(isEmpty()) return null;
        int startIndex = 0;
        int endIndex = table.length - 1;
        return binarySearch(startIndex, endIndex, data);
    }

    private T binarySearch(int startIndex, int endIndex, T data){
        printTable(startIndex, endIndex);
        if(startIndex > endIndex) return null;
        int midIndex = Math.floorDiv((startIndex + endIndex), 2);
        if(table[midIndex].equals(data)) return table[midIndex];
        if(table[midIndex].compareTo(data) > 0) endIndex = midIndex - 1;
        else if(table[midIndex].compareTo(data) < 0) startIndex = midIndex + 1;
        return binarySearch(startIndex, endIndex, data);
    }

    private void printTable(int startIndex, int endIndex){
        if(isEmpty()) return;
        System.out.print("Current Array: [ ");
        for(int i = startIndex; i <= endIndex; i++)
            System.out.print(table[i] + " ");
        System.out.println("]\n");
    }
}
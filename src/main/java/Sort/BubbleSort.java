package Sort;

import java.util.Arrays;

public class BubbleSort<T extends Comparable<T>> {
    private T[] array;
    private int capacity;
    private int size;

    public BubbleSort(int capacity){
        this.capacity = capacity;
        array = (T[]) new Comparable[capacity];
        size = 0;
    }

    public void insert(T newData){
        if(newData == null) throw new IllegalArgumentException("Data Is Null");
        if(size == array.length) return;
        array[size++] = newData;
    }

    public void sort(){
        if(size == 0) return;
        for(int i = 0; i < array.length-1; i++){
            for(int j = i ; j < array.length; j++){
                if(array[i].compareTo(array[j]) > 0) swap(i, j);
            }
        }
    }

    private void swap(int index1, int index2 ){
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public void printArray(){
        if(size == 0) return;
        Arrays.stream(array).forEach(c -> System.out.print(c + " "));
    }

    public int getCapacity(){ return capacity; }
}

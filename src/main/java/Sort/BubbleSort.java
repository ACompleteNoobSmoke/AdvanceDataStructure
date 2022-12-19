package Sort;

public class BubbleSort<T extends Comparable<T>>{
    private int capacity;
    private int size;
    private T[] dataArray;

    public BubbleSort(int capacity){
        this.size = 0;
        this.capacity = capacity;
        this.dataArray = (T[]) new Comparable[capacity];
    }

    public void insert(T newData){
        if(newData == null) throw new IllegalArgumentException("Data Is Null");
        if(size == capacity) return;
        dataArray[size++] = newData;
    }

    public void sort(){
        if(size == 0) return;
        for(int i = 0; i < size - 1; i++){
            boolean switched = false;
            for(int j = 0; j < size - i - 1; j++){
                if(dataArray[j].compareTo(dataArray[j + 1]) > 0){
                    swap(j, j+1);
                    switched = true;
                }
            }
            if(!switched) break;
        }
    }

    private void swap(int firstIndex, int secondIndex){
        T temp = dataArray[firstIndex];
        dataArray[firstIndex] = dataArray[secondIndex];
        dataArray[secondIndex] = temp;
    }

    public void printArray(){
        if(size == 0) return;
        for(int i = 0; i < size; i++)
            System.out.print(dataArray[i] + " ");
    }

    public int getCapacity(){ return capacity; }

    public int getSize(){ return size; }
}
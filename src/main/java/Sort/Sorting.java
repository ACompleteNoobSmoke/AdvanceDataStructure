package Sort;

public abstract class Sorting<T extends Comparable<T>> implements SortingMethods<T> {
    protected int capacity;
    protected int size;
    protected T[] dataArray;

    public Sorting(int capacity){
        this.size = 0;
        this.capacity = capacity;
        this.dataArray = (T[]) new Comparable[capacity];
    }


    protected boolean isFull(){ return size == capacity; }
    protected boolean isEmpty(){ return size == 0; }
    protected boolean isNull(T data){ return data == null; }

    @Override
    public void insert(T newData){
        if(isNull(newData)) throw new IllegalArgumentException("Data Is Null");
        if(isFull()) return;
        dataArray[size++] = newData;
    }

    @Override
    public void swap(int firstIndex, int secondIndex){
        T temp = dataArray[firstIndex];
        dataArray[firstIndex] = dataArray[secondIndex];
        dataArray[secondIndex] = temp;
    }
}

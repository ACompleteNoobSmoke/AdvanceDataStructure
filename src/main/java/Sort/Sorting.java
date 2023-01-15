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

    protected boolean compareToHigher(T data1, T data2){ return data1.compareTo(data2) > 0; }
    protected boolean compareToLower(T data1, T data2){ return data1.compareTo(data2) < 0; }

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

    protected void printArray(){
        if(isEmpty()) return;
        for(int i = 0; i < size; i++)
            System.out.print(dataArray[i] + " ");
    }

    public int getSize(){ return size; }

    public int getCapacity(){ return capacity; }
}

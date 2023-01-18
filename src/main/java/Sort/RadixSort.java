package Sort;

public class RadixSort<T extends Comparable<T>> extends Sorting<T> {
    public RadixSort(int capacity){
        super(capacity);
    }

    public T getMax(){
        T max = dataArray[0];
        for(T value: dataArray)
            if(value.compareTo(max) > 0)
                max = value;

        return max;
    }

    public T getMin(){
        T max = dataArray[0];
        for(T value: dataArray)
            if(value.compareTo(max) < 0)
                max = value;

        return max;
    }

    @Override
    public void sort(){}
}

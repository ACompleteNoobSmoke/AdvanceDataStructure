package Sort;

public class InsertionSort<T extends Comparable<T>> extends Sorting<T>{
    public InsertionSort(int capacity){ super(capacity); }

    @Override
    public void sort(){
        for(int i = 1; i < dataArray.length; i++)
            for(int j = i; j > 0 && compareToLower(dataArray[j], dataArray[j - 1]); j--)
                swap(j, j - 1);
    }
}
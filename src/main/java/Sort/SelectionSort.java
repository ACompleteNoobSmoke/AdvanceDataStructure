package Sort;

public class SelectionSort<T extends Comparable<T>> extends Sorting<T> {
    public SelectionSort(int capacity){ super(capacity); }

    @Override
    public void sort() {
        int minIndex = 0;
        for(int i = 0; i < dataArray.length - 1; i++){
            minIndex = i;
            for(int j = i + 1; j < dataArray.length; j++){
                if(dataArray[j].compareTo(dataArray[minIndex]) < 0)
                    minIndex = j;
            }
            if(minIndex != i) swap(i, minIndex);
        }
    }
}

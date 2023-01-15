package Sort;

public class SelectionSort<T extends Comparable<T>> extends Sorting<T>{
    public SelectionSort(int capacity){ super(capacity); }

    @Override
    public void sort(){
        for(int i = 0; i < dataArray.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < dataArray.length; j++)
                if(compareToLower(dataArray[j], dataArray[minIndex]))
                    minIndex = j;

            if(i != minIndex) swap(i, minIndex);
        }
    }
}
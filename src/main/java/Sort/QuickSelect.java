package Sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSelect<T extends Comparable<T>> extends QuickSort<T> {
    private T answer;
    private int k;

    public QuickSelect(int capacity) {
        super(capacity);
    }

    public T getAnswer(){ return answer; }
    public int getK(){ return k; }

    @Override
    public void sort(){
        int arrayLength = dataArray.length - 1;
        k = new Random().nextInt(0, arrayLength);
        answer = quickSelect(dataArray, k, 0, arrayLength);
        Arrays.sort(dataArray);
    }

    private T quickSelect(T[] inputArray, int k, int low, int high){
        int partition = getPartition(inputArray, low, high);
        if(partition == k - 1) return inputArray[partition];
        else if(partition < k - 1) low = partition + 1;
        else high = partition - 1;
        return quickSelect(inputArray, k, low, high);
    }

    private int getPartition(T[] inputArray, int low, int high){
        T pivotElement = inputArray[high];
        int pivotIndex = low;

        for(int i = low; i < high; i++)
            if(inputArray[i].compareTo(pivotElement) < 0)
                swap(i, pivotIndex++);

        swap(pivotIndex, high);
        return pivotIndex;
    }
}

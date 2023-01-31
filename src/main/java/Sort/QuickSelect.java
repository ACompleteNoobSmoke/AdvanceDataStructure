package Sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSelect<T extends Comparable<T>> extends QuickSort<T> {
   private T kthElement;
   private int kthIndex;

   public QuickSelect(int capacity){
       super(capacity);
   }

   public T getAnswer(){
       return kthElement;
   }

   public int getK(){
       return kthIndex;
   }

   @Override
    public void sort(){
        int arrayLength = dataArray.length - 1;
        kthIndex = new Random().nextInt(0, arrayLength);
        kthElement = quickSelect(dataArray, kthIndex, 0, arrayLength);
        Arrays.sort(dataArray);
   }

   private T quickSelect(T[] inputArray, int k, int low, int high){
        int partition = getPartition(inputArray, low, high);
        if (partition == k - 1) return inputArray[partition];
        else if (partition < k - 1) low = partition + 1;
        else high = partition - 1;
        return quickSelect(inputArray, k, low, high);
   }

   private int getPartition(T[] inputArray, int low, int high){
        T pivotElement = inputArray[high];
        int pivotIndex = low;

        for(int i = low; i < high; i++){
            if(inputArray[i].compareTo(pivotElement) < 0){
                swap(i, pivotIndex++);
            }
        }

        swap(pivotIndex, high);
        return pivotIndex;
   }
}

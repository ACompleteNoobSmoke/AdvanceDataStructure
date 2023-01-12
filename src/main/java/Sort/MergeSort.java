package Sort;

public class MergeSort<T extends Comparable<T>> extends Sorting<T> {
    public MergeSort(int capacity){ super(capacity); }

    @Override
    public void sort(){
        mergeSort(dataArray);
    }

    private void mergeSort(T[] inputArray){
        int arrLength = inputArray.length;
        if(arrLength < 2) return;

        int midIndex = arrLength / 2;
        T[] leftHalf = (T[]) new Comparable[midIndex];
        T[] rightHalf = (T[]) new Comparable[arrLength - midIndex];

        for(int i = 0; i < midIndex; i++) leftHalf[i] = inputArray[i];
        for(int j = midIndex; j < arrLength; j++) rightHalf[j - midIndex] = inputArray[j];

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(inputArray, leftHalf, rightHalf);
    }

    private void merge(T[] inputArray, T[] leftHalf, T[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int l = 0, r = 0, m = 0;

        while(l < leftSize && r < rightSize){
            if(leftHalf[l].compareTo(rightHalf[r]) <= 0) inputArray[m] = leftHalf[l++];
            else inputArray[m] = rightHalf[r++];
            m++;
        }

        while(l < leftSize) inputArray[m++] = leftHalf[l++];
        while(r < rightSize) inputArray[m++] = rightHalf[r++];
    }
}

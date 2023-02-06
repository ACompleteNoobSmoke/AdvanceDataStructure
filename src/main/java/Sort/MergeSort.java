package Sort;

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> extends Sorting<T> {
    public MergeSort(int capacity){ super(capacity); }

    @Override
    public void sort(){
        mergeSort(dataArray);
    }

    private void mergeSort(T[] inputArray){
        int arrLen = inputArray.length;
        if (arrLen < 2) return;

        int midPoint = arrLen / 2;
        T[] leftHalf = (T[]) new Comparable[midPoint];
        T[] rightHalf = (T[]) new Comparable[arrLen - midPoint];

        for (int i = 0; i < midPoint; i++) leftHalf[i] = inputArray[i];
        for (int j = midPoint; j < arrLen; j++) rightHalf[j - midPoint] = inputArray[j];

        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(inputArray, leftHalf, rightHalf);
    }

    private void merge(T[] inputArray, T[] leftHalf, T[] rightHalf){
        int leftSize = leftHalf.length, rightSize = rightHalf.length;
        int l = 0, r = 0, m = 0;

        while (l < leftSize && r < rightSize){
            if (leftHalf[l].compareTo(rightHalf[r]) <= 0) inputArray[m++] = leftHalf[l++];
            else inputArray[m++] = rightHalf[r++];
        }

        while (l < leftSize) inputArray[m++] = leftHalf[l++];
        while (r < rightSize) inputArray[m++] = rightHalf[r++];
    }

}

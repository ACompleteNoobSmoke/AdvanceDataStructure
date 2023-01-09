package Sort;

public class MergeSort<T extends Comparable<T>> extends Sorting<T> {
    public MergeSort(int capacity){ super(capacity); }

    @Override
    public void sort(){
        mergeSort(dataArray);
    }

    private void mergeSort(T[] inputArray){
        int arrLen = inputArray.length;
        if(arrLen < 2) return;

        int midIndex = arrLen / 2;
        T[] leftHalf = (T[]) new Comparable[midIndex];
        T[] rightHalf = (T[]) new Comparable[arrLen - midIndex];

        for(int i = 0; i < midIndex; i++) leftHalf[i] = inputArray[i];
        for(int j = midIndex; j < arrLen; j++) rightHalf[j - midIndex] = inputArray[j];

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(inputArray, leftHalf, rightHalf);
    }

    private void merge(T[] inputArray, T[] leftHalf, T[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0, k = 0;

        while(i < leftSize && j < rightSize){
            if(leftHalf[i].compareTo(rightHalf[j]) <= 0) inputArray[k] = leftHalf[i++];
            else inputArray[k] = rightHalf[j++];
            k++;
        }

        while(i < leftSize) inputArray[k++] = leftHalf[i++];
        while(j < rightSize) inputArray[k++] = rightHalf[j++];
    }
}

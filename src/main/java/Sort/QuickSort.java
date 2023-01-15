package Sort;

import java.util.Random;

public class QuickSort<T extends Comparable<T>> extends Sorting<T> {
    public QuickSort(int capacity){ super(capacity); }

    @Override
    public void sort(){
        quickSort(dataArray, 0, dataArray.length - 1);
    }

    private void quickSort(T[] inputArray, int lowIndex, int highIndex){
        if(lowIndex >= highIndex) return;
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        T pivot = inputArray[pivotIndex];
        swap(pivotIndex, highIndex);

        int leftPointer = partition(inputArray, lowIndex, highIndex, pivot);

        quickSort(inputArray, lowIndex, leftPointer - 1);
        quickSort(inputArray, leftPointer + 1, highIndex);
    }

    private int partition(T[] inputArray, int lowIndex, int highIndex, T pivot){
        int leftPointer = lowIndex, rightPointer = highIndex;

        while(leftPointer < rightPointer){
            while(inputArray[leftPointer].compareTo(pivot) <= 0 && leftPointer < rightPointer) leftPointer++;
            while(inputArray[rightPointer].compareTo(pivot) >= 0 && leftPointer < rightPointer) rightPointer--;
            swap(leftPointer, rightPointer);
        }

        swap(leftPointer, highIndex);
        return leftPointer;
    }























}

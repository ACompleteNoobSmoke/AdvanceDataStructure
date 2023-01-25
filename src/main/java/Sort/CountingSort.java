package Sort;

import java.util.Arrays;

public class CountingSort{
    int array[];
    int capacity;

    public CountingSort(int capacity, int[] array){
        this.capacity = capacity;
        this.array = array;
    }

    public void sort(){
        countSort(array, capacity);
    }

    private int getCountLength(int min, int max){
        return (max - min) + 1;
    }

    protected int getMin(int[] minArray){
        return Arrays.stream(minArray).min().orElse(0);
    }

    protected int getMax(int[] maxArray){
        return Arrays.stream(maxArray).max().orElse(Integer.MAX_VALUE);
    }

    private void countSort(int[] inputArray){
        int min = getMin(inputArray);
        int max = getMax(inputArray);
        int countLength = getCountLength(min, max);

        int[] countArray = new int[countLength];
        for(int input: inputArray) countArray[input - min]++;

        int arrayIndex = 0;
        for(int i = 0; i < countLength; i++)
            while(countArray[i] > 0){
                inputArray[arrayIndex++] = i + min;
                countArray[i]--;
            }

    }

    private void countSort(int[] inputArray, int length){
        int min = getMin(inputArray);
        int max = getMax(inputArray);
        int countLength = getCountLength(min, max);

        int[] countArray = new int[countLength];
        for(int input: inputArray) countArray[input - min]++;
        for(int i = 1; i < countLength; i++) countArray[i] += countArray[i - 1];

        int[] outputArray = new int[length];
        for(int i = length - 1; i >= 0; i--){
            int currentValue = inputArray[i];
            int countArrayIndex = currentValue - min;
            int positionInArray = countArray[countArrayIndex] - 1;
            outputArray[positionInArray] = currentValue;
            countArray[countArrayIndex]--;
        }

        System.arraycopy(outputArray, 0, inputArray, 0, length);
    }
}

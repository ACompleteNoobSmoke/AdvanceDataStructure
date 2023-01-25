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

    private void countSort(int[] inputArray){
        int min = Arrays.stream(inputArray).min().orElse(0);
        int max = Arrays.stream(inputArray).max().orElse(Integer.MAX_VALUE);
        int countLen = getCountLength(min, max);

        int[] countArray = new int[countLen];
        for(int input: inputArray) countArray[input - min]++;

        int arrayIndex = 0;
        for(int i = 0; i < countLen; i++)
            while(countArray[i] > 0){
                inputArray[arrayIndex++] = i + min;
                countArray[i]--;
            }
    }

    private void countSort(int[] inputArray, int length){
        int min = Arrays.stream(inputArray).min().orElse(0);
        int max = Arrays.stream(inputArray).max().orElse(Integer.MAX_VALUE);
        int countLen = getCountLength(min, max);

        int[] countArray = new int[countLen];
        for(int input: inputArray) countArray[input - min]++;
        for(int i = 1; i < countLen; i++) countArray[i] += countArray[i - 1];

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

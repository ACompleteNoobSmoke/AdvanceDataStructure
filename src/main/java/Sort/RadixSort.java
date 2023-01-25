package Sort;

import java.util.Arrays;

public class RadixSort extends CountingSort{

    public RadixSort(int capacity, int[] array){
        super(capacity, array);
    }

    @Override
    public void sort(){
        int max = Arrays.stream(array).max().orElse(Integer.MAX_VALUE);
        for(int exp = 1; max / exp > 0; exp *= 10) countSort(exp);
    }

    private void countSort(int exp){
        int len = 10;
        int[] countArray = new int[len];

        for(int value: array) countArray[(value / exp) % len]++;
        for(int i = 1; i < len; i++) countArray[i] += countArray[i - 1];

        int arrayLength = array.length;
        int[] outputArray = new int[arrayLength];
        for(int i = arrayLength - 1; i >= 0; i--){
            int currentValue = array[i];
            int countArrayIndex = (currentValue / exp) % len;
            int positionInArray = countArray[countArrayIndex] - 1;
            outputArray[positionInArray] = currentValue;
            countArray[countArrayIndex]--;
        }

        System.arraycopy(outputArray, 0, array, 0, arrayLength);
    }
}


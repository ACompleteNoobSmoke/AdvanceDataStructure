package Sort;

import java.util.Arrays;

public class RadixSort extends CountingSort{

    public RadixSort(int capacity, int[] array){
        super(capacity, array);
    }

    @Override
    public void sort(){
        int max = getMax(array);
        for(int exp = 1; max / exp > 0; exp *= 10) countSort(exp);
    }

    private void countSort(int exp){
        int fixedLen = 10;
        int[] countArray = new int[fixedLen];

        for(int value: array) countArray[(value / exp) % fixedLen]++;
        for(int i = 1; i < fixedLen; i++) countArray[i] += countArray[i - 1];

        int arrLen = array.length;
        int[] outputArray = new int[arrLen];
        for(int i = arrLen - 1; i >= 0; i--){
            int currentValue = array[i];
            int countArrayIndex = (currentValue / exp) % fixedLen;
            int positionInArray = countArray[countArrayIndex] - 1;
            outputArray[positionInArray] = currentValue;
            countArray[countArrayIndex]--;
        }

        System.arraycopy(outputArray, 0, array, 0, arrLen);
    }
}


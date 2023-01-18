package Sort;

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

    private int getMin(int[] inputArray, int length){
        int min = 0;
        for(int i = 0; i < length; i++)
            if(inputArray[i] < min)  min = inputArray[i];
        return min;
    }

    private int getMax(int[] inputArray, int length){
        int max = 0;
        for(int i = 0; i < length; i++)
            if(inputArray[i] > max) max = inputArray[i];
        return max;
    }

    private void countSort(int[] inputArray, int length){
        int min = getMin(inputArray, length);
        int max = getMax(inputArray, length);

        int[] countArray = new int[max - min + 1];
        for(int value: inputArray) countArray[value - min]++;

        int arrayIndex = 0;
        for(int i = 0; i < max - min + 1; i++)
            while(countArray[i] > 0){
                inputArray[arrayIndex] = i + min;
                countArray[i]--;
                arrayIndex++;
            }
    }


}

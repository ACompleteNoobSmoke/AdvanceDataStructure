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
        //countSort2(array, capacity);
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
        int countLength = max - min + 1;

        int[] countArray = new int[countLength];
        for(int input: inputArray) countArray[input - min]++;

        int arrayIndex = 0;
        for(int i = 0; i < countLength; i++){
            while(countArray[i] > 0){
                inputArray[arrayIndex++] = i + min;
                countArray[i]--;
            }
        }
    }

    private void countSort2(int[] inputArray, int length){
        int min = getMin(inputArray, length);
        int max = getMax(inputArray, length);
        int countLength = max - min + 1;

        int[] countArray = new int[countLength];
        for(int input: inputArray) countArray[input - min]++;
        for(int i = 1; i < countLength; i++) countArray[i] += countArray[i - 1];

        int[] outputArray = new int[length];
        for(int i = length - 1; i >= 0; i--){
            int current = inputArray[i];
            int countArrayIndex = current - min;
            int positionInArray = countArray[countArrayIndex] - 1;
            outputArray[positionInArray] = current;
            countArray[countArrayIndex]--;
        }

        for(int i = 0; i < length; i++) inputArray[i] = outputArray[i];
    }
}

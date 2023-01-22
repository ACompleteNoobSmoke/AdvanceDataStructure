package Sort;

public class CountingSort{
    int array[];
    int capacity;

    public CountingSort(int capacity, int[] array){
        this.capacity = capacity;
        this.array = array;
    }

    public void sort(){
        //countSort(array, capacity);
        countSort2(array, capacity);
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
        for(int value: inputArray) countArray[value - min]++;

        int arrayIndex = 0;
        for(int i = 0; i < countLength; i++){
            while(countArray[i] > 0){
                inputArray[arrayIndex++] = i + min;
                countArray[i]--;
            }
        }
    }

    private void countSort2(int[] inputArr, int length){
       int min = getMin(inputArr, length);
       int max = getMax(inputArr, length);
       int[] countArray = new int[max - min + 1];

       for(int input: inputArr) countArray[input - min]++;
       for(int i = 1; i < countArray.length; i++) countArray[i] += countArray[i - 1];

       int[] outputArr = new int[length];

       for(int i = length - 1; i >= 0; i--){
           int current = inputArr[i];
           int positionInArray = countArray[current - min] - 1;
           outputArr[positionInArray] = current;
           countArray[current - min]--;
       }

       for(int i = 0; i < length; i++) inputArr[i] = outputArr[i];
    }
}

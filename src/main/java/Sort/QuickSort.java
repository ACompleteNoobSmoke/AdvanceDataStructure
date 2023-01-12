package Sort;

public class QuickSort<T extends Comparable<T>> extends Sorting<T> {
    public QuickSort(int capacity){ super(capacity); }

    @Override
    public void sort(){
        quickSort(dataArray, 0, dataArray.length - 1);
    }

    private void quickSort(T[] inputArray, int lowIndex, int highIndex){
        if(lowIndex >= highIndex) return;
        T pivot = inputArray[highIndex];

        int leftPoint = lowIndex;
        int rightPoint = highIndex;

        while(leftPoint < rightPoint){
            while(inputArray[leftPoint].compareTo(pivot) <= 0 && leftPoint < rightPoint) leftPoint++;
            while(inputArray[rightPoint].compareTo(pivot) >= 0 && leftPoint < rightPoint) rightPoint--;
            swap(leftPoint, rightPoint);
        }
        swap(leftPoint, highIndex);
        quickSort(inputArray, lowIndex, leftPoint - 1);
        quickSort(inputArray, leftPoint + 1, highIndex);
    }
}
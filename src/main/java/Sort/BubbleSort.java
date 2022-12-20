package Sort;

public class BubbleSort<T extends Comparable<T>> extends Sorting<T>{

    public BubbleSort(int capacity) {
        super(capacity);
    }

    @Override
    public void sort() {
        for(int i = 0; i < dataArray.length - 1; i++){
            boolean isSwapped = false;
            for(int j = 0; j < dataArray.length - i - 1; j++){
                if(dataArray[j].compareTo(dataArray[j + 1]) > 0){
                    swap(j, j+1);
                    isSwapped = true;
                }
            }
            if(!isSwapped) break;
        }
    }

    public int getSize(){ return size; }

    public int getCapacity(){ return capacity; }
}
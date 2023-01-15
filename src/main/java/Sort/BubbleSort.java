package Sort;

public class BubbleSort<T extends Comparable<T>> extends Sorting<T>{
    public BubbleSort(int  capacity){ super(capacity); }

//    @Override
//    public void sort(){
//        for(int i = 0; i < dataArray.length - 1; i++) {
//            boolean isSwapped = false;
//            for(int j = 0; j < dataArray.length - i - 1; j++){
//                if(compareToHigher(dataArray[j],dataArray[j + 1])){
//                    swap(j, j + 1);
//                    isSwapped = true;
//                }
//            }
//            if(!isSwapped) break;
//        }
//    }

    @Override
    public void sort(){
        int stopIndex = dataArray.length - 1;
        while(stopIndex > 0){
            int i = 0;
            int swappedIndex = 0;
            while(i < stopIndex){
                if(compareToHigher(dataArray[i], dataArray[i + 1])){
                    swap(i, i + 1);
                    swappedIndex = i;
                }
                i++;
            }
            stopIndex = swappedIndex;
        }
    }
}
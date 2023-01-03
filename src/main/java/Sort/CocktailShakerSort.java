package Sort;

public class CocktailShakerSort<T extends Comparable<T>> extends Sorting<T>{
    public CocktailShakerSort(int capacity){ super(capacity); }

    private boolean compareTo(T data1, T data2){
        return data1.compareTo(data2) > 0;
    }

    @Override
    public void sort(){
        boolean isSwapped = true;
        while(isSwapped){
            isSwapped = false;
            for(int i = 0; i < dataArray.length - 1; i++){
                if(compareTo(dataArray[i], dataArray[i + 1])){
                    swap(i, i + 1);
                    isSwapped = true;
                }
            }
            if(!isSwapped) break;
            isSwapped = false;
            for(int j = dataArray.length - 2; j >= 0; j--){
                if(compareTo(dataArray[j],dataArray[j + 1])){
                    swap(j, j + 1);
                    isSwapped = true;
                }
            }
        }
    }
}
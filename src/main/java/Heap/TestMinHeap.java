package Heap;

public class TestMinHeap<T extends Comparable<T>> extends PracticeHeap<T>{
    @Override
    protected void heapifyUp(){
        int currentIndex = position;
        int parentIndex = (currentIndex - 1) / 2;
        while(parentIndex >= 0 && heap[currentIndex].compareTo(heap[parentIndex]) < 0){
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = (currentIndex -1) / 2;
        }
    }

    @Override
    protected void heapifyDown(int endIndex){
        if(endIndex == -1) return;
        int index = 0;
        while(index <= endIndex){
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            if(leftChildIndex > endIndex) break;

            int childIndexToSwap = rightChildIndex > endIndex
                                    ? leftChildIndex
                                    : heap[leftChildIndex].compareTo(heap[rightChildIndex]) < 0
                                        ? leftChildIndex
                                        : rightChildIndex;

            if(heap[index].compareTo(heap[childIndexToSwap]) < 0) break;
            swap(index, childIndexToSwap);
            index = childIndexToSwap;
        }
    }
}

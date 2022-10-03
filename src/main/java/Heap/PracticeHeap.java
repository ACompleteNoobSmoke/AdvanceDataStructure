package Heap;

import java.util.Arrays;

public abstract class PracticeHeap<T extends Comparable<T>> implements THeap<T>{

    protected T[] heap;
    protected int position = -1;

    protected abstract void heapifyUp();
    protected abstract void heapifyDown(int endIndex);

    public PracticeHeap() { heap = (T[]) new Comparable[2]; }

    private boolean isEmpty(){ return heap.length == 0; }
    private boolean isFull(){ return position == heap.length - 1; }
    private void resize(int capacity){
        System.arraycopy(heap, 0, heap = (T[]) new Comparable[capacity], 0, position + 1);
    }

    @Override
    public THeap<T> insert(T data){
        if(isFull()) resize(2 * heap.length);
        heap[++position] = data;
        heapifyUp();
        return this;
    }

    @Override
    public T extractRoot(){
        if(isEmpty()) return null;
        T result = heap[0];
        heap[0] = heap[position--];
        heap[position + 1] = null;
        heapifyDown(position);
        return result;
    }

    @Override
    public void swap(int firstIndex, int secondIndex){
        T temp = heap[firstIndex];
        heap[firstIndex] = heap[secondIndex];
        heap[secondIndex] = temp;
    }

    @Override
    public void sort(){
        if(isEmpty()) return;
        for(int i = 0; i <= position; i++){
            swap(0, position);
            heapifyDown(position - i - 1);
        }
        Arrays.stream(heap).forEach(System.out::println);
    }
}





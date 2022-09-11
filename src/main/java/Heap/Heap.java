package Heap;

public abstract class Heap<T extends Comparable<T>> implements IHeap<T> {
    protected T[] heap;
    protected int position = -1;

    public Heap(){
        heap = (T[]) new Comparable[2];
    }

    private boolean isFull(){
        return position == heap.length - 1;
    }

    private boolean isEmpty(){
        return heap.length == 0;
    }

    private void resize(int capacity){
        System.arraycopy(heap, 0, heap = (T[]) new Comparable[capacity], 0, position + 1);
    }

    protected abstract void fixUpward();
    protected abstract void fixDownward(int index);

    @Override
    public IHeap<T> insert(T data){
        if(isFull())
            resize(2 * heap.length);
        heap[++position] = data;
        fixUpward();
        return this;
    }

    protected void swap(int firstIndex, int secondIndex){
        T temp = heap[firstIndex];
        heap[firstIndex] = heap[secondIndex];
        heap[secondIndex] = temp;
    }

    @Override
    public T getRoot(){
        if(isEmpty()) return null;
        T result = heap[0];
        heap[0] = heap[position--];
        heap[position + 1] = null;
        fixDownward(position);
        return result;
    }

}

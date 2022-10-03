package Heap;

public interface THeap<T extends Comparable<T>>{
    THeap<T> insert(T data);
    T extractRoot();
    void swap(int firstIndex, int secondIndex);
    void sort();
}
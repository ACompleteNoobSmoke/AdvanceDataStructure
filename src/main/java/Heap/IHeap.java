package Heap;

public interface IHeap<T extends Comparable<T>>{
    IHeap<T> insert(T data);
    T extractRoot();
    void sort();
}

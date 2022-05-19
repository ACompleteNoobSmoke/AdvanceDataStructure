package Queue;

import BinaryTree.Person;

public interface QueueMethods<T> {
    boolean isEmpty();
    boolean isFull();
    boolean enqueue(T data);
    T dequeue();
    T peek();
    void printAll();
    int getLimit();
    int getSize();

}

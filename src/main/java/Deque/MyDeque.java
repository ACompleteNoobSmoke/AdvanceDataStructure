package Deque;

public class MyDeque<T>{
    private int front;
    private int rear;
    private T[] deque;
    private int capacity;
    private int currentSize;

    private boolean isEmpty(){
        return front == -1 && rear == -1;
    }

    private boolean isFull(){
        return (front == 0 && rear == capacity - 1) || (front == rear + 1);
    }

    private boolean isFrontRearSameIndex(){
        return front == rear;
    }

    public MyDeque(int capacity){
        currentSize = 0;
        front = rear = -1;
        this.capacity = capacity;
        deque = (T[]) new Object[capacity];
    }

    public void insertFront(T newItem){
        if(isFull()) return;
        if(isEmpty()) front = rear = 0;
        else if(front == 0) front = capacity - 1;
        else front--;
        deque[front] = newItem;
        currentSize++;
    }

    public void insertRear(T newItem){
        if(isFull()) return;
        if(isEmpty()) front = rear = 0;
        else if(rear == capacity - 1) rear = 0;
        else rear++;
        deque[rear] = newItem;
        currentSize++;
    }

    public T removeFront(){
        if(isEmpty()) return null;
        T removeItem = deque[front];
        deque[front] = null;
        if(isFrontRearSameIndex()) front = rear = 0;
        else if(front == capacity - 1) front = 0;
        else front++;
        currentSize--;
        return removeItem;
    }

    public T removeRear(){
        if(isEmpty()) return null;
        T removeItem = deque[rear];
        deque[rear] = null;
        if(isFrontRearSameIndex()) front = rear = 0;
        else if(rear == 0) rear = capacity - 1;
        else rear--;
        currentSize--;
        return removeItem;
    }

    public T viewFront(){
        if(isEmpty()) return null;
        return deque[front];
    }

    public T viewRear(){
        if(isEmpty()) return null;
        return deque[rear];
    }

    public void viewAll(){
        if(isEmpty()) return;
        int index = front;
        while(index != rear){
            System.out.println(deque[index]);
            index = (index +1) % capacity;
        }
        System.out.println(deque[rear]);
    }
}
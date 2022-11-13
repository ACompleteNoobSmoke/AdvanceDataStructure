package Deque;

public class PracticeDeque<T>{
    private int front;
    private int rear;
    private int size;
    private int capacity;
    private T[] deque;

    public PracticeDeque(int capacity){
        size = 0;
        front = rear = -1;
        this.capacity = capacity;
        deque = (T[]) new Object[capacity];
    }

    private boolean isEmpty(){ return (front == -1 && rear == -1) && (size == 0); }

    private boolean isFull(){ return (front == 0 && rear == capacity - 1) || (front == rear + 1); }

    private boolean isFrontRearSameIndex(){ return front == rear; }

    private void setFrontRearIndex(int index){ front = rear = index; }

    private boolean isNull(Object obj) { return obj == null; }

    public boolean insertFront(T newData){
        if(isNull(newData)) throw new IllegalArgumentException("Data Is Empty!");
        if(isFull()) return false;
        if(isEmpty()) setFrontRearIndex(0);
        else if(front == 0) front = capacity - 1;
        else front--;
        deque[front] = newData;
        size++;
        return true;
    }

    public boolean insertRear(T newData){
        if(isNull(newData)) throw new IllegalArgumentException("Data Is Empty!");
        if(isFull()) return false;
        if(isEmpty()) setFrontRearIndex(0);
        else if(rear == capacity - 1) rear = 0;
        else rear++;
        deque[rear] = newData;
        size++;
        return true;
    }

    public T removeFront(){
        if(isEmpty()) return null;
        T frontData = deque[front];
        deque[front] = null;
        if(isFrontRearSameIndex()) setFrontRearIndex(-1);
        else if(front == capacity - 1) front = 0;
        else front++;
        size--;
        return frontData;
    }

    public T removeRear(){
        if(isEmpty()) return null;
        T rearData = deque[rear];
        deque[rear] = null;
        if(isFrontRearSameIndex()) setFrontRearIndex(-1);
        else if(rear == 0) rear = capacity - 1;
        else rear--;
        size--;
        return rearData;
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
        int frontIndex = front;
        while(frontIndex != rear){
            System.out.println(deque[frontIndex]);
            frontIndex = (frontIndex + 1) % capacity;
        }
        System.out.println(deque[rear]);
    }

    public int getSize(){ return size; }
}
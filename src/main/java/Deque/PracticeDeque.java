package Deque;

public class PracticeDeque<T>{
    private int front;
    private int rear;
    private int capacity;
    private int size;
    private T[] deque;

    public PracticeDeque(int capacity){
        size = 0;
        front = rear = -1;
        this.capacity = capacity;
        this.deque = (T[]) new Object[capacity];
    }

    private boolean isEmpty(){ return front == -1 && rear == -1; }
    private boolean isFull(){ return front == 0 && rear == capacity - 1 || front == rear + 1; }
    private boolean isNull(Object obj){ return obj == null; }
    private boolean isFrontRearSameIndex(){ return front == rear; }
    private void setFrontRearIndex(int index){ front = rear = index; }

    public boolean insertFront(T newData){
        if(isNull(newData)) throw new IllegalArgumentException("Data Is Null");
        if(isFull()) return false;
        if(isEmpty()) setFrontRearIndex(0);
        else if(front == 0) front = capacity - 1;
        else front--;
        deque[front] = newData;
        size++;
        return true;
    }

    public boolean insertRear(T newData){
        if(isNull(newData)) throw new IllegalArgumentException("Data Is Null");
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
        T removedFrontData = deque[front];
        deque[front] = null;
        if(isFrontRearSameIndex()) setFrontRearIndex(-1);
        else if(front == capacity - 1) front = 0;
        else front++;
        size--;
        return removedFrontData;
    }

    public T removeRear(){
        if(isEmpty()) return null;
        T removedRearData = deque[rear];
        deque[rear] = null;
        if(isFrontRearSameIndex()) setFrontRearIndex(-1);
        else if(rear == 0) rear = capacity - 1;
        else rear--;
        size--;
        return removedRearData;
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
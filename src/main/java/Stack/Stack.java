package Stack;

public class Stack{
    private int capacity;
    private int currentSize;
    private Books[] bookStack;

    public Stack(int capacity){
        this.capacity = capacity;
        this.currentSize = 0;
        this.bookStack = new Books[capacity];
    }

    private boolean isEmpty(){ return currentSize == 0; }
    private boolean isFull(){ return currentSize == capacity; }

    public boolean push(Books newBook){
        if(isFull()) return false;
        bookStack[currentSize++] = newBook;
        return true;
    }

    public Books pop(){
        if(isEmpty()) return null;
        Books removeBook = bookStack[--currentSize];
        bookStack[currentSize] = null;
        return removeBook;
    }

    public Books peek(){
        if(isEmpty()) return null;
        return bookStack[currentSize - 1];
    }

    public int getCapacity(){ return capacity; }

    public int getCurrentSize(){ return currentSize; }

    public void viewAll(){
        if(isEmpty()) return;
        for(int i = currentSize-1; i >= 0; i--){
            System.out.println(bookStack[i]);
        }
    }


}
package Queue;

public class Queue{
    private int capacity;
    private int currentSize;
    private Song[] songsQ;

    public Queue(int capacity){
        this.capacity = capacity;
        this.currentSize = 0;
        this.songsQ = new Song[capacity];
    }

    private boolean isEmpty(){
        return currentSize == 0;
    }

    private boolean isFull(){
        return currentSize == capacity;
    }

    private void resizeArray(){
        if(isEmpty()) return;
        if(currentSize == 1){ songsQ[0] = null; return;}
        for(int i = 0; i < currentSize; i++)
            songsQ[i] = songsQ[i + 1];
    }

    public boolean enqueue(Song newSong){
        if(isFull()) return false;
        songsQ[currentSize++] = newSong;
        return true;
    }

    public Song dequeue(){
        if(isEmpty()) return null;
        Song removeSong = songsQ[0];
        resizeArray();
        currentSize--;
        return removeSong;
    }

    public Song peek(){
        if(isEmpty()) return null;
        return songsQ[0];
    }

    public void viewAll(){
        if(isEmpty()) return;
        for(int i = 0; i < currentSize; i++)
            System.out.println(songsQ[i]);
    }

    public int getCapacity(){ return capacity; }

    public int getCurrentSize(){ return currentSize; }

}
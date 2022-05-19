package Queue;

import BinaryTree.Person;

public class Queue implements QueueMethods<Person> {

    private int limit;
    private int size;
    private Person[] queue;

    public Queue(int limit){
        this.size = 0;
        this.limit = limit;
        queue = new Person[limit];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == limit;
    }

    @Override
    public boolean enqueue(Person data) {
        if(isFull()) return false;
        queue[size++] = data;
        return true;
    }

    @Override
    public Person dequeue() {
        if(isEmpty()) return null;
        Person newPerson = queue[0];
        if(size == 1) queue = new Person[limit];
        else queue = shuffleArray(0, new Person[limit]);
        size--;
        return newPerson;
    }

    private Person[] shuffleArray(int index, Person[] newQueue){
        while(index != size){
            newQueue[index] = queue[index + 1];
            shuffleArray(++index, newQueue);
        }
        return newQueue;
    }

    @Override
    public Person peek() {
        if(isEmpty()) return null;
        return queue[0];
    }

    @Override
    public void printAll() {
        System.out.println("*** Print All ***");
        if(isEmpty()) System.out.println("Queue Is Currently Empty");
        for(int i = 0; i < size; i++)
            System.out.println(queue[i]);
    }

    @Override
    public int getLimit() {
        return limit;
    }

    @Override
    public int getSize() {
        return size;
    }
}

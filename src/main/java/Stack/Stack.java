package Stack;

import BinaryTree.Person;

public class Stack implements StackMethods{

    private int size;
    private int limit;
    private Person[] stackOfPeople;

    public Stack(int limit){
        this.size = 0;
        this.limit = limit;
        stackOfPeople = new Person[limit];
    }


    @Override
    public boolean push(Person newPerson) {
        if(isFull()) return false;
        stackOfPeople[size++] = newPerson;
        return true;
    }

    @Override
    public Person pop() {
        if(isEmpty()) return null;
        Person removePerson = stackOfPeople[--size];
        return removePerson;
    }

    @Override
    public Person peek() {
        if(isEmpty()) return null;
        return stackOfPeople[size-1];
    }

    public void printAll(){
        System.out.println("*** Print All ***");
        if(isEmpty()) System.out.println("Stack Is Currently Empty");
        for(int i = size-1; i >=0; i--){
            System.out.println(stackOfPeople[i]);
        }
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
    public int getSize(){
        return size;
    }

    @Override
    public int getLimit(){
        return limit;
    }
}

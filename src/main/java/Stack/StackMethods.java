package Stack;

import BinaryTree.Person;

public interface StackMethods {
    boolean push(Person newPerson);
    Person pop();
    Person peek();
    boolean isEmpty();
    boolean isFull();
    int getSize();
    int getLimit();
    void printAll();
}

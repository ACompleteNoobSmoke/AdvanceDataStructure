package BinaryTree;

public interface BinaryTreeFunctions {
    boolean isEmpty();
    Person getMin();
    Person getMax();
    void addNode(Person newPerson);
    Person searchNode(int id);
    void deleteNode(int id);
}

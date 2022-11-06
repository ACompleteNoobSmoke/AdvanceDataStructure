package BinarySearchTree;

public class Node<T extends Comparable<T>> {
    private Node<T> leftSide;
    private Node<T> rightSide;
    private T data;

    public Node(T data){ this.data = data; }

    public Node<T> getLeftSide() {
        return leftSide;
    }

    public void setLeftSide(Node<T> leftSide) {
        this.leftSide = leftSide;
    }

    public Node<T> getRightSide() {
        return rightSide;
    }

    public void setRightSide(Node<T> rightSide) {
        this.rightSide = rightSide;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

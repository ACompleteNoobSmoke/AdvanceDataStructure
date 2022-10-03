package BinaryTree;

public class Node {
    private Node leftSide;
    private Node rightSide;
    private Person data;

    public Node(Person data){
        this.data = data;
    }

    public void setLeftSide(Node leftSide){
        this.leftSide = leftSide;
    }

    public Node getLeftSide(){
        return leftSide;
    }

    public void setRightSide(Node rightSide){
        this.rightSide = rightSide;
    }

    public Node getRightSide(){
        return rightSide;
    }

    public void setData(Person data){
        this.data = data;
    }

    public Person getData(){
        return data;
    }
}

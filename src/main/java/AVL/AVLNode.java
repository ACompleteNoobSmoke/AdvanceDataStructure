package AVL;

public class AVLNode<T extends Comparable<T>> {

    private T data;
    private int height = -1;
    private AVLNode<T> leftSide;
    private AVLNode<T> rightSide;

    public AVLNode(T data){ this.data = data; }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public AVLNode<T> getLeftSide() {
        return leftSide;
    }

    public void setLeftSide(AVLNode<T> leftSide) {
        this.leftSide = leftSide;
    }

    public AVLNode<T> getRightSide() {
        return rightSide;
    }

    public void setRightSide(AVLNode<T> rightSide) {
        this.rightSide = rightSide;
    }

    @Override
    public String toString(){
        return "Current: " + data + "\n" +
                "Left Side: " + leftSide + "\n" +
                "Right Side: " + rightSide + "\n";
    }
}

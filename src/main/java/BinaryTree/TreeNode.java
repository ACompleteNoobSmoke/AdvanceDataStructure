package BinaryTree;

public class TreeNode {

    public TreeNode leftSide;
    public TreeNode rightSide;
    public Person data;

    public TreeNode(Person data){
        this.data = data;
    }

    public String toString(){
        return data.toString();
    }
}

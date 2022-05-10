package BinaryTree;

public class TreeNode {

    public TreeNode left;
    public TreeNode right;
    public int id;
    public String name;

    public TreeNode(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String toString(){
        return "ID: " + id + "\n" +
                "Name: " + name + "\n";
    }
}

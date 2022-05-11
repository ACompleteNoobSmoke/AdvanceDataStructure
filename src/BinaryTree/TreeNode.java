package BinaryTree;

public class TreeNode {

    public TreeNode left;
    public TreeNode right;
    public int id;
    public String name;
    public String occupation;

    public TreeNode(int id, String name, String occupation){
        this.id = id;
        this.name = name;
        this.occupation = occupation;
    }

    public String toString(){
        return "ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Occupation: " + occupation + "\n";
    }
}

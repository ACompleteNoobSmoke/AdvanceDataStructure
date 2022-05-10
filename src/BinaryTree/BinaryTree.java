package BinaryTree;

public class BinaryTree {

    private TreeNode root;

    public void addNode(int id, String name){
        TreeNode newNode = new TreeNode(id, name); //New Node

        if(root == null){
            root = newNode; //If root is empty then assign new node to root
        }else{
            TreeNode focusNode = root; //Focus node to focus on specific points of the tree
            TreeNode parent;
            while(true){
                parent = focusNode;
                if(id < focusNode.id){
                    focusNode = focusNode.left; //If id is less than the root id check the left side of the tree
                    if(focusNode == null){
                        parent.left = newNode;
                        return;
                    }
                }else{
                    focusNode = focusNode.right;
                    if(focusNode == null){
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

}

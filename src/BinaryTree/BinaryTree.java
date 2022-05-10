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

    public void inOrderTraverseTree(TreeNode focusNode){
        if(focusNode != null){
            inOrderTraverseTree(focusNode.left);
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.right);
        }
    }

    public void preOrderTraverseTree(TreeNode focusNode){
        if(focusNode != null){
            System.out.println(focusNode);
            preOrderTraverseTree(focusNode.left);
            preOrderTraverseTree(focusNode.right);
        }
    }

    public void postOrderTraverseTree(TreeNode focusNode){
        if(focusNode != null){
            postOrderTraverseTree(focusNode.left);
            postOrderTraverseTree(focusNode.right);
            System.out.println(focusNode);
        }
    }

    public TreeNode searchTree(int id){
        TreeNode searchNode = root;
        while(searchNode.id != id){
            if(id < searchNode.id){
                searchNode = searchNode.left;
            }else{
                searchNode = searchNode.right;
            }

            if(searchNode == null) return null;
        }
        return searchNode;
    }

    public static void main(String[] args){
        BinaryTree newTree = new BinaryTree();
        newTree.addNode(50, "Osaretin");
        newTree.addNode(10, "Victoria");
        newTree.addNode(75, "Ade");
        newTree.addNode(100, "Boye");
        newTree.addNode(7, "Sammy");

        newTree.postOrderTraverseTree(newTree.root);

        System.out.println("Searching For Victoria");
        System.out.println(newTree.searchTree(10));
    }

}

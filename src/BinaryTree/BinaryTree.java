package BinaryTree;

import com.sun.source.tree.Tree;

public class BinaryTree implements BinaryTreeFunctions {

    private TreeNode root;


    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public TreeNode getMin() {
        if(isEmpty()) return null;
        return getMin(root);
    }

    private TreeNode getMin(TreeNode focusNode){
        if(focusNode.left != null)
            getMin(focusNode.left);
        return focusNode;
    }

    @Override
    public TreeNode getMax() {
        if(isEmpty()) return null;
        return getMax(root);
    }

    private TreeNode getMax(TreeNode focusNode){
        if(focusNode.right != null)
            getMax(focusNode.right);
        return focusNode;
    }

    @Override
    public void addNode(int id, String name, String occupation) {
        if(isEmpty()) root = new TreeNode(id, name, occupation);
        else insertNode(id, name, occupation, root);
    }

    private void insertNode(int id, String name, String occupation, TreeNode focusNode){
        if(id < focusNode.id){
            if(focusNode.left == null){
                TreeNode newNode = new TreeNode(id, name, occupation);
                focusNode.left = newNode;
            }else{
                insertNode(id, name, occupation, focusNode.left);
            }
        }else if(id > focusNode.id){
            if(focusNode.right == null){
                TreeNode newNode = new TreeNode(id, name, occupation);
                focusNode.right = newNode;
            }else{
                insertNode(id, name, occupation, focusNode.right);
            }
        }
    }

    @Override
    public TreeNode searchNode(int id) {
        if(isEmpty()) return null;
        TreeNode searchNode = root;
        while(id != searchNode.id){
            if(id < searchNode.id){
                searchNode = searchNode.left;
            }else if(id > searchNode.id){
                searchNode = searchNode.right;
            }
            if(searchNode == null) return null;
        }
        return searchNode;
    }

    @Override
    public void deleteNode(int id) {
        root = removeNode(id, root);
    }

    private TreeNode removeNode(int id, TreeNode focusNode){
        if(focusNode == null) return null;
        if(id < focusNode.id){
            focusNode.left = removeNode(id, focusNode.left);
        }else if(id > focusNode.id){
            focusNode.right = removeNode(id, focusNode.right);
        }else{
            if(focusNode.left == null){
                return focusNode.right;
            }else if(focusNode.right == null){
                return focusNode.left;
            }

            focusNode = getMax(focusNode.left);
            focusNode.left = removeNode(focusNode.id, focusNode.left);
        }
        return focusNode;
    }

    @Override
    public void postOrderTraversal(TreeNode focusNode) {
        if(focusNode != null){
            inOrderTraversal(focusNode.left);
            inOrderTraversal(focusNode.right);
            System.out.println(focusNode);
        }
    }

    @Override
    public void preOrderTraversal(TreeNode focusNode) {
        if(focusNode != null){
            System.out.println(focusNode);
            inOrderTraversal(focusNode.left);
            inOrderTraversal(focusNode.right);
        }
    }

    @Override
    public void inOrderTraversal(TreeNode focusNode) {
        if(focusNode != null){
            inOrderTraversal(focusNode.left);
            System.out.println(focusNode);
            inOrderTraversal(focusNode.right);
        }
    }

    public static void main(String[] args){
        BinaryTree test = new BinaryTree();
        test.addNode(50, "Victoria", "Freelancer");
        test.addNode(10, "Osaretin", "Sailor");
        test.addNode(100, "Boye", "Programmer");
        test.addNode(85, "Ade", "Programmer");
        test.addNode(20, "Sammy", "Student");
        test.addNode(35, "Armando", "Gamer Designer");

        test.removeNode(50, test.root);
        test.inOrderTraversal(test.root);
        //test.preOrderTraversal(test.root);
        //test.postOrderTraversal(test.root);
    }
}
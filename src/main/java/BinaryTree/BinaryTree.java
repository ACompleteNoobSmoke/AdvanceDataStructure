package BinaryTree;

public class BinaryTree implements BinaryTreeFunctions, BinaryTreeTraversal{

    public TreeNode root;

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public Person getMin() {
        if(isEmpty()) return null;
        return getMin(root);

    }

    private Person getMin(TreeNode focusNode){
        if(focusNode.leftSide != null)
            return getMin(focusNode.leftSide);
        return focusNode.data;
    }

    @Override
    public Person getMax() {
        if(isEmpty()) return null;
        return getMax(root);
    }

    private Person getMax(TreeNode focusNode){
        if(focusNode.rightSide != null)
            return getMax(focusNode.rightSide);
        return focusNode.data;
    }

    @Override
    public void addNode(Person newPerson) {
        if(isEmpty()) root = new TreeNode(newPerson);
        else insertIntoTree(newPerson, root);
    }

    private void insertIntoTree(Person newPerson, TreeNode focusNode){
        if(newPerson.id < focusNode.data.id){
            if(focusNode.leftSide == null) focusNode.leftSide = new TreeNode(newPerson);
            else insertIntoTree(newPerson, focusNode.leftSide);
        }else if(newPerson.id > focusNode.data.id){
            if(focusNode.rightSide == null) focusNode.rightSide = new TreeNode(newPerson);
            else insertIntoTree(newPerson, focusNode.rightSide);
        }
    }

    @Override
    public Person searchNode(int id) {
        if(isEmpty()) return null;
        return searchTree(id, root);
    }

    private Person searchTree(int id, TreeNode searchNode){
        while(id != searchNode.data.id){
            if(id < searchNode.data.id) searchNode = searchNode.leftSide;
            else if(id > searchNode.data.id) searchNode = searchNode.rightSide;
            if(searchNode == null) return null;
        }
        return searchNode.data;
    }

    @Override
    public void deleteNode(int id) {
        if(isEmpty()) root = null;
        else root = removeFromTree(id, root);
    }

    private TreeNode removeFromTree(int id, TreeNode focusNode){
        if(id < focusNode.data.id)
            focusNode.leftSide = removeFromTree(id, focusNode.leftSide);
        else if(id > focusNode.data.id)
            focusNode.rightSide = removeFromTree(id, focusNode.rightSide);
        else{
            if(focusNode.leftSide == null) return focusNode.rightSide;
            else if(focusNode.rightSide == null) return focusNode.leftSide;

            focusNode.data = getMax(focusNode.leftSide);
            focusNode.leftSide = removeFromTree(focusNode.data.id, focusNode.leftSide);
        }
        return focusNode;
    }

    @Override
    public void inOrderTraversal(TreeNode focusNode) {
        if(focusNode != null){
            inOrderTraversal(focusNode.leftSide);
            System.out.println(focusNode);
            inOrderTraversal(focusNode.rightSide);
        }
    }

    @Override
    public void preOrderTraversal(TreeNode focusNode) {
        if(focusNode != null){
            System.out.println(focusNode);
            preOrderTraversal(focusNode.leftSide);
            preOrderTraversal(focusNode.rightSide);
        }
    }

    @Override
    public void postOrderTraversal(TreeNode focusNode) {
        if(focusNode != null){
            postOrderTraversal(focusNode.leftSide);
            postOrderTraversal(focusNode.rightSide);
            System.out.println(focusNode);
        }
    }
}
package BinaryTree;

public interface BinaryTreeFunctions {
    boolean isEmpty();
    TreeNode getMin();
    TreeNode getMax();
    void addNode(int id, String name, String occupation);
    TreeNode searchNode(int id);
    void deleteNode(int id);
    void inOrderTraversal(TreeNode focusNode);
    void preOrderTraversal(TreeNode focusNode);
    void postOrderTraversal(TreeNode focusNode);
}

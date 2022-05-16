package BinaryTree;

public interface BinaryTreeFunctions {
    boolean isEmpty();
    Person getMin();
    Person getMax();
    void add(Person newPerson);
    TreeNode searchNode(int id);
    void removeNode(int id);
    void inOrderTraversal(TreeNode focusNode);
    void preOrderTraversal(TreeNode focusNode);
    void postOrderTraversal(TreeNode focusNode);
}

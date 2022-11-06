package BinarySearchTree;

import BinaryTree.BinaryTree;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;
    private int size;

    public BinarySearchTree(){
        root = null;
        size = 0;
    }
}

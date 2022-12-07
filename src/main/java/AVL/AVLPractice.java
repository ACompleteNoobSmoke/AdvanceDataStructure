package AVL;

public class AVLPractice<T extends Comparable<T>>{
    private AVLNode<T> root;

    public AVLPractice(){ root = null; }

    private boolean isEmpty(){ return isNull(root); }
    private boolean isNull(Object obj){ return obj == null; }
    private boolean isLeftSide(T newData, T data){ return data.compareTo(newData) > 0; }
    private boolean isRightSide(T newData, T data){ return data.compareTo(newData) < 0; }


    public void preOrderTraversal(AVLNode<T> focusNode){
        if(!isNull(focusNode)){
            System.out.println(focusNode.getData());
            preOrderTraversal(focusNode.getLeftSide());
            preOrderTraversal(focusNode.getRightSide());
        }
    }

    public void inOrderTraversal(AVLNode<T> focusNode){
        if(!isNull(focusNode)){
            inOrderTraversal(focusNode.getLeftSide());
            System.out.println(focusNode.getData());
            inOrderTraversal(focusNode.getRightSide());
        }
    }

    public void postOrderTraversal(AVLNode<T> focusNode){
        if(!isNull(focusNode)){
            postOrderTraversal(focusNode.getLeftSide());
            postOrderTraversal(focusNode.getRightSide());
            System.out.println(focusNode.getData());
        }
    }
}
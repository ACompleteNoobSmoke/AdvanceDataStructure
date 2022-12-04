package AVL;

public class AVLPractice<T extends Comparable<T>>{
    private AVLNode<T> root;

    public AVLPractice(){ root = null; }

    private boolean isEmpty(){ return isNull(root); }
    private boolean isNull(Object obj){ return obj == null; }
    private boolean isLeftSide(T newData, T data){ return data.compareTo(newData) > 0; }
    private boolean isRightSide(T newData, T data){ return data.compareTo(newData) < 0; }
    private int height(AVLNode<T> focusNode){ return isNull(focusNode) ? 0 : focusNode.getHeight(); }
    private int balance(AVLNode<T> focusNode){
        return isNull(focusNode) ? 0 : height(focusNode.getLeftSide()) - height(focusNode.getRightSide());
    }


}
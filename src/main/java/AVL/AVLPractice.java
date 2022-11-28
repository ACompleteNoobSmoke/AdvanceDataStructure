package AVL;

public class AVLPractice<T extends Comparable<T>> {
    private AVLNode<T> root;

    public AVLPractice(){ this.root = null; }

    private boolean isEmpty(){ return isObjNull(root); }
    private boolean isObjNull(Object obj){ return obj == null; }
    private boolean isLeftSide(T data, T newData){ return data.compareTo(newData) > 0; }
    private boolean isRightSide(T data, T newData){ return data.compareTo(newData) < 0; }
    private int height(AVLNode<T> focusNode){ return (!isObjNull(focusNode)) ? focusNode.getHeight() : 0; }
    private int balance(AVLNode<T> focusNode){
        return (!isObjNull(focusNode)) ? height(focusNode.getLeftSide()) - height(focusNode.getRightSide()) : 0;
    }

    private void updateHeight(AVLNode<T> focusNode){
        int maxHeight = Math.max(height(focusNode.getLeftSide()),
                height(focusNode.getRightSide()));
        focusNode.setHeight(maxHeight + 1);
    }

    private AVLNode<T> applyRotation(AVLNode<T> focusNode){
        int balance = balance(focusNode);
        if(balance > 1){
            if(balance(focusNode.getLeftSide()) < 0)
                focusNode.setLeftSide(rotateLeft(focusNode.getLeftSide()));
            return rotateRight(focusNode);
        }else if(balance < 0){
            if(balance(focusNode.getRightSide()) > 0)
                focusNode.setRightSide(rotateRight(focusNode.getRightSide()));
            return rotateLeft(focusNode);
        }
        return focusNode;
    }

    private AVLNode<T> rotateLeft(AVLNode<T> focusNode){
        AVLNode<T> rightNode = focusNode.getRightSide();
        AVLNode<T> centerNode = rightNode.getLeftSide();
        rightNode.setLeftSide(focusNode);
        focusNode.setRightSide(centerNode);
        updateHeight(focusNode);
        updateHeight(rightNode);
        return rightNode;
    }

    private AVLNode<T> rotateRight(AVLNode<T> focusNode){
        AVLNode<T> leftNode = focusNode.getLeftSide();
        AVLNode<T> centerNode = leftNode.getRightSide();
        leftNode.setRightSide(focusNode);
        focusNode.setLeftSide(centerNode);
        updateHeight(focusNode);
        updateHeight(leftNode);
        return leftNode;
    }
}
package AVL;

public class AVLPractice<T extends Comparable<T>>{
    private AVLNode<T> root;

    public AVLPractice(){ root = null; }

    private boolean isEmpty(){ return isNull(root); }
    private boolean isNull(Object obj){ return obj == null; }
    private boolean isLeftSide(T newData, T data){ return data.compareTo(newData) > 0; }
    private boolean isRightSide(T newData, T data){ return data.compareTo(newData) < 0; }
    private int height(AVLNode<T> node){ return isNull(node) ? 0 : node.getHeight(); }
    private int balance(AVLNode<T> node){
        return isNull(node) ? 0 : height(node.getLeftSide()) - height(node.getRightSide());
    }

    private void updateHeight(AVLNode<T> node){
        int maxHeight = Math.max(height(node.getLeftSide()), height(node.getRightSide()));
        node.setHeight(maxHeight + 1);
    }

    private AVLNode<T> applyRotation(AVLNode<T> node){
        int balance = balance(node);
        if(balance > 1){
            if(balance(node.getLeftSide()) < 0)
                node.setLeftSide(rotateLeft(node.getLeftSide()));
            return rotateRight(node);
        }else if(balance < -1){
            if(balance(node.getRightSide()) > 0)
                node.setRightSide(rotateRight(node.getRightSide()));
            return rotateLeft(node);
        }
        return node;
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
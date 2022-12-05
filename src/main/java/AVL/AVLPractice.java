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

    public T getMin(){
        if(isEmpty()) return null;
        return getMin(root);
    }

    private T getMin(AVLNode<T> focusNode){
        if(!isNull(focusNode.getLeftSide()))
            return getMin(focusNode.getLeftSide());
        return focusNode.getData();
    }

    public T getMax(){
        if(isEmpty()) return null;
        return getMax(root);
    }

    private T getMax(AVLNode<T> focusNode){
        if(!isNull(focusNode.getRightSide()))
            return getMax(focusNode.getRightSide());
        return focusNode.getData();
    }

    public void insert(T newData){
        if(isNull(newData)) throw new IllegalArgumentException("Data Is Null");
        if(isEmpty()) root = new AVLNode<>(newData);
        else root = addToTree(newData, root);
    }

    private AVLNode<T> addToTree(T newData, AVLNode<T> focusNode){
        if(isLeftSide(newData, focusNode.getData())){
            if(isNull(focusNode.getLeftSide())) focusNode.setLeftSide(new AVLNode<>(newData));
            else addToTree(newData, focusNode.getLeftSide());
        }else if(isRightSide(newData, focusNode.getData())){
            if(isNull(focusNode.getRightSide())) focusNode.setRightSide(new AVLNode<>(newData));
            else addToTree(newData, focusNode.getRightSide());
        }
        updateHeight(focusNode);
        return applyRotation(focusNode);
    }

    public T search(T id){
        if(isNull(id)) throw new IllegalArgumentException("ID Is Null");
        if(isEmpty()) return null;
        return retrieveFromTree(id, root);
    }

    private T retrieveFromTree(T id, AVLNode<T> searchNode){
        while(!id.equals(searchNode.getData())){
            if(isLeftSide(id, searchNode.getData())) searchNode = searchNode.getLeftSide();
            else if(isRightSide(id, searchNode.getData())) searchNode = searchNode.getRightSide();
            if(isNull(searchNode)) return null;
        }
        return searchNode.getData();
    }

    public void remove(T id){
        if(isNull(id)) throw new IllegalArgumentException("ID Is Null");
        if(isEmpty()) return;
        root = deleteFromTree(id, root);
    }

    private AVLNode<T> deleteFromTree(T id, AVLNode<T> focusNode){
        if(isLeftSide(id, focusNode.getData()))
            focusNode.setLeftSide(deleteFromTree(id, focusNode.getLeftSide()));
        else if(isRightSide(id, focusNode.getData()))
            focusNode.setRightSide(deleteFromTree(id, focusNode.getRightSide()));
        else{
            if(isNull(focusNode.getLeftSide())) return focusNode.getRightSide();
            else if(isNull(focusNode.getRightSide())) return focusNode.getLeftSide();

            focusNode.setData(getMax(focusNode.getLeftSide()));
            focusNode.setLeftSide(deleteFromTree(focusNode.getData(), focusNode.getLeftSide()));
        }
        updateHeight(focusNode);
        return applyRotation(focusNode);
    }

}
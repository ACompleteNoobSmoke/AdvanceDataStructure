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
        }else if(balance < -1){
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
        if(isNull(id)) throw new IllegalArgumentException("Id Is Null");
        if(isEmpty()) return null;
        return retrieveFromTree(id, root);
    }

    private T retrieveFromTree(T id, AVLNode<T> searchNode){
        while(!searchNode.getData().equals(id)){
            if(isLeftSide(id, searchNode.getData())) searchNode = searchNode.getLeftSide();
            else if(isRightSide(id, searchNode.getData())) searchNode = searchNode.getRightSide();
            if(isNull(searchNode)) return null;
        }
        return searchNode.getData();
    }

    public void remove(T id){
        if(isNull(id)) throw new IllegalArgumentException("Id Is Null");
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
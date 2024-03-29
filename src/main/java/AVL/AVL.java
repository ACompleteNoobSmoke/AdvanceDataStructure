package AVL;

public class AVL<T extends Comparable<T>>{
    private AVLNode<T> root;

    public AVL(){ root = null; }

    private boolean isEmpty(){ return isNull(root); }
    private boolean isNull(Object obj){ return obj == null; }
    private boolean isLeftSide(T newData, T data){ return data.compareTo(newData) > 0; }
    private boolean isRightSide(T newData, T data){ return data.compareTo(newData) < 0; }
    private int height(AVLNode<T> focusNode) { return isNull(focusNode) ? 0 : focusNode.getHeight(); }
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

    public T search(T searchID){
        if(isNull(searchID)) throw new IllegalArgumentException("ID Is Null");
        if(isEmpty()) return null;
        return retrieveFromTree(searchID, root);
    }

    private T retrieveFromTree(T searchID, AVLNode<T> searchNode){
        while(!searchNode.getData().equals(searchID)){
            if(isLeftSide(searchID, searchNode.getData())) searchNode = searchNode.getLeftSide();
            else if(isRightSide(searchID, searchNode.getData())) searchNode = searchNode.getRightSide();
            if(isNull(searchNode)) return null;
        }
        return searchNode.getData();
    }

    public void remove(T searchID){
        if(isNull(searchID)) throw new IllegalArgumentException("ID Is Null");
        if(isEmpty()) return;
        root = deleteFromTree(searchID, root);
    }

    private AVLNode<T> deleteFromTree(T searchID, AVLNode<T> focusNode){
        if(isLeftSide(searchID, focusNode.getData()))
            focusNode.setLeftSide(deleteFromTree(searchID, focusNode.getLeftSide()));
        else if(isRightSide(searchID, focusNode.getData()))
            focusNode.setRightSide(deleteFromTree(searchID, focusNode.getRightSide()));
        else{
            if(isNull(focusNode.getLeftSide())) return focusNode.getRightSide();
            if(isNull(focusNode.getRightSide())) return focusNode.getLeftSide();

            focusNode.setData(getMax(focusNode.getLeftSide()));
            focusNode.setLeftSide(deleteFromTree(focusNode.getData(), focusNode.getLeftSide()));
        }
        updateHeight(focusNode);
        return applyRotation(focusNode);
    }

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
package BinaryTree;

public class BinaryTreeImp {

    public TreeNodeModel root;

    private boolean isEmpty(){
        return root == null;
    }

    public Person getMin(){
        if(isEmpty()) return null;
        return getMin(root);
    }

    private Person getMin(TreeNodeModel focusNode){
        if(focusNode.getLeftSide() != null)
            return getMin(focusNode.getLeftSide());
        return focusNode.getData();
    }

    public Person getMax(){
        if(isEmpty()) return null;
        return getMax(root);
    }

    private Person getMax(TreeNodeModel focusNode){
        if(focusNode.getRightSide() != null)
            return getMax(focusNode.getRightSide());
        return focusNode.getData();
    }

    public void addNode(Person newPerson){
        if(isEmpty()) root = new TreeNodeModel(newPerson);
        else insertToTree(newPerson, root);
    }

    private void insertToTree(Person newPerson, TreeNodeModel focusNode){
        TreeNodeModel newModel = new TreeNodeModel(newPerson);
        if(newPerson.id < focusNode.getData().id){
            if(focusNode.getLeftSide() == null) focusNode.setLeftSide(newModel);
            else insertToTree(newPerson, focusNode.getLeftSide());
        }else if(newPerson.id > focusNode.getData().id){
            if(focusNode.getRightSide() == null) focusNode.setRightSide(newModel);
            else insertToTree(newPerson, focusNode.getRightSide());
        }
    }

    public Person searchNode(int id){
        if(isEmpty()) return null;
        return retrieveFromTree(id, root);
    }

    private Person retrieveFromTree(int id, TreeNodeModel focusNode){
        while(id != focusNode.getData().id){
            if(id < focusNode.getData().id) focusNode = focusNode.getLeftSide();
            else if(id > focusNode.getData().id) focusNode = focusNode.getRightSide();
            if(focusNode == null) return null;
        }

        return focusNode.getData();
    }

    public void deleteNode(int id){
        if(isEmpty()) return;
        root = removeFromTree(id, root);
    }

    private TreeNodeModel removeFromTree(int id, TreeNodeModel focusNode){
        if(id < focusNode.getData().id)
            focusNode.setLeftSide(removeFromTree(id, focusNode.getLeftSide()));
        else if(id > focusNode.getData().id)
            focusNode.setRightSide(removeFromTree(id, focusNode.getRightSide()));
        else{
            if(focusNode.getLeftSide() == null) return focusNode.getRightSide();
            else if(focusNode.getRightSide() == null) return focusNode.getLeftSide();

            focusNode.setData(getMax(focusNode.getLeftSide()));
            focusNode.setLeftSide(removeFromTree(focusNode.getData().id, focusNode.getLeftSide()));
        }
        return focusNode;
    }

    public void preOrderTraversal(TreeNodeModel focusNode){
        if(focusNode != null){
            System.out.println(focusNode.getData());
            preOrderTraversal(focusNode.getLeftSide());
            preOrderTraversal(focusNode.getRightSide());
        }
    }

    public void postOrderTraversal(TreeNodeModel focusNode){
        if(focusNode != null){
            postOrderTraversal(focusNode.getLeftSide());
            postOrderTraversal(focusNode.getRightSide());
            System.out.println(focusNode.getData());
        }
    }

    public void inOrderTraversal(TreeNodeModel focusNode){
        if(focusNode != null){
            inOrderTraversal(focusNode.getLeftSide());
            System.out.println(focusNode.getData());
            inOrderTraversal(focusNode.getRightSide());
        }
    }
}


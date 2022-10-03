package BinaryTree;

public class BinaryTree2 {
   private Node root;

   private boolean isEmpty(){ return root == null; }

    public Person getMin(){
       if(isEmpty()) return null;
       return getMin(root);
    }

    private Person getMin(Node focusNode){
       if(focusNode.getLeftSide() != null)
           return getMin(focusNode.getLeftSide());
       return focusNode.getData();
    }

    public Person getMax(){
       if(isEmpty()) return null;
       return getMax(root);
    }

    private Person getMax(Node focusNode){
       if(focusNode.getRightSide() != null)
           return getMax(focusNode.getRightSide());
       return focusNode.getData();
    }

    public void addNode(Person newPerson){
       if(isEmpty()) root = new Node(newPerson);
       else insertIntoTree(newPerson, root);
    }

    private void insertIntoTree(Person newPerson, Node focusNode){
        if(newPerson.id < focusNode.getData().id){
            if(focusNode.getLeftSide() == null) focusNode.setLeftSide(new Node(newPerson));
            else insertIntoTree(newPerson, focusNode.getLeftSide());
        }else if(newPerson.id > focusNode.getData().id){
            if(focusNode.getRightSide() == null) focusNode.setRightSide(new Node(newPerson));
            else insertIntoTree(newPerson, focusNode.getRightSide());
        }
    }

    public Person searchNode(int id){
       if(isEmpty()) return null;
       return retrieveFromTree(id, root);
    }

    private Person retrieveFromTree(int id, Node searchNode){
       while(id != searchNode.getData().id){
            if(id < searchNode.getData().id) searchNode = searchNode.getLeftSide();
            else if(id > searchNode.getData().id) searchNode = searchNode.getRightSide();
            if(searchNode == null) return null;
       }
       return searchNode.getData();
    }

    public void deleteNode(int id){
       if(isEmpty()) return;
       root = removeFromTree(id, root);
    }

    private Node removeFromTree(int id, Node focusNode){
       if(id < focusNode.getData().id) focusNode.setLeftSide(removeFromTree(id, focusNode.getLeftSide()));
       else if(id > focusNode.getData().id) focusNode.setRightSide(removeFromTree(id, focusNode.getRightSide()));
       else{
           if(focusNode.getLeftSide() == null) return focusNode.getRightSide();
           else if(focusNode.getRightSide() == null) return focusNode.getLeftSide();

           focusNode.setData(getMax(focusNode.getLeftSide()));
           focusNode.setLeftSide(removeFromTree(focusNode.getData().id, focusNode.getLeftSide()));
       }
       return focusNode;
    }

    public void inOrderTraversal(Node focusNode){
       if(focusNode != null){
           inOrderTraversal(focusNode.getLeftSide());
           System.out.println(focusNode.getData());
           inOrderTraversal(focusNode.getRightSide());
       }
    }

    public void preOrderTraversal(Node focusNode){
       if(focusNode != null){
           System.out.println(focusNode.getData());
           preOrderTraversal(focusNode.getLeftSide());
           preOrderTraversal(focusNode.getRightSide());
       }
    }
    public void postOrderTraversal(Node focusNode){
       if(focusNode != null){
           postOrderTraversal(focusNode.getLeftSide());
           postOrderTraversal(focusNode.getRightSide());
           System.out.println(focusNode.getData());
       }
    }

}

package BinaryTree;

public class TreeNodeModel {
    private TreeNodeModel leftSide;
    private TreeNodeModel rightSide;
    private Person data;

    public TreeNodeModel(Person newPerson) {
        this.data = newPerson;
    }

    public void setLeftSide(TreeNodeModel leftSide) {
        this.leftSide = leftSide;
    }

    public TreeNodeModel getLeftSide() {
        return leftSide;
    }

    public void setRightSide(TreeNodeModel rightSide) {
        this.rightSide = rightSide;
    }

    public TreeNodeModel getRightSide(){
        return rightSide;
    }

    public void setData(Person newPerson){
        this.data = newPerson;
    }

    public Person getData(){
        return data;
    }

    public String toString(){
        return data.toString();
    }
}


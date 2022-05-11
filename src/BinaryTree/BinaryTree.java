package BinaryTree;

public class BinaryTree{

    private TreeNode root;

    /***** FUNCTIONALITY(Start) *****/
    public void addNode(int id, String name, String occupation){
        TreeNode newNode = new TreeNode(id, name, occupation);
        if(root == null){
            root = newNode;
        }else{
            TreeNode focusNode = root;
            TreeNode parent;
            while(true){
                parent = focusNode;
                if(id < focusNode.id){
                    focusNode = focusNode.left;
                    if(focusNode == null){
                        parent.left = newNode;
                        return;
                    }
                }else{
                    focusNode = focusNode.right;
                    if(focusNode == null){
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public TreeNode search(int id){
        if(root != null){
            TreeNode searchTree = root;
            while(searchTree.id != id){
                if(id < searchTree.id){
                    searchTree = searchTree.left;
                }else{
                    searchTree = searchTree.right;
                }
                if(searchTree == null){
                    return null;
                }
            }
            return searchTree;
        }
        return null;
    }

    /***** FUNCTIONALITY(End) *****/

    /***** TRAVERSALS(Start) *****/

    public void inOrderTraversal(TreeNode focusNode){
        if(focusNode != null){
            inOrderTraversal(focusNode.left);
            System.out.println(focusNode);
            inOrderTraversal(focusNode.right);
        }
    }

    public void preOrderTraversal(TreeNode focusNode){
        if(focusNode != null){
            System.out.println(focusNode);
            preOrderTraversal(focusNode.left);
            preOrderTraversal(focusNode.right);
        }
    }

    public void postOrderTraversal(TreeNode focusNode){
        if(focusNode != null){
            postOrderTraversal(focusNode.left);
            postOrderTraversal(focusNode.right);
            System.out.println(focusNode);
        }
    }

    /***** TRAVERSALS(End) *****/


    public static void main(String[] args){
        BinaryTree testTree = new BinaryTree();
        testTree.addNode(47, "Jackie Chan", "Actor");
        testTree.addNode(11, "Sammy", "Student");
        testTree.addNode(100, "Boye", "Programmer");
        testTree.addNode(85, "Ade", "Aspiring Programmer");
        testTree.addNode(5, "Osaretin", "Sailor");
        testTree.addNode(22, "Victoria", "Freelancer");

        //testTree.inOrderTraversal(testTree.root);
        //testTree.preOrderTraversal(testTree.root);
        //testTree.postOrderTraversal(testTree.root);
        System.out.println(testTree.search(100));
    }


}
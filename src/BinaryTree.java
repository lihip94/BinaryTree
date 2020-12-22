class Node {
    int value;
    Node left;
    Node right;
    int x,y;

    Node(int value){
        this.value = value;
        right = null;
        left = null;
    }

    public int getValue(){
        return value;
    }

    public Node getLeft(){
        return left;
    }

    public Node getRight(){
        return right;
    }

}

public class BinaryTree {

    Node root;
    static int w=100, h=100;

    //constructors
    BinaryTree(){
        root = null;
    }

    //Inserting
    private Node addRecursive(Node current, int value){

        if (current == null){
            return new Node(value);
        }

        if (value < current.value){
            current.left = addRecursive(current.left, value);
        }
        else if (value > current.value){
            current.right = addRecursive(current.right, value);
        }
        else{
            return current;
        }
        return current;
    }

    public void add(int value){
        root = addRecursive(root, value);
    }

    //deleting
    private Node deleteRecursive(Node current, int value){
        if (current == null){
            return null;
        }
        if (value == current.value){
            if(current.left == null && current.right == null){
                return null;
            }
            else if(current.left == null){
                return current.right;
            }
            else if(current.right == null){
                return current.left;
            }
            else {
                int minNewValue = minValue(current);
                current.value = minNewValue;
                current.left = deleteRecursive(current.left, minNewValue);
            }
        }
        if(value < current.value){
            current.left = deleteRecursive(current.left, value);
        }
        current.right = deleteRecursive(current.right,value);
        return current;
    }
    private int minValue(Node current){
        if(current.left != null){
            return minValue(current.left);
        }
        return current.value;
    }
    public void delete(int value){
        root = deleteRecursive(root, value);
    }


}

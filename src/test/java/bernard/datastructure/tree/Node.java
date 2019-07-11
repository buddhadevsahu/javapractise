package bernard.datastructure.tree;

public class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int v, Node l, Node r){
        this.value=v;
        this.left=l;
        this.right=r;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                  '}';
    }
}

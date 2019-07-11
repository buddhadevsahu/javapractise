package bernard.datastructure.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeUtility {


    public static Node getSimpleTree(){
        Node node7 =new Node(7,null,null);
        Node node6 =new Node(6,null,null);
        Node node5 =new Node(5,null,null);
        Node node4 =new Node(4,null,null);
        Node node3 =new Node(3,node6,node7);
        Node node2 =new Node(2,node4,node5);
        Node root =new Node(1,node2,node3);
        return root;
    }

    public static void printTree(Node root){

        if(root == null)
            return;

        Queue<Node> queue= new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){

            Node current_node = queue.poll();
            System.out.println("Node "+current_node.getValue());
            if(current_node.getLeft()!=null)
                queue.offer(current_node.getLeft());
            if(current_node.getRight()!=null)
                queue.offer(current_node.getRight());
        }


    }


}

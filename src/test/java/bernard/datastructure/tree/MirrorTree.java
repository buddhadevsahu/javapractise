package bernard.datastructure.tree;


        import org.junit.Test;

        import java.util.LinkedList;
        import java.util.Queue;

        import static bernard.datastructure.tree.BinaryTreeUtility.*;
/**
 * Given a binary tree convert it to mirror immage
 */

public class MirrorTree {

    @Test
    public void TestSimpleTreeDisplay(){
        printTree(getSimpleTree());
    }

    @Test
    public void testMirrorTree1(){
        Node root=getSimpleTree();
        printTree(root);
        Node root1=convertMirrorTree(root);
        printTree(root1);
    }

    public Node convertMirrorTree(Node root){

        //Any traversing logic to tree
        if(root== null)
            return null;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.getLeft() != null)
                queue.offer(cur.getLeft());
            if(cur.getRight() != null)
                queue.offer(cur.getRight());
            // swap left and right
            if(cur.getLeft() != null || cur.getRight() != null){
                System.out.println("swaping Left : "+cur.getLeft()+" <==> Right : "+cur.getRight());
                Node temp= cur.getLeft();
                cur.setLeft(cur.getRight());
                cur.setRight(temp);
            }
        }
        return root;
    }


}

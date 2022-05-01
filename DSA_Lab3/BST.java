package DSA_Lab3;

import java.util.ArrayDeque;
import java.util.Queue;

public class BST {

    private int pairIs=-2;
    private int sum;

    /**
     * Inserting the node data in to the Binary Search tree.
     * @param aNode
     * @param aData
     */

    void insertBST(Node aNode, int aData) {
        //System.out.println("aNode.data is :::::::"+aData);
        Node newNode =new Node();
        Node temp_node=aNode;
        if (temp_node!=null) {
            if (temp_node.data > aData) {
                if (temp_node.left == null) {
                    temp_node.left = newNode.newNode(aData);
                } else {
                    insertBST(aNode.left, aData);
                }
            } else if (temp_node.data < aData) {
                if (temp_node.right == null) {
                    temp_node.right = newNode.newNode(aData);
                } else {
                    insertBST(aNode.right, aData);
                }
            }
        }else{
            return;
        }
     }

    /**
     * Traversing the tree with In order to display all the nodes
     * @param root
     */
    void InOrderTraverse(Node root) {
        //System.out.println("inordertraverse");
        if (root == null)
            return;
        else {
            InOrderTraverse(root.left);
            System.out.print(root.data + " ");
            InOrderTraverse(root.right);
        }
    }

   // public boolean findSumPair(int sum, Node root) {

    /**
     * Program for pair sum
     * @param sum
     * @param root
     */
   public void findSumPair(int sum, Node root) {
        this.sum=sum;
        levelOrder(root, sum);
        /*        if (pairIs<0) {
             System.out.print("Pair Sum could not be found.");
             return false;
         }else{
             return true;
         }         */
    }

    /**
     * Using level order to start the search
     * Level Order search gives the first pair
     * @param root
     * @param sum
     */
    private void levelOrder(Node root, int sum) {
        Node temp_node= root;
        Queue que = new ArrayDeque();
        while( temp_node!= null){
            //System.out.print(temp_node.data + "LO ");
            //considering the tempNode data as first number
            int searchItem=sum-temp_node.data;
            PreOrder(root, searchItem);
            /*            pairIs=PreOrder(root, searchItem);
            if( pairIs!=-1){
                System.out.println("the pair is:: ("+(sum-temp_node.data)+", "+pairIs+")");
                return;
            }            */
            if (temp_node.left != null) {
                que.add(temp_node.left);
            }
            if (temp_node.right != null) {
                que.add(temp_node.right);
            }
            temp_node = (Node) que.poll();
        }
    }

    /**
     * Using PreOrder search to search for the second number of the pair
     * @param aNode
     * @param searchItem
     */
    private void PreOrder(Node aNode, int searchItem) {
        //System.out.println("search node is:::"+searchItem);
        if (aNode == null) {
            //System.err.println("No Tree, node is null.");
            return ;
        }else {
            //System.out.print(aNode.data + "PO ");
            if (searchItem== aNode.data){
                int pair2=aNode.data;
                System.out.println("Pair found, It is::"+pair2+", "+(sum-pair2));

                System.exit(0);// was using return; :: was giving all the matching pairs
                //return;
                //return aNode.data;
            }
            PreOrder(aNode.left, searchItem);
            PreOrder(aNode.right, searchItem);
        }
    }
}

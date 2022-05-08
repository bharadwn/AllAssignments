/**
 *
 * Question 2 MARKS: 30
 * You are working in an MNC, which manages the Transactions, where only BST is used as a
 * Data Structure. The company stores all the data of transactions in BST such that the tree is
 * always a complete BST.
 * A new business requirement has arrived where the BST should not contain any left node.
 * You are required to modify the existing BST and display the node values present in ascending
 * order.
 * Hint: ( Convert the Binary Search Tree into a Skewed Tree).
 * Output
 * 10 30 50 55 60
 * Instructions
 * You can hardcode the tree as follows
 * Main tree = new Main();
 * tree.node = new Node(50);
 * tree.node.left = new Node(30);
 * tree.node.right = new Node(60);
 * tree.node.left.left = new Node(10);
 * tree.node.right.left= new Node(55);
 *
 */
package Project2;

import week8.InOrderTraversal;
import week8.PreOrderTraversal;

import java.util.Arrays;
import java.util.Scanner;

public class BSTtoSkewedTree {
    private Node root;
    private Node skewed_root;
    private Node tempNode;

    public static void main(String[] args) {
        BSTtoSkewedTree skewTree = new BSTtoSkewedTree();
        skewTree.createBST();

        System.out.print("The Binary Search Tree(Pre Order Traversal) is::");
        skewTree.traverseBST();

        skewTree.createSkewed();

        System.out.println();
        System.out.print("The Right Skewed Binary Tree is::");
        skewTree.traverseSkewedTree();
    }

    private void createSkewed() {
        createRightTree(root);
    }

    private void traverseBST() {
        preOrder(root);
    }

    private void traverseSkewedTree() {
        if (skewed_root==null){
            System.out.println("no tree found in skewed root");
        }
        InOrderTraverse(skewed_root);
    }

    /**
     * Traversing the tree with In order to display all the nodes
     * @param aNode
     */
    void InOrderTraverse(Node aNode) {
        //System.out.println("inordertraverse");
        if (aNode == null) {
            return;
        } else {
            InOrderTraverse(aNode.left);
            System.out.print(aNode.data + " ");
            InOrderTraverse(aNode.right);
        }
    }

    /**
     * Traversing the tree with Pre order to display all the nodes
     * @param aNode
     */
    public void preOrder(Node aNode) {
        if (aNode == null)
            return;
        else {
            System.out.print(aNode.data + " ");
            preOrder(aNode.left);
            preOrder(aNode.right);
        }
    }

    /**
     * Traversing Inorder and putting the nodes into a skewed tree
     * -recursive
     * @param aNode
     */
    private void createRightTree(Node aNode) {
        if (aNode == null) {
            //System.out.println("111skewed root is null");
            return;
        }else {
            //System.out.println("right tree not null"+aNode.data);
            createRightTree(aNode.left);
            //Inorder traversal , so the new tree is formed at this point
            if (skewed_root != null) {
                //System.out.println("inside adding the non root node "+aNode.data);
                //not root nodes...
                Node newN = new Node();
                Node aRightNode = newN.newNode(aNode.data);
                if (tempNode.right == null) {
                    tempNode.right = aRightNode;
                    //System.out.println("createRight::non-root node added"+tempNode.data);
                    tempNode = tempNode.right;
                } else {  //System.out.println("right node is not null");
                }
            } else {
                //first skewed tree node
                //System.out.println("createRight::root node added"+aNode.data);
                Node newN = new Node();
                skewed_root = newN.newNode(aNode.data);
                tempNode=skewed_root;
            }
            //System.out.print(aSkewedRoot.data + " ");
            createRightTree(aNode.right);
        }
    }

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
     * Binary Search Tree - creating
     *
     *
     */
    private  void createBST() {
        int array[] = {60,30,55,50,10};
        System.out.println("Given array is::"+ Arrays.toString(array));

        if (array.length>1) {
            //bst.insert(root , array[0]);
            //Considering the first number as the root
            Node newN=new Node();
            root=newN.newNode(array[0]);
            for (int i = 1; i < array.length; i++) {
               insertBST(root,array[i] );
            }
        }
    }
}

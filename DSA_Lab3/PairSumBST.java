package DSA_Lab3;

import java.util.Scanner;

public class PairSumBST {

    private Node root;
    private BST bst;

    private int sum;

    /**
     * Constructor is creating the tree
     */
    PairSumBST(){
        bst= new BST();
        createBST();
    }
    public static void main(String[] args) {
        PairSumBST pairSum = new PairSumBST();
        System.out.print("Binary Search tree is::");
        pairSum.traverse();
        //Get the Sum from the user
        pairSum.getInput();
        //Find pair
        pairSum.sumPair();
    }

    /**
     * Taking user input for the sum
     */
    private void getInput() {
        System.out.print("Enter the sum ::");
        Scanner scanner= new Scanner(System.in);
        sum = scanner.nextInt();
    }

    /**
     * Find pair adding to the given sum.
     */
    private void sumPair(){
        //we know sum, so finding the pair to equal the sum
        bst.findSumPair(sum, root);
    }

    /**
     * Display the BST in Inorder
     */
    private void traverse() {
        bst.InOrderTraverse(root);
        System.out.println("");
    }

    private  void createBST() {
        int array[] = {40,20,30,60,70,10,50};
        //System.out.println("THe Length if the array is::"+array.length);

        if (array.length>1) {
            //bst.insert(root , array[0]);
            //Considering the first number as the root
            Node newN=new Node();
            root=newN.newNode(array[0]);
            for (int i = 1; i < array.length; i++) {
                bst.insertBST(root,array[i] );
            }
        }
    }

}

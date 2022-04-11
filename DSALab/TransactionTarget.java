package AssignmentFOP1.DSALab;

import java.util.Scanner;

public class TransactionTarget {

    private int[] transArray;
    //private Stacks transactionStack ;
    private int[] targetArray;
    private int s1;

    public int getS2() {
        return s2;
    }

    public void setS2(int s2) {
        this.s2 = s2;
    }

    private int s2;
    public static void main(String[] args) {
        TransactionTarget tt = new TransactionTarget();
        tt.inputData();
        //tt.checkTargets();

    }

    private void checkTargets() {
        int targetReachedIn=-1;
        for (int i = 0; i < s2; i++) {
            int target = getTargetArray()[i];
            targetReachedIn = transactionCheck(target);
            //System.out.println("target Reached in "+targetReachedIn);
            if (targetReachedIn>0) {
                System.out.println("Target reached for target" + (i + 1) + " in " + targetReachedIn + " transactions.");
            } else {
                System.out.println("Target Could not be reached.");
            }
        }
    }

    private void checkTarget(int target) {
        int targetReachedIn=-1;


        targetReachedIn = transactionCheck(target);
        //System.out.println("target Reached in "+targetReachedIn);
        if (targetReachedIn>0) {
            System.out.println("Target reached in " + targetReachedIn + " transactions.");
        } else {
            System.out.println("Target Could not be reached.");
        }

    }

    private int  transactionCheck(int target) {
       // int targetReached =0;
        //System.out.println("getTransArray()[0]"+getTransArray()[0]+"target"+target);
        if (target<= getTransArray()[0]) {

            return 1;
            //System.out.println("Target reached for " + (targetNo+1) + " target in " + targetReached + " transactions.");
        } else {
            int currentTransactionCount=0;
            int targetReached=1;

            for (int i = 0; i < (s1-1); i++) {
                targetReached++;
                currentTransactionCount = this.transArray[i]+this.transArray[i+1];
                //System.out.println("current transaction count is::"+currentTransactionCount);
                if (target<=currentTransactionCount){
                    return targetReached;
                }
            }
        }
        return 0;
    }

    void inputData(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Transaction Size::");
        s1 = scan.nextInt();

        System.out.println("Enter the elements of the TRANSACTION array with 'Enter' button in between each element::");
        int i=0, j=0;
        transArray = new int[s1];
        while (i!=s1) {
            transArray[i++]=scan.nextInt();
        }
        System.out.println("Target size");
        s2 = scan.nextInt();

        System.out.println("Enter the elements of the TARGET array with 'Enter' button in between each element::");
        targetArray = new int[s2];
        while (j!=getS2()){
            //targetArray[j++]=scan.nextInt();
            j++;
            checkTarget(scan.nextInt());
        }

       //transactionStack = new Stacks(transArray);

    }


    public int[] getTargetArray() {
        return targetArray;
    }

    public void setTargetArray(int[] targetArray) {
        this.targetArray = targetArray;
    }


    public int[] getTransArray() {
        return transArray;
    }

    public void setTransArray(int[] transArray) {
        this.transArray = transArray;
    }

}

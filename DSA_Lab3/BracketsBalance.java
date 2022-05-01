package DSA_Lab3;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class BracketsBalance {


    private char[] bracketChars;
    private boolean balance = true;

    public static void main(String[] args) {
        BracketsBalance bb = new BracketsBalance();
        bb.getInput();
    }

    private boolean findBalance() {

        Stack st =new Stack<Character>();
        balance=true;
        try {
            //Put all the opening brackets in the Stack
            for (char aChar : bracketChars) {
                //System.out.println("the character is"+aChar);
                switch (aChar) {
                    case '{', '(', '[':
                        st.push(aChar);
                        break;
                    case '}', ')', ']':
                        //System.out.println("Balance is"+balance);
                        if (balance) {
                            char bChar = (char) st.pop();
                            //System.out.println("aChar::" + aChar + " bCHar::" + bChar);
                            switch (bChar) {
                                case '{':
                                    if (aChar == '}') balance = true;
                                    else balance = false;
                                    //System.out.println("in {" + balance);
                                    break;
                                case '(':
                                    if (aChar == ')') balance = true;
                                    else  balance = false;
                                    //System.out.println("in (" + balance);
                                    break;
                                case '[':
                                    if (aChar == ']') balance = true;
                                    else balance = false;
                                    //System.out.println("in [" + balance);
                                    break;
                            }
                        }
                        break;
                    default:
                        System.out.println("Invalid character found in the input.");
                        break;
                }
            }
        } catch(EmptyStackException e) {
            balance=false;
            //System.out.println("Stack empty");
        }
        //System.out.println(st.toString());
        if (st.size()!=0){
            balance=false;
        }
        if (balance)
            System.out.println("The entered String " + Arrays.toString(bracketChars) + " has Balanced Brackets.");
        else
            System.out.println("The entered String "+ Arrays.toString(bracketChars)+" do not contain Balanced Brackets.");

        return balance;
    }

    private void getInput() {
        System.out.println("Enter the brackets string:::");
        char inputStatus='e';

        Scanner sc=new Scanner(System.in);
        String bracketsStr="";
        while (inputStatus!='s') {
            bracketsStr = sc.nextLine();
            bracketChars = bracketsStr.toCharArray();
            boolean balance = findBalance();
        }


    }
}

/**
 * You are a traveler and traveling to a country where the currency denominations are
 * unknown and as you travel, you get to know about the denomination in random order.
 * You want to make a payment of amount x, in such a way that the number of notes you give
 * is minimum.
 * //Assume that the denominations are in such a way that any amount can be paid.
 * Input
 * Take input of all the currency denominations ( random order)
 *
 *
 * Take input of the amount that you want to pay.
 * Output
 * Print the minimum no of notes that you will be using to pay the net amount.
 * TestCase 1
 * Enter the size of currency denominations
 * 3
 * Enter the currency denominations value
 * 5
 * 1
 * 10
 * Enter the amount you want to pay
 * 12
 * Your payment approach in order to give min no of notes will be
 * 10:1
 * 1:2
 * TestCase 2
 * Enter the size of currency denominations
 * 5
 *
 * Enter the currency denominations value
 * 60
 * 5
 * 12
 * 78
 * 25
 * Enter the amount you want to pay
 * 128
 * Your payment approach in order to give min no of notes will be
 * 78:1
 * 25:2
 * TestCase 3
 * Enter the size of currency denominations
 * 4
 * Enter the currency denominations value
 * 12
 * 5
 * 123
 * 18
 * Enter the amount you want to pay
 * 158
 * Your payment approach in order to give min no of notes will be
 * 123:1
 * 18:1
 * 12:1
 * 5:1
 *
 *
 *
 *
 *
 * THIS does not ensure case 3 .. Just FYI
 */

package AssignmentFOP1.DSALab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CurrencyCalc {
        private static Scanner scan;
        private int[] sortedCurrencyDArray;
        private int netAmt;


        ArrayList<Integer> outputArray = new ArrayList<>();
        ArrayList<Integer> maybeOutputArr = new ArrayList<>();
        ArrayList<Integer> moreTotalOutputArr = new ArrayList<>();

    ArrayList<Integer> possibleCurrencyList = new ArrayList<>();
    ArrayList<Integer> currencyOutputArr = new ArrayList<>();


    public static void main(String[] args) {
            CurrencyCalc tcc = new CurrencyCalc();
            tcc.implementCurrencyOrder();
        }



        void implementCurrencyOrder(){
            scan = new Scanner(System.in);
            //do {
            inputData();
            //}while (scan.nextInt()!=0);

            createCurrencyPossibilitiesArray();
            //getOuputAmountArray();
            boolean result = getPayCurrencyOrder();
            if (result) {
                System.out.println("Possible Currency List");
                System.out.println(possibleCurrencyList.toString());

                System.out.println("Final Output Array::");
                System.out.println(currencyOutputArr.toString());
            }else {
                System.out.println("could NOT match the denominations to the net Amount");
            }
            //printOutput();
        }

        public boolean getPayCurrencyOrder(){
            System.out.println("inside getPayCurrencyOrder");
            int size = possibleCurrencyList.size();

            for (int i = 2; i < size; i=i+3) {
                System.out.println("possibleCurrencyList.get(i)"+possibleCurrencyList.get(i));
                if (getNetAmt()==possibleCurrencyList.get(i)){
                    currencyOutputArr.add(possibleCurrencyList.get(i-2));
                    currencyOutputArr.add(possibleCurrencyList.get(i-1));
                    return true;
                }else
                if (getNetAmt()>possibleCurrencyList.get(i)){
                    currencyOutputArr.add(possibleCurrencyList.get(i-2));
                    currencyOutputArr.add(possibleCurrencyList.get(i-1));
                }

                System.out.println("Current1 Output Array::");
                System.out.println(currencyOutputArr.toString());

                System.out.println("i is::"+i);
                int remainingAmount = getNetAmt()-possibleCurrencyList.get(i);
                for (int j = i+3; j < size; j=j+3) {
                    System.out.println("j is" + j);
                    if (remainingAmount>=possibleCurrencyList.get(j)) {
                        boolean b1 = remainingAmount % possibleCurrencyList.get(j) == 0;//checking for divisibility and remainder being 0
                        boolean b2 = possibleCurrencyList.get(j - 2) != possibleCurrencyList.get(i - 2);//checking if it is not the same currency
                        System.out.println("remainingAmount" + remainingAmount + "possibleCurrencyList.get(j)" + possibleCurrencyList.get(j));
                        System.out.println("possibleCurrencyList.get(j - 2)" + possibleCurrencyList.get(j - 2) + "possibleCurrencyList.get(i - 2)" + possibleCurrencyList.get(i - 2));
                        if (b1 && b2) {
                            currencyOutputArr.add(possibleCurrencyList.get(j - 2));
                            currencyOutputArr.add(remainingAmount / possibleCurrencyList.get(j));
                            return true;
                        }
                        System.out.println("Current2 Output Array::");
                        System.out.println(currencyOutputArr.toString());
                    }
                }
            }
            return false;
        }


        public void createCurrencyPossibilitiesArray(){
            possibleCurrencyList = new ArrayList<>();
            for (int i = 0; i < getSortedCurrencyDArray().length; i++) {
                int currency = getSortedCurrencyDArray()[i];
                if (currency > 0) {//ensuring no denomination is value0
                    if (getNetAmt() >= currency) {
                        int times = 1;
                        int addedCurrency = currency;
                        possibleCurrencyList.add(currency);
                        possibleCurrencyList.add(times);
                        possibleCurrencyList.add(addedCurrency);
                        boolean addedTheMoney = false;

                        while (getNetAmt() > addedCurrency) {
                            times++;
                            addedTheMoney = true;
                            addedCurrency = addedCurrency + currency;

                            possibleCurrencyList.add(currency);
                            possibleCurrencyList.add(times);
                            possibleCurrencyList.add(addedCurrency);
                        }
                        addedCurrency = addedCurrency - currency;
                        System.out.println("currency::" + currency + "times::" + times + "addedCurrency::" + addedCurrency + "possibleCurrencyList.size()" + possibleCurrencyList.size());

                        System.out.println(possibleCurrencyList.toString());
                        if (addedTheMoney) {// removing the extra added money
                            possibleCurrencyList.remove(possibleCurrencyList.size() - 1);
                            possibleCurrencyList.remove(possibleCurrencyList.size() - 1);
                            possibleCurrencyList.remove(possibleCurrencyList.size() - 1);
                        }
                    }
                }
            }

        }

        public void getOuputAmountArray(){
            int size= getSortedCurrencyDArray().length;
            for (int i = 0; i < size; i++) {

                int currencyDenomination = sortedCurrencyDArray[i];
                int addedCurrency=currencyDenomination;
                int times=1;

                System.out.println("getNetamoutn"+getNetAmt()+"currencyDenomination::"+currencyDenomination);
                if (getNetAmt() >= addedCurrency) {


                    while (getNetAmt() > addedCurrency) {
                        times++;
                        addedCurrency = addedCurrency + currencyDenomination;
                    }
                    System.out.println("added currency" + addedCurrency);

                    if (getNetAmt() == addedCurrency) {
                        outputArray.add(currencyDenomination);
                        outputArray.add(times);
                    } else {
                        addedCurrency = addedCurrency - currencyDenomination;
                        setNetAmt(getNetAmt() - addedCurrency);
                        System.out.println("get Net Amount" + getNetAmt());
                        getOuputAmountArray();
                    }
                }
                else
                if (getNetAmt() < currencyDenomination){
                    System.out.println("Current Denomination does not work, check others");

                      System.out.println("size-1 is::"+(size-1)+"i+1::"+(i+1));
                        if ((size-1)>=(i+1)){
                            for (int j = i + 1; j < size - 1; j++) {
                                getOuputAmountArray();
                            }
                        } else {
                            System.out.println("not more denominations left");
                        }
                    }

                }

        }




    void inputData(){

        System.out.println("Enter the currency denomination array size::");
        int s1 = scan.nextInt();

        System.out.println("Enter the values of the Currency denominations with 'Enter' button in between each element::");
        int i=0, j=0;
        int [] currencyDenominationArray = new int[s1];
        while (i!=s1) {
            currencyDenominationArray[i++]=scan.nextInt();
        }

        QuickSortDescending qs = new QuickSortDescending();
        sortedCurrencyDArray = qs.getSortedArray(currencyDenominationArray, "DSC");
        setSortedCurrencyDArray(sortedCurrencyDArray);

        System.out.println(Arrays.toString(sortedCurrencyDArray));

        System.out.println("Enter the amount");
        netAmt= scan.nextInt();

        setNetAmt(netAmt);
    }


    public int[] getSortedCurrencyDArray() {
        return sortedCurrencyDArray;
    }

    public void setSortedCurrencyDArray(int[] sortedCurrencyDArray) {
        this.sortedCurrencyDArray = sortedCurrencyDArray;
    }


    public int getNetAmt() {
        return netAmt;
    }

    public void setNetAmt(int netAmt) {
        this.netAmt = netAmt;
    }

    public void printOutput(){

        if (outputArray.size()!=0) {
            System.out.println(outputArray.toString());
        }
        /*
        if (maybeOutputArr.size()!=0) {
            System.out.println("may be array is::");
            System.out.println(maybeOutputArr.toString());
        }
        if (moreTotalOutputArr.size()!=0) {
            System.out.println("more total with cash back array is::");
            System.out.println(moreTotalOutputArr.toString());
        }

         */
    }
}

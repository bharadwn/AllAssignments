package AssignmentFOP1.DSALab;

import week2.A;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TravelCurrencyCalculation {

    private ArrayList<Integer> outputArray = new ArrayList<>();
    private int netAmount;
    private int[] sortedCurrDenoms;

    private boolean flag=false;

    int cashBack=-1;


    public static void main(String[] args) {
        TravelCurrencyCalculation tcc = new TravelCurrencyCalculation();
        tcc.inputData();

    }

    void inputData(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the currency denomination array size::");
        int s1 = scan.nextInt();

        System.out.println("Enter the values of the Currency denominations with 'Enter' button in between each element::");
        int i=0, j=0;
        int [] currencyDenominationArray = new int[s1];
        while (i!=s1) {
            currencyDenominationArray[i++]=scan.nextInt();
        }

        QuickSortDescending qs = new QuickSortDescending();
        sortedCurrDenoms = qs.getSortedArray(currencyDenominationArray, "DSC");

        System.out.println(Arrays.toString(sortedCurrDenoms));

        System.out.println("Enter the amount");
        netAmount= scan.nextInt();

       // implementPaymentMinCount();
        //for (int currency : getSortedCurrDenoms()  ) {
            if (cashBack != 0) {
                for (int k = 0; k < getSortedCurrDenoms().length; k++) {
                    int currentCurrency =getSortedCurrDenoms()[k];
                    if (cashBack==-1){
                        implementPayment(currentCurrency);
                    } else {
                        System.out.println("inside cashback "+cashBack+"current currency"+currentCurrency);

                        if (cashBack >= currentCurrency && currentCurrency != 0) {
                            if (cashBack % currentCurrency == 0) {
                                implementPayment(currentCurrency);
                            }
                        } else {
                            System.out.println("The netamount could not be SATISFIED");
                        }
                    }
                }

            }
        //}


    }

    /*
    private boolean implementPaymentMinCount() {
        boolean flag=false;
        int max= getSortedCurrDenoms()[0];
        outputArray = new ArrayList<>();
        int cashBack=0;

        if (getNetAmount()==max) {
            outputArray.add(max);
            outputArray.add(1);
            flag= true;

            //can return output array or flag here
        }

        int size = getSortedCurrDenoms().length;
        if (size==1) {
            if (getNetAmount() < sortedCurrDenoms[0]){
                flag = false;//the net amount could not be met
                outputArray.add(sortedCurrDenoms[0]);
                outputArray.add(1);
                cashBack = sortedCurrDenoms[0]-getNetAmount();

            } else {

                //adding the denominations to amount to the particular net Amount here
                int addedCurrency=sortedCurrDenoms[0];
                int times=1;
                do{
                    times++;
                    addedCurrency+=addedCurrency;
                }while(getNetAmount()>=addedCurrency);
                if (getNetAmount()==addedCurrency){
                    flag = true;
                    cashBack=0;
                    outputArray.add(sortedCurrDenoms[0]);
                    outputArray.add(times);
                }else{
                    flag = false;
                    cashBack=addedCurrency-getNetAmount();
                    outputArray.add(sortedCurrDenoms[0]);
                    outputArray.add(times-1);
                }
                System.out.println("addedCurr::"+addedCurrency+""+"times added ::"+times);
            }
        }
        if (!flag)
            System.out.println("THE DENOMINATIONS could not be matched");
        System.out.println(outputArray.toString());
        System.out.println("The amount back after payment::"+cashBack);
    return flag;
    }
*/

    /**
     * payment is done with the minimum count
     * recursive
     */

    private void implementPayment(int currencyDenomination) {
        //boolean flag=false;
       // int max= currencyDenomination;
        int cashBack=0;

        /*
        if (getNetAmount()==max) {
            outputArray.add(max);
            outputArray.add(1);
            flag= true;

            //can return output array or flag here
        }
*/
        //int size = getSortedCurrDenoms().length;
        //if (size==1) {

        ArrayList<Integer> maybeOutputArr = new ArrayList<>();
            if (getNetAmount()==currencyDenomination) {
                outputArray.add(currencyDenomination);
                outputArray.add(1);
                flag= true;
                //can return output array or flag here
            } else if (getNetAmount() < currencyDenomination){
                flag = false;//the net amount could not be met
                maybeOutputArr.add(currencyDenomination);
                maybeOutputArr.add(1);
                cashBack = currencyDenomination-getNetAmount();
            } else {
                //adding the denominations to amount to the particular net Amount here
                int addedCurrency=currencyDenomination;
                int times=1;
                System.out.println("the net amount is more than denom to adding the denom to get the netamount");
                System.out.println("addedCurrency"+addedCurrency+"getNetAmount()"+getNetAmount());
                while(getNetAmount()>addedCurrency) {
                    times++;
                    addedCurrency=addedCurrency+currencyDenomination;
                }
                if (getNetAmount()==addedCurrency){
                    System.out.println("the notes added and matched the netamt added currency"+addedCurrency+"net amunt"+getNetAmount());
                    flag = true;
                    cashBack=0;
                    outputArray.add(currencyDenomination);
                    outputArray.add(times);
                }else{
                    flag = false;
                    addedCurrency=addedCurrency-currencyDenomination;//go back one note
                    cashBack=getNetAmount()-addedCurrency;
                    maybeOutputArr.add(currencyDenomination);
                    maybeOutputArr.add(times-1);



                }
                System.out.println("addedCurr::"+addedCurrency+""+"times added ::"+times);
            }
        //}
        if (!flag)
            System.out.println("THE DENOMINATIONS could not be matched");

        if (outputArray.size()!=0) {
            System.out.println(outputArray.toString());
        }
        if (maybeOutputArr.size()!=0) {
            System.out.println("may be array is::");
            System.out.println(maybeOutputArr.toString());
            System.out.println("The amount back after payment::" + cashBack);
        }

        if (cashBack!=0) {
            setNetAmount(cashBack);
        }
    }

    /*
    void getCurrentCDenomNumber(int currencyDenomination){

        if (getNetAmount()==currencyDenomination) {
            outputArray.add(currencyDenomination);
            outputArray.add(1);
            flag= true;
            //can return output array or flag here
        }else if (getNetAmount() < currencyDenomination){
            flag = false;//the net amount could not be met
            outputArray.add(currencyDenomination);
            outputArray.add(1);
            cashBack = currencyDenomination-getNetAmount();
        }
    }
*/

    public int getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(int netAmount) {
        this.netAmount = netAmount;
    }

    public int[] getSortedCurrDenoms() {
        return sortedCurrDenoms;
    }

    public void setSortedCurrDenoms(int[] sortedCurrDenoms) {
        this.sortedCurrDenoms = sortedCurrDenoms;
    }

}

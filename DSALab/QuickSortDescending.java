/**
 * Write a program to implement the quick sort where
 *
 *     Ask the user to input the number of values in an array.
 *     Create an array accordingly and insert the values
 *     Implement the quick sort
 *     Print the array after every iteration
 */

package AssignmentFOP1.DSALab;

import java.util.Arrays;

public class QuickSortDescending {

    public static void main(String[] args) {
        QuickSortDescending quickSort = new QuickSortDescending();
        quickSort.implementationOfQuickSort();
    }
    public void implementationOfQuickSort() {
        int[] array= {12,11,14,13};
        int size =array.length;

        if(checkForStatus(array))
            System.out.println("The array already Sorted");
        else {
            System.out.println("BEfore Sort::");
            printValues(array);
            quickSort(array, 0, size - 1,"DSC");
        }
        System.out.println("The array now is::");
        printValues(array);
    }

    public void quickSort(int array[], int left, int right, String sortingType) {
        if (left < right) {
            int piv=0;
            if (sortingType.equals("ASC")) {
                piv = partition(array, left, right);
            }else if (sortingType.equals("DSC")) {
                piv = partitionDesc(array, left, right);
            }
            System.out.println(Arrays.toString(array));
            quickSort(array, left, piv - 1,sortingType);
            quickSort(array, piv + 1, right, sortingType);
        }
    }

    public int partition(int array[], int low, int high) {
        int pivot = array[high];
        int i=low-1;
        for (int j = low; j < high; j++) {
            if (array[j]<pivot){
                i++;//called now because i is not 0 for 1st element
                swap(array,i,j);
            }
        }
        swap(array,i+1,high);
        return (i+1);
    }

    public int partitionDesc(int array[], int low, int high) {
        int pivot = array[high];
        int i=low-1;
        for (int j = low; j < high; j++) {
            if (array[j]>pivot){
                i++;//called now because i is not 0 for 1st element
                swap(array,i,j);
            }
        }
        swap(array,i+1,high);
        return (i+1);
    }
    /**
     * swap the elements given the two indices
     * @param arr - array in whhich to be swapped
     * @param i - index1
     * @param j - index2
     */
    public void swap(int[] arr,int i, int j) {
        if ((arr.length>i) &&(i>-1) && (arr.length>j)&&( j >-1)){
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
    }

    /**
     * print the values of the Array
     * @param arr :array to be printed
     */
    public void printValues(int[] arr) {
        for(int item:arr) {
            System.out.print(item + " ");
        }
        System.out.println(" ");
    }


    public int[] getSortedArray(int[] arr, String sortingType) {
        if(checkForStatus(arr,sortingType))
        System.out.println("The array already Sorted");
        else {
            System.out.println("BEfore Sort::");
            printValues(arr);
            if (sortingType.equals("ASC")) {
                quickSort(arr, 0, arr.length - 1,sortingType);
            } else if (sortingType.equals("DSC")) {
                quickSort(arr, 0, arr.length - 1, sortingType);
            }
            System.out.println("After Sort::");
            printValues(arr);
        }
        return arr;

    }

    /**
     * Checks for  status of the array, if already been sorted
     * @returns true if all sorted
     * @returns false if not sorted
     */
    public static boolean checkForStatus(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size-1; i++) {
            if (arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }

    /**
     * Checks for  status of the array, if already been sorted
     * @returns true if all sorted
     * @returns false if not sorted
     */
    public static boolean checkForStatus(int[] arr, String sortingType) {

        if (sortingType.equals("ASC")) {
            int size = arr.length;
            for (int i = 0; i < size-1; i++) {
                if (arr[i]>arr[i+1]){
                    return false;
                }
            }
            return true;
        } else if (sortingType.equals("DSC")) {
            int size = arr.length;
            for (int i = 0; i < size-1; i++) {
                if (arr[i]<arr[i+1]){
                    return false;
                }
            }
            return true;
        }

        return false;
    }
}

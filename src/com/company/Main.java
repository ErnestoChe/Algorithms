package com.company;

public class Main {

    public static void main(String[] args) {
        /*int[] a = {9,1,5,2,8,3,0,10,7,5};
        //SortLevel.SelectionSortStep(a, 3);
        boolean b = false;
        while(!b){
            b = SortLevel.BubbleSortStep(a);
        }
        System.out.println();*/


        int[] arr =  {7,6,5,4,3,2,1};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        SortLevel.InsertionSortStep(arr, 3, 0);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();


        int[]arr2 = {1,6,5,4,3,2,7};
        SortLevel.InsertionSortStep(arr2, 3, 1);
        System.out.println();

    }


}

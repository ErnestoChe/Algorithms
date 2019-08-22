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
        //print(arr);
        SortLevel.InsertionSortStep(arr, 3, 0);
        //print(arr);
        SortLevel.InsertionSortStep(arr, 3, 1);
        //print(arr);
        SortLevel.InsertionSortStep(arr, 3, 2);
        //print(arr);
        SortLevel.InsertionSortStep(arr, 3, 3);
        //print(arr);
        System.out.println();

        int[]arr2 = {1,6,5,4,3,2,7};
        //print(arr2);
        SortLevel.InsertionSortStep(arr2, 3, 1);
        //print(arr2);

        System.out.println(SortLevel.KnuthSequence(4));

        int[]arr3 = {1,3,4,6,5,2,8,7,9,10,15,21,56,0,16};
        print(arr3);
        SortLevel.ShellSort(arr3);
        print(arr3);

    }
    public static void print(int[] a)
    {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}

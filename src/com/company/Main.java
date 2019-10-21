package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //testChunk();
        //testQuick();
        //test();
        //testOrder();
        //testMerge();
        //testMergeSort();
        testKSORT();
    }

    public static void testKSORT(){
        String test = "ff9";

        System.out.println(ksort.checkFormat(test));
        System.out.println(ksort.index(test));
    }

    public static void testChunk()
    {
        Random rnd = new Random();
        int[]arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = rnd.nextInt(100);
        }
        print(arr, 5, 15);
        int n = SortLevel.ArrayChunk(arr, 0, 19);
        System.out.println("n = " + n + " [n] = " + arr[n]);
        System.out.println("first chunk");
        print(arr);

    }

    public static void test()
    {
        int[] arr = new int[20];
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            if(i<10) arr[i] = r.nextInt(100)+100;
            if(i>=10) arr[i] = r.nextInt(100);
        }
        print(arr);
        int a = SortLevel.ArrayChunk(arr,0,19);
        System.out.println(a);
        System.out.println("[n] = " + arr[a]);
        print(arr);
    }
    public static void testQuick()
    {
        int mistakes = 0;
        for (int j = 0; j < 1000; j++) {
            System.out.println(j);
            int localmist = 0;
            int[]arr3 = init(20, 10000);
            if(isOccur(arr3))continue;
            print(arr3);
            //SortLevel.QuickSortTailOptimization(arr3, 0, arr3.length-1);
            SortLevel.QuickSort(arr3, 0, arr3.length-1);
            print(arr3);

            for (int i =0;i<arr3.length-1;i++){
                if (arr3[i] > arr3[i+1]) {
                    System.out.println("wrong");
                    mistakes++;
                    localmist++;
                    System.out.println(i);
                }
            }
            System.out.println(localmist);
        }
        System.out.println("mist " + mistakes);

    }

    public static void testMergeSort()
    {
        int[] arr = {781,603,794,729,705,930,360,796,747,747,73,481,248,736,753,113,884,580,438};
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list1.add(arr[i]);
        }
        System.out.println(list1);
        ArrayList<Integer> sorted = SortLevel.MergeSort(list1);
        System.out.println(sorted);
    }

    public static void testMerge()
    {
        /*int[] arr1 = {0,1,2,3,4};
        int[] arr2 = {5,6,7,8,9};
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list1.add(arr1[i]);
            list2.add(arr2[i]);
        }
        ArrayList<Integer> test = SortLevel.merge(list1, list2);
        System.out.println(test);*/

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(603);
        list1.add(781);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(729);
        list2.add(794);
        System.out.println(list1);
        System.out.println(list2);

        ArrayList<Integer> test = SortLevel.merge(list1, list2);
        System.out.println(test);
        System.out.println(test.size());
        //ArrayList<Integer> test = SortLevel.MergeSort(list1);
        //System.out.println(test);

    }

    public static void print(int[] a)
    {
        for (int i = 0; i < a.length; i++) {
            if(i == a.length-1)System.out.print(a[i]);else
            System.out.print(a[i] + ",");
        }
        System.out.println();
    }

    public static void print(int[] a, int i1, int i2)
    {
        for (int i = 0; i < a.length; i++) {
            if(i == i1) System.out.print("|" + a[i] + "\t");
            if(i == i2) System.out.print(a[i] + "|" + "\t");

            System.out.print(a[i] + "\t");
        }
        System.out.println();
    }

    public static void print(int[] a, int opor)
    {
        for (int i = 0; i < a.length; i++) {
            if(i == opor) System.out.print("<"+a[i] +">"+ "\t");
            else System.out.print(a[i] + "\t");
        }
        System.out.println();
    }

    public static int[] init(int size, int bound)
    {
        int[] arr = new int[size];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(bound);
        }
        return arr;
    }


    public static void testOrder(){
        int[] a = {5,6,7,4,1,2,3};
        ArrayList list = SortLevel.KthOrderStatisticsStep(a, 0,6,3);
        print(a);
        System.out.println(list);
        /*int arr[] = {781,603,794,729,705,930,360,796,773,747,73,481,248,736,753,113,884,580,438};
        print(arr);
        for (int i = 3; i < 8; i++) {
            int[]r = arr;
            ArrayList list = SortLevel.KthOrderStatisticsStep(r, 0, r.length-1, i);
            System.out.println(list);
        }
        SortLevel.QuickSort(arr, 0, arr.length-1);

        print(arr);*/
    }

    public static void print(String[] a)
    {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]+",");
        }
        System.out.println();
    }

    public static boolean isOccur(int[] arr)
    {
        for (int i =0; i<arr.length-1; i++){
            for (int j = i+1; j<arr.length; j++){
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}

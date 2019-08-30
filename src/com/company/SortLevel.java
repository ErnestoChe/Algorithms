package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class SortLevel {

    public static void SelectionSortStep( int array[], int i )
    {

        int min = i;
        for (int j = i; j<array.length; j++){
            if(array[min]>array[j]){
                min = j;
            }
        }
        //swap
        int tmp = array[i];
        array[i] = array[min];
        array[min] = tmp;
    }

    static boolean BubbleSortStep( int array[] )
    {

        int tmp;
        boolean check = true;
        for (int i = 0; i < array.length-1; i++) {
            if(array[i]>array[i+1]){

                tmp = array[i];
                array[i] = array[i+1];
                array[i+1] = tmp;
                check = false;
            }
        }
        return check;
    }

    static void InsertionSortStep( int[] array, int step, int i )
    {
        int tmp;
        for(int j = i; j<array.length; j = j+step){
            for (int k = j; k<array.length; k = k+step){
                if(array[j] > array[k]){
                    tmp = array[j];
                    array[j] = array[k];
                    array[k] = tmp;
                }
            }
        }
    }
    public static ArrayList KnuthSequence(int array_size )
    {
        ArrayList list = new ArrayList();
        int i = 0, tmp = 3 * i + 1;
        while(tmp <= array_size){
            i++;
            list.add(0,tmp);
            tmp = 3 * tmp + 1;
        }
        return list;
    }

    public static void ShellSort(int[] array)
    {
        ArrayList list = KnuthSequence(array.length);
        for (Object i : list) {
            for (int j = 0; j < (int) i; j++) {
                InsertionSortStep(array, (int) i, j);
            }
        }
    }

    public static int ArrayChunk( int[] M )
    {
        int N = M[M.length/2];
        while(true){
            int i1 = 0, i2 = M.length-1;
            while(M[i1]<N) i1++;
            while(M[i2]>N) i2--;
            if(i1 == i2 - 1 && M[i1]>M[i2]){
                int tmp = M[i1];
                M[i1] = M[i2];
                M[i2] = tmp;
                N = M[M.length/2];
                continue;
            }
            if(i1 == i2 || (i2 == i1 - 1 && M[i1]<M[i2])){
                int tmp = M[i1];
                M[i1] = M[i2];
                M[i2] = tmp;
                return i1;
            }
            int tmp = M[i1];
            M[i1] = M[i2];
            M[i2] = tmp;
        }

    }

    public static void QuickSort(int[]array, int left, int right)
    {
        if(left!=right){
            int N = ArrayChunk(array);
        }
    }
    public static void print(int[] a)
    {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("printed");
    }
}

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

    public static int ArrayChunk( int[] M, int left, int right)
    {
        int N = M[(left+right)/2];
        while(true){
            int i1 = left, i2 = right;
            while(M[i1]<N) i1++;
            while(M[i2]>N) i2--;
            if(i1 == i2 - 1 && M[i1]>M[i2]){
                int tmp = M[i1];
                M[i1] = M[i2];
                M[i2] = tmp;
                N = M[(left+right)/2];
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
            int N;
            if(left>right){return;}else{ N = ArrayChunk(array, left, right);}
            //int N = ArrayChunk(array, left, right);
            //print(array);
            QuickSort(array, left, N-1);
            QuickSort(array, N+1, right);
        }
    }

    public static void QuickSortTailOptimization( int[] array, int left, int right )
    {
        while(left<right){
            int N = ArrayChunk(array, left, right);
            if(N - left < right - N){
                QuickSortTailOptimization(array, left, N-1);
                left = N + 1;
            }else{
                QuickSortTailOptimization(array, N+1, right);
                right = N-1;
            }
        }
    }

    public static ArrayList KthOrderStatisticsStep(int[] Array, int L, int R, int k)
    {
        ArrayList list = new ArrayList();
        int N = ArrayChunk(Array, L, R);
        if(N == k){
            list.add(L);
            list.add(R);
            return list;
        }else
        if(N < k){
            L = N + 1;
        }else
        if(N > k){
            R = N - 1 ;
        }
        list.add(L);
        list.add(R);
        return list;
    }

    public static ArrayList<Integer>MergeSort(ArrayList<Integer> array)
    {
        if(array.size()<2){
            return array;
        }
        int mid = array.size()/2;
        ArrayList<Integer> left_list = new ArrayList<>();
        ArrayList<Integer> right_list = new ArrayList<>();

        for (int i = 0; i < mid; i++) {
            left_list.add(array.get(i));
        }
        System.out.println("left " + left_list);
        for (int i = mid; i < array.size(); i++) {
            right_list.add(array.get(i));
        }
        System.out.println("right " + right_list);

        left_list = MergeSort(left_list);
        right_list = MergeSort(right_list);

        array = merge(left_list, right_list);
        System.out.println("merged " + array);
        return array;
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2){
        ArrayList<Integer> res_list = new ArrayList<>();
        int pos1 = 0, pos2 = 0, l1 = list1.size(), l2 = list2.size();
        while(pos1 < l1 && pos2 < l2){
            if(list1.get(pos1) < list2.get(pos2)){
                res_list.add(list1.get(pos1));
                pos1++;
            }else{
                res_list.add(list2.get(pos2));
                pos2++;
            }
        }
        if(pos1 < l1){
            for (int i = pos1; i < list1.size(); i++) {
                res_list.add(list1.get(i));
            }
        }else if(pos2 < l2){
            for (int i = pos2; i < list2.size(); i++) {
                res_list.add(list2.get(i));
            }
        }
        return res_list;
    }

    public static void print(int[] a)
    {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("printed");
    }

}

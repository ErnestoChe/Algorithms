package com.company;

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
}

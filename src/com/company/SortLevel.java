package com.company;

public class SortLevel {

    public static void SelectionSortStep( int array[], int i ){

        int min = i;
        for (int j = i; j<array.length; j++){
            if(array[min]>array[j]){
                min = j;
            }
        }
        int tmp = array[i];
        array[i] = array[min];
        array[min] = tmp;
        //return null;
    }

    static boolean BubbleSortStep( int array[] ){

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
}

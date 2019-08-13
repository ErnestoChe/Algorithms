package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] a = {9,1,5,2,8,3,0,10,7,5};
        //SortLevel.SelectionSortStep(a, 3);
        boolean b = false;
        while(!b){
            b = SortLevel.BubbleSortStep(a);
        }
        System.out.println();
    }


}

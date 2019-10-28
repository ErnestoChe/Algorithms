package com.company;

public class BinarySearch {
    public int Left, Right;
    private int[] arr;
    boolean found;

    BinarySearch(int[] n) {
        Left = 0;
        Right = n.length - 1;
        arr = n;
        found = false;
    }

    public void Step(int N) {
        if (arr[(Left + Right) / 2] > N) {
            Right = (Left + Right) / 2;
        } else if (arr[(Left + Right) / 2] < N) {
            Left = (Left + Right + 1) / 2;
        } else if (arr[(Left + Right) / 2] == N) {
            found = true;
            Left = (Left + Right) / 2;
            Right = (Left + Right) / 2;
            return;
        }
    }

    public int GetResult(){
        if(Right == Left){
            if(found) return 1;
            else return -1;
        }else return 0;
    }

}

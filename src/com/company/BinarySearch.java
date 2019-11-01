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
        int mid = (Left + Right)/2;
        if(arr[mid] < N){
            Left = mid + 1;
        }else if(arr[mid] > N){
            Right = mid - 1;
        }
        if(arr[mid] == N){
            found = true;
            Left = Right = mid;
            return;
        }
        if(Left == Right){
            if(arr[(Left + Right)/2] == N){
                found = true;
            }else found = false;
            return;
        }
        if(Left > arr.length - 1 || Right > arr.length - 1){
            found = false;
            Right = Left = arr.length -1;
            return;
        }
        if(Right < Left){
            found = false;
            Right = Left;
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

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

    public static boolean GallopingSearch(int[] n, int key){
        int i = 1;
        int index = (int)Math.pow(2, i) - 2 ;
        while (true){
            if(n[n.length-1] < key) return false;
            if(n[index] == key){
                return true;
            }else if(n[index] < key){
                i++;
                index = (int)Math.pow(2, i) - 2;
                if(index >= n.length-1){
                    index = n.length-1;
                }
            }else if(n[index] > key){
                //i++;
                BinarySearch bs = new BinarySearch(n);
                bs.Right = index;
                bs.Left = (int)Math.pow(2, i-1) - 1;
                while (bs.GetResult() == 0){
                    bs.Step(key);
                }
                if(bs.GetResult() == 1){
                    return true;
                }else if(bs.GetResult() == -1){
                    return false;
                }
            }
        }
    }

}

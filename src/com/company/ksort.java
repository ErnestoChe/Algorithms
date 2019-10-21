package com.company;

public class ksort {

    public String[] items;
    ksort(){
        items = new String[800];
    }

    public boolean add(String s)
    {
        int ind = index(s);
        if(ind == -1){
            return false;
        }else{
            items[ind] = s;
            return true;
        }
    }
    //todo make private
    public static int index(String s)
    {
        if(!checkFormat(s)){
            return -1;
        }else{
            int res = 0;
            res += Character.getNumericValue(s.charAt(1)) * 10 + Character.getNumericValue(s.charAt(2));

            char letter = s.charAt(0);

            //a b c d e f g h
            switch (letter) {
                case ('b'):
                    res += 100;
                    break;
                case ('c'):
                    res += 200;
                    break;
                case ('d'):
                    res += 300;
                    break;
                case ('e'):
                    res += 400;
                    break;
                case ('f'):
                    res += 500;
                    break;
                case ('g'):
                    res += 600;
                    break;
                case ('h'):
                    res += 700;
                    break;
            }
            return res;
        }
    }

    public static boolean checkFormat(String s)
    {
        if(s.length()!= 3) return false;
        if(s.charAt(0) < 'a' || s.charAt(0) > 'h') return false;
        if(s.charAt(1) < '0' || s.charAt(1) > '9') return false;
        if(s.charAt(2) < '0' || s.charAt(2) > '9') return false;
        return true;
    }
}

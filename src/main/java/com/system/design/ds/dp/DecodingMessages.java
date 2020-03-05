package com.system.design.ds.dp;

public class DecodingMessages {
    public static void main(String[] args) {
        String str = "10";
        int n = str.length();
        System.out.println(fun(str,n,0));
    }

    private static int fun(String str, int n, int c) {
        if( n == 0  ){
            return 1;
        }
        if( Integer.parseInt(str.substring(0,1)) == 0){
            return 0;
        }
        if( n == 1){
            return 1;
        }
        if( c == n ){
            return 1;
        }
        int l = 0;
        if( c  < n  && Integer.parseInt(str.substring(c,c+1)) > 0){
            l = fun(str,n , c+1);
        }
        int r = 0;
        if( c + 1 < n && (Integer.parseInt(str.substring(c,c+1)) == 1 || (Integer.parseInt(str.substring(c,c+1)) == 2
                &&  Integer.parseInt(str.substring(c+1,c+2)) < 7  ))){
            r = fun(str,n,c+2);
        }
        return l + r;
    }
}

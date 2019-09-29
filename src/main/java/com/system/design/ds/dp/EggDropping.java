package com.system.design.ds.dp;

public class EggDropping {
    public static void main(String[] args) {
        int n = 2; // no of eggs
        int k = 27; // no. of floors
        System.out.println(minNumberOfSteps(n, k));
    }
    private static int dp( int n , int k ){
        int[][] dp = new int [n+1][k+1];

        for(int i=0;i<=n;i++){
            for( int j=0;j<=k;j++){
                dp[i][j] = Integer.MAX_VALUE;
                if( i == 0 || j ==0 ){
                    dp[i][j] =0;
                }else if ( i ==1 ){
                    dp[i][j] = j;
                }else{

                }
            }
        }

        return 0;
    }
    private static int minNumberOfSteps(int n, int k) {
        if (k == 0 || k == 1) {
            return k;
        }
        if (n == 1) {
            return k;
        }
        int result = Integer.MAX_VALUE;
        int current = 0;
        for (int i = 1; i <= k; i++) {
            current = Math.max( minNumberOfSteps(n-1,i-1),
                    minNumberOfSteps(n,k-i));
            if( current < result){
                result = current;
            }
        }
        return current;
    }
}

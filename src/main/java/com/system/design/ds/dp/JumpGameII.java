package com.system.design.ds.dp;

//https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
public class JumpGameII {
    public static void main(String[] args) {
        int arr[] = {1, 3, 6, 1, 0, 9};
//        int[] arr = {2, 3, 1, 1, 4};
        System.out.println(minNumberOfJumps(arr, arr.length - 1));
    }

    private static int minNumberOfJumps(int[] arr, int length) {
        if( arr[0] == 0 ){
            return -1;
        }
        int[] dp = new int[arr.length];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            int current = 0;
            for (int j = 0; j < i; j++) {
                if( dp[j] != Integer.MAX_VALUE && arr[ j ] >= i - j ){
                    current = dp[j] + 1 ;
                    if( current < dp[i]){
                        dp[i] = current;
                    }
                }
            }
        }
        return dp[dp.length - 1];
    }
}

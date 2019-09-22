package com.system.design.systemdesign.array;

public class FindMaximum {
    public static void main(String[] args) {
        int arr[] = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = arr[0];
        right[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++) {
            left[i] = Math.min(left[i - 1], arr[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], arr[i]);
        }

        int i =0;
        int j=n-1;
        int result = Integer.MIN_VALUE;
        while( i < n && j > 0 ){
            if( left[i] < right[i]){
                result = Math.max(result,j-i);
                j--;
            }else{
                i++;
            }
        }
        System.out.println(result);
    }
}

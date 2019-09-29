package com.system.design.ds.array;

import java.util.HashSet;

public class TripletWithSumZero {
    public static void main(String[] args) {
        int arr[] = {0, -1, 2, -3, 1};
        int n = arr.length;
        findTriplets(arr, n);
    }

    private static void findTriplets(int[] arr, int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        for( int i=0;i<n-1;i++){
            for( int j=i+1;j<n;j++){
                int x = -( arr[i]+arr[j]);
                if( hashSet.contains(x)){
                    System.out.println(arr[i]);
                    System.out.println(arr[j]);
                    System.out.println(x);
                }else{
                    hashSet.add(arr[i]);
                }
            }
        }
    }

}

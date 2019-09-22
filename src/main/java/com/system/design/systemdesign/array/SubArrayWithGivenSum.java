package com.system.design.systemdesign.array;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int arr[] = {10, 2, -2, -20, 10};
        int start = 0;
        int end =0;
        int sum = -10;
        int curr =arr[0];
        for( int i =1;i<arr.length;i++){
            curr += arr[i];
            end ++;
            if( curr  <= 0){
                curr=0;
                start = i+1;
                end = i;
            }else if ( curr > sum ){
                while( start <= end && curr > sum && curr != sum ){
                    curr -= arr[start];
                    start++;
                }
            }
            if( curr == sum ){
                System.out.println(start);
                System.out.println(end);
                return;
            }
        }
    }
}

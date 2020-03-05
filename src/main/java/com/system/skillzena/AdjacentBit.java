package com.system.skillzena;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AdjacentBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] arr = new int[m][n];
            Queue<Integer> q = new LinkedList<>();
            for( int j = 0 ;j < m;j++){
                for( int k =0;k < n;k++){
                    arr[j][k] = sc.nextInt();
                }
            }
            boolean flag = true;

            for( int j =1;j<n;j++){
                if(arr[0][j] == arr[0][j-1]){
                    flag = false;
                    break;
                }
            }
            for( int j =1;j<m;j++){
                if(arr[j][0] == arr[j-1][0]){
                    flag = false;
                    break;
                }
            }
            for( int j =1;j<m;j++){
                int sum =0;
                for( int k =1;k<n;k++){
                    if( arr[j][k] == arr[j][k-1] || arr[j][k] == arr[j-1][k] ){
                        flag = false;
                        break;
                    }
                }
            }
            if( flag){
                System.out.println("1");
            }else{
                System.out.println("0");
            }
        }
    }
    static void fun(int[][] mat , int r , int c, int m , int n ){
        if( r < 0 || r > m || c < 0 || c > n  ) {
            return;
        }
    }
}

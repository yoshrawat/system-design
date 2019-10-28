package com.system.design.ds.array;

public class SlidingWindow {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1, 1};
        int m = 2;
        int count = 0;
        int l = 0;
        int r = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;
        while (j < arr.length && r < arr.length) {
            if (arr[j] == 1) {
                r++;
                j++;
            } else if (arr[j] == 0 && count < m) {
                r++;
                count++;
                j++;
            } else {
                while (arr[l] != 0) {
                    l++;
                }
                l++;
                count--;
            }
            if (r - l + 1 > max) {
                System.out.println(r +"::"+l+"::"+j);
                max = r - l +1;
            }
        }
        System.out.println(max-1);
    }
}

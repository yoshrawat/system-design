package com.system.design.ds.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 1, 2, 2, 3};
        int k = 3;
        int m = 5;
        System.out.println(Arrays.toString(solutions(arr, k, m)));
    }

    private static int[] solutions(int[] arr, int k, int m) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i <= arr.length - k; i++) {
            int[] result = new int[arr.length];

            result = Arrays.copyOf(arr, arr.length);
            for (int j = i; j < i + k; j++) {
                result[j] = result[j]+1;
            }
            int most = mostFrequent(result,result.length);
            set.add(most);
        }
        int i =0;
        int[] test = new int[set.size()];
        for( Integer a : set){
            if( a != 0)
                test[i] = a;
            i++;
        }
        return test;
    }

    static int mostFrequent(int arr[], int n) {

        // Insert all elements in hash
        Map<Integer, Integer> hp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int key = arr[i];
            if (hp.containsKey(key)) {
                int freq = hp.get(key);
                freq++;
                hp.put(key, freq);
            } else {
                hp.put(key, 1);
            }
        }

        // find max frequency.
        int max_count = 0, res = -1;

        for (Map.Entry<Integer, Integer> val : hp.entrySet()) {
            if (max_count < val.getValue()) {
                res = val.getKey();
                max_count = val.getValue();
            }
        }

        return res;
    }
}

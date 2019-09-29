package com.system.design.ds.stack;

import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int price[] = {10, 4, 5, 90, 120, 80};
        int n = price.length;
        int S[] = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 1; i < n; i++) {

            while (!st.isEmpty() && price[st.peek()] < price[i]){
                st.pop();
            }
            S[i] = (!st.isEmpty()) ? (i - st.peek()) : i+1;
            st.push(i);
        }

        for (int i : S) {
            System.out.println(i);
        }
    }
}

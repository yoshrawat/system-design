package com.system.design.ds.dp;

public class RodCutting {
    public static void main(String[] args) {

    }
    public static int rodCutting(int[] prices, int value ){
        if( value <= 0  ){
            return 0;
        }
        int [] result = new int [prices.length];
        prices[0] =0;
        for( int i=1;i<prices.length;i++){
            result[i] = Integer.MIN_VALUE;
            for( int j=0;j<i;j++){
                result[i] = Math.max(result[i] , result[j] + prices[i - j -1 ]);
            }
        }
        return result[prices.length-1];
    }
}

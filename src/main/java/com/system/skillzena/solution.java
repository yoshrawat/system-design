package com.system.skillzena;

import java.util.Scanner;

public class solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int n = 0; n < t; n++) {
            int len = sc.nextInt();
            String str = sc.next();
            //System.out.println(str);
            System.out.println(sequence(str, len));
        }

    }

    private static int sequence(String str, int len) {
        String first = str.replace("r", "0").
                replace("g", "1").replace("b", "2");
        //System.out.println(first);
        int count = 0;
        for (int i = 0; i < first.length() - 1; i++) {
            int current = 1;
            for (int j = i+1; j < first.length(); j++) {
                if( (first.charAt(j-1) + 1) % 3  == first.charAt(j) % 3){
                    current++;
                }else{
                    break;
                }
                if( current >=3){
                    count++;
                }
            }
        }
        return count;
    }
}

package com.system.design.systemdesign.array;

import java.util.LinkedList;
import java.util.Queue;

public class JumpingNumber {
    public static void main(String[] args) {
        int num = 99;

        Queue<Integer> queue = new LinkedList<>();
        int i = 1;
        int result = 1;
        while (i < 10) {
            queue.add(i);
            i++;
        }
        while (!queue.isEmpty() && queue.peek()<= num) {
            result++;
            int test = queue.poll();
            int lastDigit = test%10;
            if( lastDigit == 9 ){
                queue.add((test*10)+(lastDigit-1));
            }else if ( lastDigit == 0){
                queue.add((test*10)+(lastDigit+1));
            }else{
                queue.add((test*10)+(lastDigit-1));
                queue.add((test*10)+(lastDigit+1));
            }
        }
        System.out.println(result);
    }
}

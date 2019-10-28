package com.system.design.ds.stack;

import java.util.Stack;

public class EvaluatePostfix {
    public static void main(String[] args) {
        String str = "231*+9-";
        Stack<Integer> stack = new Stack<>();
        for( int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if( Character.isDigit(ch)){
                stack.push(ch - '0');
            }else{
                int a = stack.pop();
                int b = stack.pop();
                switch (ch){
                    case '+':
                        stack.push(a+b);
                        break;
                    case '-':
                        stack.push(b-a);
                        break;
                    case '/':
                        stack.push(b/a);
                        break;
                    case '*':
                        stack.push(a*b);
                        break;
                }
            }
        }
        System.out.println(stack.peek());
    }
}

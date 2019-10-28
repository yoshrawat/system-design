package com.system.design.ds.stack;

import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeSet;

public class InfixToPostFix {
    public static void main(String[] args) {
        String str = "a+b*(c^d-e)^(f+g*h)-i";
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isAlphabetic(ch)) {
                result.append(ch);
            } else {
                if (ch == '(') {
                    stack.push(ch);
                } else if (ch == ')') {
                    while ( !stack.isEmpty() && stack.peek() != '('){
                        result.append(stack.pop());
                    }
                    stack.pop();
                }else {
                    while (!stack.isEmpty() && precedenceCheck(stack.peek()) > precedenceCheck(ch)){
                        result.append(stack.pop());
                    }
                    stack.push(ch);
                }
            }
        }
        System.out.println(result);
    }
    private static int precedenceCheck( char ch){
        switch (ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}

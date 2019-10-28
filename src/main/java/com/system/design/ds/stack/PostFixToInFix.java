package com.system.design.ds.stack;

import java.util.Stack;

public class PostFixToInFix {
    public static void main(String[] args) {
        String str = "AB+CD+*";
        Stack<String> stack = new Stack<>();
        StringBuilder stringBuffer = new StringBuilder();
        for( int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if( Character.isAlphabetic(ch)){
                stack.push(ch+"");
            }else{
                String a = stack.pop();
                String b = stack.pop();
                switch (ch){
                    case '+':
                        stack.push(b+"+"+a);
                        break;
                    case '-':
                        stack.push(b+"-"+a);
                        break;
                    case '/':
                        stack.push(b+"/"+a);
                        break;
                    case '*':
                        stack.push(b+"*"+a);
                        break;
                }
            }
        }
        System.out.println(stack.peek());
    }
}

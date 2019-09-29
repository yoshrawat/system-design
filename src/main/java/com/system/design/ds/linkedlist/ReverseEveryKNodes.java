package com.system.design.ds.linkedlist;

import java.util.Stack;

public class ReverseEveryKNodes {
    static class Node
    {
        int data;
        Node next;
    }
    static Node head = null;
    static void push( int new_data)
    {
        /* allocate node */
        Node new_node = new Node();

        /* put in the data */
        new_node.data = new_data;

        /* link the old list off the new node */
        new_node.next = head;

        /* move the head to point to the new node */
        head = new_node;
    }

    /* Function to print linked list */
    static void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    public static void main(String[] args) {
        push( 9);
        push( 8);
        push( 7);
        push( 6);
        push( 5);
        push(4);
        push(3);
        push(2);
        push( 1);

        System.out.println("Given linked list ");
        printList(head);
        //head = Reverse(head, 3);
        head = usingStack(head,3);
        System.out.println();

        System.out.println("Reversed Linked list ");
        printList(head);
    }
    private static Node usingStack(Node head , int i ){
        Stack<Node> stack = new Stack<>();
        Node temp = head;
        Node result = null;
        Node finalResult = null;
        while ( temp != null){
            int count =1;
            while (count <= i ){
                stack.push(temp);
                temp = temp.next;
                count++;
            }
            while (!stack.isEmpty()){
                if( result == null){
                    result = stack.pop();
                    finalResult = result;
                }else {
                    result.next = stack.pop();
                    result = result.next;
                }
            }
        }
        result.next = null;
        return finalResult;
    }
    private static Node Reverse(Node head, int i) {
        Node temp = head;
        Node prev = null;
        Node curr = temp;
        Node next = null;
        int count = 1;
        while ( count <= i ){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if( null != next){
            head.next = Reverse(next,i);
        }
        return prev;
    }
}

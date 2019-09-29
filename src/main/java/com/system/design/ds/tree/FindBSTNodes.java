package com.system.design.ds.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindBSTNodes {
    /* Class containing left and right child
    of current node and key value*/
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;
    public int getCount(Node node, int low, int high){
        if( null == node){
            return 0;
        }
        if( node.data >= low && node.data <= high){
            return 1 + getCount(node.left,low,high) + getCount(node.right,low,high);
        }else{
            return getCount(node.left,low,high) + getCount(node.right,low,high);
        }
    }
    public static void main(String[] args) {
        FindBSTNodes tree = new FindBSTNodes();

        tree.root = new Node(10);
        tree.root.left     = new Node(5);
        tree.root.right     = new Node(50);
        tree.root.left.left = new Node(1);
        tree.root.right.left = new Node(40);
        tree.root.right.right = new Node(100);
        System.out.println(tree.getCount(tree.root,5,45));
    }
}

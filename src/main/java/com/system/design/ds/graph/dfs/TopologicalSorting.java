package com.system.design.ds.graph.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSorting {
    static class CustomGraph {
        int v;
        List[] nodes;

        public CustomGraph(int v) {
            this.v = v;
            this.nodes = new ArrayList[v];
            for (int i = 0; i < v; i++) {
                nodes[i] = new ArrayList<>();
            }
        }
    }

    private static CustomGraph graph;

    public void addEdge(int a, int b) {
        this.graph.nodes[a].add(b);
    }

    public static void topologicalSort(int v) {
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < graph.nodes.length; i++) {
            if (!visited[i]) {
                traverse( i , stack , visited);
                stack.push(i);
            }
        }
        //stack.forEach(System.out::println);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    private static void traverse(int v, Stack<Integer> stack, boolean[] visited) {
        visited[v] = true;
        List<Integer> arrayList = graph.nodes[v];
        for (int j = 0; j < arrayList.size(); j++) {
            if( !visited[arrayList.get(j)]){
                traverse( arrayList.get(j) , stack , visited);
                stack.push(arrayList.get(j));
            }
        }
    }

    public static void main(String[] args) {
        TopologicalSorting topologicalSorting = new TopologicalSorting();
        topologicalSorting.graph = new CustomGraph(6);
        topologicalSorting.addEdge(5, 2);
        topologicalSorting.addEdge(5, 0);
        topologicalSorting.addEdge(4, 0);
        topologicalSorting.addEdge(4, 1);
        topologicalSorting.addEdge(2, 3);
        topologicalSorting.addEdge(3, 1);
        topologicalSort(6);
    }
}

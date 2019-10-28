package com.system.design.ds.graph.dfs;

import java.util.ArrayList;
import java.util.Scanner;

class solution {
    private int v;
    private ArrayList<Integer>[] edge;

    public solution(int v) {
        this.v = v;
        edge = new ArrayList[v+1];
        for (int i = 0; i <= v; i++) {
            this.edge[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v) {
        this.edge[u].add(v);
    }

    public void DFS(int v) {
        boolean[] visited = new boolean[this.v];
    }

    private int max = Integer.MIN_VALUE;
    private int node = 0;

    private int DFSUtil(int v, boolean[] visited, int count) {
        ArrayList<Integer> linkedList = this.edge[v];
        if (linkedList.size() == 0) {
            return count;
        }
        visited[v] = true;
        for (Integer i : linkedList) {
            if (!visited[i]) {
                int ans = DFSUtil(i, visited, count + 1);
                if (ans > max) {
                    node = i;
                    max = ans;
                }
            }
        }
        return max;
    }

    void dfs(int node, ArrayList<Integer>[] adj, int[] dp,
             boolean[] visited, int[] dpNode) {
        // Mark as visited
        visited[node] = true;

        // Traverse for all its children
        for (int i = 0; i < adj[node].size(); i++) {

            // If not visited
            if (!visited[adj[node].get(i)])
                dfs(adj[node].get(i), adj, dp, visited, dpNode);

            // Store the max of the paths
            dp[node] = Math.max(dp[node], 1 + dp[adj[node].get(i)]);
            if( dp[node] < 1 + dp[adj[node].get(i)] ){
                max = adj[node].get(i);
            }
        }
    }

    // Function that returns the longest path
    int findLongestPath(int n) {
        ArrayList<Integer> adj[] = edge;
        // Dp array
        int[] dp = new int[v + 1];
        int[] dpNode = new int[v + 1];
        // Visited array to know if the node
        // has been visited previously or not
        boolean[] visited = new boolean[v + 1];

        // Call DFS for every unvisited vertex
        for (int i = 1; i <= v; i++) {
            if (!visited[i])
                dfs(i, adj, dp, visited,dpNode);
        }

        int ans = 0;
        int node=0;
        // Traverse and find the maximum of all dp[i]
        for (int i = 1; i <= v; i++) {
            System.out.println(dp[i]);
            if( ans < dp[i]){
                ans = dp[i];
                node = i;
            }
//            ans = Math.max(ans, dp[i]);
        }
        return node;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int v = scanner.nextInt();
            solution dimmestStar = new solution(v );
            for (int j = 0; j < v - 1; j++) {
                String str = scanner.next();
                String[] split = str.split(" ");
                //System.out.println(split[0]);
                str = scanner.next();
                String[] split1 = str.split(" ");
                //System.out.println(split1[0]);
                dimmestStar.addEdge(Integer.parseInt(split[0]), Integer.parseInt(split1[0]));
            }
            int dimmestStarNo = scanner.nextInt();
//            int ans = dimmestStar.findDimmestStar(dimmestStarNo);
            int ans = dimmestStar.findLongestPath(dimmestStarNo);
            //System.out.println(ans);
        }
    }

    private int findDimmestStar(int dimmestStarNo) {
        boolean[] visited = new boolean[this.v+1];
        visited[0] = true;
        int count = 0;
        for (int i = 1; i <= v; i++) {
            if (!visited[i])
                DFSUtil(dimmestStarNo, visited, count);
        }

        return node;
    }
}

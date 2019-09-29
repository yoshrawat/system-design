package com.system.design.ds.graph.dfs;

public class NumberOfIslands {

    public static void main(String[] args) {
        int M[][] = new int[][]{{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};
        System.out.println(totalIslands(M, M.length, M[0].length));
    }

    private static int[] row = {1, 1, 1, 0, 0, -1, -1, -1};
    private static int[] col = {-1, 0, 1, -1, 1, -1, 0, 1};

    private static int totalIslands(int[][] m, int length, int length1) {
        int result = 0;
        int[][] visited = new int[length][length1];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length1; j++) {
                visited[i][j] = 0;
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length1; j++) {
                if (m[i][j] == 1 && visited[i][j] == 0) {
                    DFS(m, i, j, visited,length,length1);
                    result++;
                }
            }
        }
        return result > 0 ? result : -1;
    }
    private static boolean isValidLocation(int[][] m, int r, int c, int[][] visited, int length, int length1){
        return r >= 0 && r < length && c >=0 && c < length1 && visited[r][c] == 0 && m[r][c] == 1;
    }
    public static void DFS(int[][] element, int i, int j, int[][] visited, int length, int length1) {
        visited[i][j] = 1;
        // traverse 8 neighbours elements
        for (int k = 0; k < row.length; k++) {
            if (isValidLocation(element,i + row[k],j + col[k],visited,length,length1)) {
                DFS(element, i + row[k], j + col[k], visited, length, length1);
            }
        }
    }
}

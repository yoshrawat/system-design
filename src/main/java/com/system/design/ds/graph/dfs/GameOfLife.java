package com.system.design.ds.graph.dfs;

//https://www.geeksforgeeks.org/program-for-conways-game-of-life/
//https://www.programcreek.com/2014/05/leetcode-game-of-life-java/
public class GameOfLife {
    public static void main(String[] args) {
        int M = 10, N = 10;

        // Intiliazing the grid.
        int[][] grid = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        print(grid);
        System.out.println();
        nextGeneration(grid, M, N);
        print(grid);
    }

    private static int[] validRows = {1, 1, 1, -1 - 1 - 1, 0, 0};
    private static int[] validCols = {-1, 0, 1, -1, 0, 1, -1, 1};

    private static void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void nextGeneration(int[][] grid, int m, int n) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    dfs(grid, i, j, visited);
                }
            }
        }
    }

    private static void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        int totalLiveCells = 0;
        for (int k = 0; k < validRows.length; k++) {
            if (checkNeighboursLivesCells(grid, i + validRows[k], j + validCols[k], visited)) {
                visited[i + validRows[k]][j + validCols[k]] = true;
                totalLiveCells++;
            }
        }
        totalLiveCells -= grid[i][j];
        if (grid[i][j] == 0 && totalLiveCells == 3) {
            grid[i][j] = 1;
        } else if (grid[i][j] == 1) {
            if (totalLiveCells > 3) {
                grid[i][j] = 0;
            } else if (totalLiveCells < 2) {
                grid[i][j] = 0;
            }
        }
    }

    private static boolean checkNeighboursLivesCells(int[][] grid, int i, int j, boolean[][] visited) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1 && !visited[i][j];
    }

}

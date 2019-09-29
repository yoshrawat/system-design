package com.system.design.ds.array;

public class LargestSubSquare {
    public static void main(String[] args) {
        int mat[][] = {
                {'X', 'O', 'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'O', 'O', 'X'},
                {'O', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'O', 'X', 'O'},
                {'O', 'O', 'X', 'O', 'O', 'O'}};
        System.out.println(findSubSquare(mat));
    }

    private static int findSubSquare(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        int[][] hor = new int[row][col];
        int[][] ver = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    hor[i][j] = 0;
                    ver[i][j] = 0;
                } else {
                    hor[i][j] = j == 0 ? 1 : hor[i][j - 1] + 1;
                    ver[i][j] = i == 0 ? 1 : ver[i - 1][j] + 1;
                }
            }
        }
        int max = 0;
        for (int i = row - 1; i >= 1; i--) {
            for (int j = col - 1; j >= 1; j--) {
                int small = Math.min(hor[i][j], ver[i][j]);
                while (small > max) {
                    if (ver[i - small + 1][j] >= small && hor[i][j - small + 1] >= small) {
                        max = small;
                    }
                    small--;
                }
            }
        }

        return max;
    }
}

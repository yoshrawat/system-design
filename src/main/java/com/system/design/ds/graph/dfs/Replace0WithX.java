package com.system.design.ds.graph.dfs;
//https://www.programcreek.com/2014/04/leetcode-surrounded-regions-java/
public class Replace0WithX {
    public static void main(String[] args) {
        char[][] mat = {
                {'X', 'O', 'X', 'O', 'X', 'X'},
                {'X', 'O', 'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'O', 'X', 'X'},
                {'O', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'O', 'X', 'O'},
                {'O', 'O', 'X', 'O', 'O', 'O'}
        };
        replaceSurrounded(mat);
        for (int i = 0; i < mat.length; i++)
        {
            for (int j = 0; j < mat[0].length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println("");
        }
    }

    static int[] validRows = {1, -1, 0, 0};
    static int[] validCols = {0, 0, -1, 1};

    private static void replaceSurrounded(char[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        // first and last row
        for (int i = 0; i < col; i++) {
            if (mat[0][i] == 'O') {
                merge(mat, 0, i);
            }

            if (mat[row - 1][i] == 'O') {
                merge(mat, row - 1, i);
            }
        }

        // first col and last col
        for (int i = 0; i < col; i++) {
            if (mat[i][0] == 'O') {
                merge(mat, i, 0);
            }

            if (mat[i][col - 1] == 'O') {
                merge(mat, i, col - 1);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if( mat[i][j] == 'O'){
                    mat[i][j] = 'X';
                }else if ( mat[i][j] == '#'){
                    mat[i][j] = 'O';
                }
            }
        }
    }

    private static void merge(char[][] mat, int i, int j) {
        mat[i][j] = '#';
        for (int k = 0; k < validCols.length; k++) {
            if (validNeighbours(i + validRows[k], j + validCols[k], mat)) {
                merge(mat,i + validRows[k],j + validCols[k]);
            }
        }
    }

    private static boolean validNeighbours(int i, int j, char[][] mat) {
        return i >= 0 && i < mat.length && j >= 0 && j < mat[0].length && mat[i][j] == 'O';
    }
}

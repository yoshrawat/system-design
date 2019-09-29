package com.system.design.ds.array;

public class Suduko {
    public static void main(String[] args) {
        int[][] arr = {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
        };
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(validSuduko(board));
    }

    private static boolean validSuduko(char[][] board) {
        // check for row
        for (int i = 0; i < board.length; i++) {
            boolean[] visited = new boolean[board.length];
            for (int j = 0; j < board[0].length; j++) {
                //System.out.println((board[i][j]) - '1');
                if (board[i][j] != '.' && visited[board[i][j] - '1']) {
                    return false;
                } else if (board[i][j] != '.') {
                    visited[board[i][j] - '1'] = true;
                }
            }
        }
        // check for column
        for (int i = 0; i < board.length; i++) {
            boolean[] visited = new boolean[board.length];
            for (int j = 0; j < board[0].length; j++) {
                if (board[j][i] != '.' && visited[board[j][i] - '1']) {
                    return false;
                } else if (board[j][i] != '.') {
                    visited[board[j][i] - '1'] = true;
                }
            }
        }
        // check for 3x3 matrix
        for (int block = 0; block < 9; block++) {
            boolean[] visited = new boolean[board.length];
            for (int row = block / 3 * 3; row < block / 3 * 3 + 3; row++) {
                for (int col = block % 3 * 3; col < block % 3 * 3 + 3; col++) {
                    if (board[row][col] != '.' && visited[board[row][col] - '1']) {
                        return false;
                    } else if (board[row][col] != '.') {
                        visited[board[row][col] - '1'] = true;
                    }
                }
            }
        }
        return true;
    }
}

package com.system.design.ds.graph.dfs;

public class WordSearch {
    public static void main(String[] args) {
        char[][] arr = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        };
        String search = "ABCB";
        System.out.println(searchWord(arr, search));
    }

    private static boolean searchWord(char[][] arr, String search) {
        int row = arr.length;
        int col = arr[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int current =0;
                if (visited[i][j] == false && search.charAt(0) == arr[i][j] && dfs(arr, i, j, search, visited,current) ) {
                    return true;
                }
            }
        }
        return false;
    }

    static int[] validRow = {1, -1, 0, 0};
    static int[] validCol = {0, 0, -1, 1};

    private static boolean dfs(char[][] arr, int i, int j, String search, boolean[][] visited, int current) {
        visited[i][j] = true;
        current++;
        if( search.length() == current){
            return true;
        }
        for (int k = 0; k < validRow.length; k++) {
            if( isValidLocation(arr,i+validRow[k],j+validCol[k],visited,search,current)){
                return dfs(arr,i+validRow[k],j+validCol[k],search,visited,current);
            }
        }
        return false;
    }

    private static boolean isValidLocation(char[][] arr, int i, int i1, boolean[][] visited, String search, int current) {
        return i >= 0 && i < visited.length && i1 >= 0 && i1 < visited[0].length && search.charAt(current) == arr[i][i1] && visited[i][i1]==false;
    }
}

package com.system.design.ds.dp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Cell{
    int x;
    int y;
    int data;
}
public class KnightWalk {
    public static void main(String[] args) {
        int N = 8;
        int[] start = {0,0};
        int[] end = {8,8};
        System.out.println(calculateDistance(start,end,N));
    }
    static int min = Integer.MAX_VALUE;
    private static int calculateDistance(int[] start, int[] end, int n) {
        boolean[][] visited = new boolean[n][n];
        dfs(start,end,n,visited);
        return min;
    }

    static int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static boolean isValid( int m , int n , boolean[][] visited, int size){
        return m >=0 && m < size && n >= 0 && n < size && !visited[m][n];
    }
    private static int  dfs(int[] start, int[] end, int n, boolean[][] visited) {
        //System.out.println(start[0] + "::"+start[1]);
        if( start[0] == end[0]-1 && start[1] == end[1]-1){
            return 1;
        }
        visited[start[0]][start[1] ] = true;
        int count =0;
        for( int i =0;i<8;i++){
            int newX = start[0] + dx[i];
            int newY = start[1] + dy[i];
            if( isValid(newX, newY,visited,n)){
                count++;
                count =+ dfs(new int[]{newX,newY},end,n,visited);

                if( count > 0 ){
                    System.out.println("count::"+count);
                    if( count < min){
                        min = count;
                    }
                }else {
                    count--;
                }

            }
        }
       // visited[start[0]][start[1] ] = false;
        return count;
    }
}

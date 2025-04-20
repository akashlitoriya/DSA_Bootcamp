package graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    class Pair{
        int row;
        int col;
        int dist;
        Pair(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dis[][] = new int[n][m];
        for(int rows[] : dis){
            Arrays.fill(rows, (int)1e9);
        }
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1;
        Queue<Pair> q = new LinkedList<>();
        dis[0][0] = 0;
        q.add(new Pair(0, 0, 0));
        while(!q.isEmpty()){
            Pair node = q.poll();
            for(int r = -1; r <= 1; r++){
                for(int c = -1; c <= 1; c++){
                    if(node.row + r >= 0 && node.row + r < n && node.col + c >= 0 && node.col + c < m){
                        if(grid[node.row + r][node.col + c] != 1 && dis[node.row + r][node.col + c] > node.dist + 1){
                            q.add(new Pair(node.row + r, node.col + c, node.dist + 1));
                            dis[node.row + r][node.col + c] = node.dist + 1;
                        }
                    }
                }
            }
        }

        if(dis[n-1][m-1] == (int)1e9){
            return -1;
        }
        return dis[n-1][m - 1] + 1;
    }
}

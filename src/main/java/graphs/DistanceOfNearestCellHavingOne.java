package graphs;

import java.util.Queue;
import java.util.LinkedList;

public class DistanceOfNearestCellHavingOne {
    public static void main(String[] args) {

    }
    class Pair{
        int row;
        int col;
        int level;
        Pair(int row, int col, int level){
            this.row = row;
            this.col = col;
            this.level = level;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int dis[][] = new int[n][m];
        boolean visited[][] = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        int row[] = {-1, 0, 1, 0};
        int col[] = {0, 1, 0, -1};
        while(!q.isEmpty()){
            Pair node = q.poll();
            for(int i = 0; i < 4; i++){
                if(node.row + row[i] >= 0 && node.row + row[i] < n && node.col + col[i] >= 0 && node.col + col[i] < m){
                    if(mat[node.row + row[i]][node.col + col[i]] == 1 && !visited[node.row + row[i]][node.col + col[i]]){
                        q.add(new Pair(node.row + row[i], node.col + col[i], node.level + 1));
                        visited[node.row + row[i]][node.col + col[i]] = true;
                    }
                }
            }
            dis[node.row][node.col] = node.level;
        }
        return dis;
    }
}

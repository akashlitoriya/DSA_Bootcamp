package graphs;

import java.util.Queue;
import java.util.LinkedList;
public class RottenOranges {
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
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                // UP -->
                Pair removed = q.poll();
                if(removed.row - 1 >= 0 && (grid[removed.row - 1][removed.col] == 1  && !visited[removed.row - 1][removed.col])){
                    q.add(new Pair(removed.row - 1, removed.col, removed.level + 1));
                    grid[removed.row - 1][removed.col] = 2;
                    visited[removed.row - 1][removed.col] = true;
                }
                //Down
                if(removed.row + 1 < n && (grid[removed.row + 1][removed.col] == 1 && !visited[removed.row + 1][removed.col])){
                    q.add(new Pair(removed.row + 1, removed.col, removed.level + 1));
                    grid[removed.row + 1][removed.col] = 2;
                    visited[removed.row + 1][removed.col] = true;
                }
                //LEFT
                if(removed.col - 1 >= 0 && (grid[removed.row][removed.col - 1] == 1 && !visited[removed.row][removed.col - 1])){
                    q.add(new Pair(removed.row, removed.col - 1, removed.level + 1));
                    grid[removed.row][removed.col - 1] = 2;
                    visited[removed.row][removed.col - 1] = true;
                }
                //RIGHT
                if(removed.col + 1 < m && (grid[removed.row][removed.col + 1] == 1 && !visited[removed.row][removed.col + 1])){
                    q.add(new Pair(removed.row, removed.col + 1, removed.level + 1));
                    grid[removed.row][removed.col + 1] = 2;
                    visited[removed.row][removed.col + 1] = true;
                }
                time = removed.level;
            }
        }

        //checking
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return time;
    }

}

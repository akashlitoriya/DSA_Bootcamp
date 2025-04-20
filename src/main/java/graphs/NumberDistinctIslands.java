package graphs;

import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
public class NumberDistinctIslands {
    class Pair{
        int row;
        int col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        Set<String> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    String s = getBFS(new Pair(i,j), grid, visited);
                    set.add(s);
                }
            }
        }
        return set.size();
    }
    String getBFS(Pair root, int[][] grid, boolean visited[][]){
        int n = grid.length;
        int m = grid[0].length;
        String bfs = "{(0,0)";
        Queue<Pair> q = new LinkedList<>();
        q.add(root);
        visited[root.row][root.col] = true;
        int rowVal[] = {-1, 0, 1, 0};
        int colVal[] = {0, 1, 0, -1};
        while(!q.isEmpty()){
            Pair node = q.poll();
            for(int i = 0; i < 4; i++){
                if(node.row + rowVal[i] >= 0 && node.row + rowVal[i] < n && node.col + colVal[i] >= 0 && node.col + colVal[i] < m){
                    if(grid[node.row + rowVal[i]][node.col + colVal[i]] == 1 && !visited[node.row + rowVal[i]][node.col + colVal[i]]){
                        q.add(new Pair(node.row + rowVal[i], node.col + colVal[i]));
                        visited[node.row + rowVal[i]][node.col + colVal[i]] = true;
                        int x = (node.row + rowVal[i]) - root.row;
                        int y =(node.col + colVal[i]) - root.col;
                        bfs += "(" + x + "," + y + ")";
                    }
                }
            }
        }
        bfs += '}';
        return bfs;
    }
}

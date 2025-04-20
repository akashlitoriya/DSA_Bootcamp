package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    static class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) {

    }
    private static int getNumberOfIslands(char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        boolean isVisited[][] = new boolean[n][m];
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && !isVisited[i][j]){
                    count++;
                    bfs(new Pair(i, j), grid, isVisited);
                }
            }
        }
        return count;
    }
    private static void bfs(Pair st, char[][] graph, boolean isVisited[][]){
        int n = graph.length;
        int m = graph[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(st);
        isVisited[st.row][st.col] = true;
        while(!q.isEmpty()){
            Pair node = q.poll();
            for(int i = -1; i <= 1; i++){
                for(int j = -1; j <= 1; j++){
                    if((node.row + i >= 0 && node.row + i < n) && (node.col + j >= 0 && node.col + j < m)){
                        if(graph[node.row + i][node.col + j] == '1' && !isVisited[node.row + i][node.col + j]){
                            isVisited[node.row + i][node.col + j] = true;
                            q.add(new Pair(node.row + i, node.col + j));
                        }
                    }
                }
            }
        }
    }
}

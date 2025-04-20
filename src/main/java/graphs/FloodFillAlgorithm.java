package graphs;
import java.util.*;
public class FloodFillAlgorithm {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        Pair p = new Pair(sr, sc);
        boolean isVisited[][] = new boolean[image.length][image[0].length];
        bfs(image, p, isVisited, newColor );
        return image;
    }
    private void bfs(int[][] graph, Pair st, boolean isVisited[][], int newColor){
        int n = graph.length;
        int m = graph[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(st);
        isVisited[st.row][st.col] = true;
        while(!q.isEmpty()){
            Pair node = q.peek();
            if(node.row - 1 >= 0 && ((graph[node.row - 1][node.col] == graph[node.row][node.col]) && !isVisited[node.row - 1][node.col])){
                isVisited[node.row - 1][node.col] = true;
                q.add(new Pair(node.row - 1, node.col));
            }
            if(node.row + 1 < n && ((graph[node.row + 1][node.col] == graph[node.row][node.col]) && !isVisited[node.row + 1][node.col])){
                isVisited[node.row + 1][node.col] = true;
                q.add(new Pair(node.row + 1, node.col));


            }
            if(node.col - 1 >= 0 && ((graph[node.row][node.col - 1] == graph[node.row][node.col]) && !isVisited[node.row][node.col - 1])){
                isVisited[node.row][node.col - 1] = true;
                q.add(new Pair(node.row, node.col - 1));
            }
            if(node.col + 1 < m && ((graph[node.row][node.col + 1] == graph[node.row][node.col]) && !isVisited[node.row][node.col + 1])){
                isVisited[node.row][node.col + 1] = true;
                q.add(new Pair(node.row, node.col + 1));
            }
            graph[node.row][node.col] = newColor;
            q.poll();
        }
    }
}

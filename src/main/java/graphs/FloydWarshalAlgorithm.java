package graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class FloydWarshalAlgorithm {
    public static void main(String[] args) {

    }
    static int floydWarshall(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        int cost[][] = new int[n + 1][n + 1];
        for(int rows[]: cost){
            Arrays.fill(rows, (int)1e9);
        }
        for(int i = 0; i < m; i++){
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            int wt = edges.get(i).get(2);
            cost[u][v] = wt;
        }
        //making diagonals zero
        for(int i = 1; i <= n; i++){
            cost[i][i] = 0;
        }

        //floyd warshall algorithm
        for(int i = 1; i <=n ; i++){
            for(int u = 1; u <= n; u++){
                for(int v = 1; v <= n; v++){
                    if(cost[u][i] != (int)1e9 && cost[i][v] != (int)1e9 && cost[u][v] > cost[u][i] + cost[i][v]){
                        cost[u][v] = cost[u][i] + cost[i][v];
                    }
                }
            }
        }
        return (int)cost[src][dest];
    }
}

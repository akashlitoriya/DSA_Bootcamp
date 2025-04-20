package graphs;

import java.util.Arrays;

public class CityWithMinNeighbours {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int m = edges.length;
        int cost[][] = new int[n][n];
        for(int rows[]: cost){
            Arrays.fill(rows, (int)1e9);
        }
        for(int i = 0; i < m; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            cost[u][v] = wt;
            cost[v][u] = wt;
        }
        //making diagonals zero
        for(int i = 0; i < n; i++){
            cost[i][i] = 0;
        }

        //floyd warshall algorithm
        for(int i = 0; i < n ; i++){
            for(int u = 0; u < n; u++){
                for(int v = 0; v < n; v++){
                    if(cost[u][i] != (int)1e9 && cost[i][v] != (int)1e9 && cost[u][v] > cost[u][i] + cost[i][v]){
                        cost[u][v] = cost[u][i] + cost[i][v];
                    }
                }
            }
        }

        int city = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int neighbours = 0;
            for(int j = 0; j < n; j++){
                if(cost[i][j] <= distanceThreshold){
                    neighbours++;
                }
            }
            if(neighbours <= min){
                min = neighbours;
                city = i;
            }
        }
        return city;

    }
}

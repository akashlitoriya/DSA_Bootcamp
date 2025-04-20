package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightWithKStops {
    class Pair{
        int stop;
        int node;
        int dis;
        int fruits;
        Pair(int stop, int node, int dis){
            this.stop = stop;
            this.node = node;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < flights.length; i++){
            adj.get(flights[i][0]).add(new Pair(0, flights[i][1], flights[i][2]));
        }
        int dist[] = new int[n];
        Arrays.fill(dist, (int)1e9);
        Queue<Pair> q = new LinkedList<>();
        dist[src] = 0;
        q.add(new Pair(0, src, 0));
        while(!q.isEmpty()){
            Pair node = q.poll();
            if(node.stop > k){
                break;
            }
            for(Pair item: adj.get(node.node)){
                if(dist[item.node] > node.dis + item.dis){
                    dist[item.node] = node.dis + item.dis;
                    q.add(new Pair(node.stop + 1, item.node, dist[item.node]));
                }
            }
        }
        if(dist[dst] == (int)1e9) return -1;
        return dist[dst];
    }
}

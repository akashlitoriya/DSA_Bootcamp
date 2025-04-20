package graphs;
import java.util.*;
public class PrintShortestPathDjikstaras {
    class Pair{
        int first;  //this will contain the value of node
        int second;    //this will contains the distance required to reach the node

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public List<Integer> shortestPath(int n, int m, int edges[][]){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        //  Code Here.
        int dist[] = new int[n + 1];
        Arrays.fill(dist, (int)1e9);
        //parent array intialise, that contains index as values
        int parent[] = new int[n + 1];
        for(int i = 0; i < n + 1; i++){
            parent[i] = i;
        }

        //Now we will apply djikstra's algorithm
        // So we will use PriorityQueue. so that we can have element with minimum distance
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.second - b.second);
        dist[1] = 0;
        pq.add(new Pair(1, 0));
        while(!pq.isEmpty()){
            Pair node = pq.poll();
            for(Pair item: adj.get(node.first)){
                if(dist[item.first] > node.second + item.second){
                    dist[item.first] = node.second + item.second;
                    parent[item.first] = node.first;
                    pq.add(new Pair(item.first, dist[item.first]));
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        if(dist[n] == (int)1e9){
            ans.add(-1);
            return ans;
        }
        int i = n;
        ans.add(0, n);
        while(parent[i] != i){
            i = parent[i];
            ans.add(0,i);
        }
        ans.add(0, dist[n]);
        return ans;
    }
}

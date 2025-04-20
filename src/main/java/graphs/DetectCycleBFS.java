package graphs;
import java.util.*;
public class DetectCycleBFS {
    class Pair{
        int val;
        int parent;
        Pair(int val, int parent){
            this.val = val;
            this.parent = parent;

        }
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        HashSet<Integer> visited = new HashSet<>();

        for(int i = 0; i < V; i++){
            if(!visited.contains(i)){
                Pair node = new Pair(i, -1);
                if(bfs(node, adj, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean bfs(Pair st, ArrayList<ArrayList<Integer>> adj, HashSet<Integer> visited){
        Queue<Pair> q = new LinkedList<>();
        visited.add(st.val);
        q.add(st);
        while(!q.isEmpty()){
            Pair removed = q.poll();
            for(int nodes: adj.get(removed.val)){
                if(!visited.contains(nodes)){
                    q.add(new Pair(nodes, removed.val));
                    visited.add(nodes);
                }else if(nodes != removed.parent){
                    return true;
                }
            }
        }
        return false;
    }
}

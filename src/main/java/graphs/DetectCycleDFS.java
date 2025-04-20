package graphs;
import java.util.HashSet;
import java.util.ArrayList;
public class DetectCycleDFS {
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
                if(dfs(node, adj, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(Pair node, ArrayList<ArrayList<Integer>> adj, HashSet<Integer> visited){
        visited.add(node.val);
        for(int item : adj.get(node.val)){
            if(!visited.contains(item)){
                Pair obj = new Pair(item, node.val);
                if(dfs(obj, adj, visited)){
                    return true;
                }
            }else if(item != node.parent){
                return true;
            }
        }
        return false;
    }
}

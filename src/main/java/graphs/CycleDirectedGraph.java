package graphs;
import java.util.ArrayList;
public class CycleDirectedGraph {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V];
        boolean path[] = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                if(dfs(i, adj, visited, path)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int root, ArrayList<ArrayList<Integer>> adj, boolean visited[], boolean path[]){
        visited[root] = true;
        path[root] = true;

        //visiting all the connected nodes
        for(int nodes: adj.get(root)){
            if(!visited[nodes]){
                if(dfs(nodes, adj, visited, path)){
                    return true;
                }
            }else if(path[nodes]){
                return true;
            }
        }
        path[root] = false;
        return false;
    }
}

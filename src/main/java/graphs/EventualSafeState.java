package graphs;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class EventualSafeState {
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        List<Integer> ans = new ArrayList<>();
        boolean visited[] = new boolean[V];
        boolean path[] = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!visited[i]){
                //dfs
                dfs(i, adj, visited, path, ans);
            }
        }
        Collections.sort(ans);
        return ans;
    }
    boolean dfs(int root, List<List<Integer>> adj, boolean[] visited, boolean[] path, List<Integer> safeNode){
        visited[root] = true;
        path[root] = true;

        //
        for(int node: adj.get(root)){
            if(!visited[node]){
                if(dfs(node, adj, visited, path, safeNode)){
                    return true;
                }
            }
            else if(path[node]){
                return true;
            }
        }
        safeNode.add(root);
        path[root] = false;
        return false;
    }
}

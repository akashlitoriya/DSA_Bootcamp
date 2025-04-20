package graphs;
import java.util.ArrayList;
import java.util.Stack;
public class TopologicalSort {
    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        Stack<Integer> st = new Stack<>();
        boolean visited[] = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfs(i, adj, visited, st);
            }
        }

        int ans[] = new int[st.size()];
        int i = 0;
        while(!st.empty()){
            ans[i] = st.pop();
            i++;
        }
        return ans;
    }
    static void dfs(int root, ArrayList<ArrayList<Integer>> adj, boolean visited[], Stack<Integer> st){
        visited[root] = true;

        for(int node: adj.get(root)){
            if(!visited[node]){
                dfs(node, adj, visited, st);
            }
        }
        st.push(root);
    }
}

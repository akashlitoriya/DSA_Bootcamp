package graphs;
import java.util.*;
public class kosarajuAlgorithm {
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        Stack<Integer> st = new Stack<>();
        boolean visited[] = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfs(i, visited, adj, st);
            }
        }

        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        for(int i = 0; i < V; i++){
            rev.add(new ArrayList<>());
        }
        for(int i = 0; i < adj.size(); i++){
            for(int node: adj.get(i)){
                rev.get(node).add(i);
            }
        }
        Arrays.fill(visited, false);
        int count = 0;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while(!st.isEmpty()){
            if(!visited[st.peek()]){

                count++;
                ans.add(d(st.peek(), visited, rev));
            }
            st.pop();
        }
        System.out.println(ans);
        return count;

    }
    private ArrayList<Integer> d(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> temp = new ArrayList<>();
        visited[node] = true;
        temp.add(node);
        for(int item: adj.get(node)){
            if(!visited[item]){
                temp.addAll(d(item, visited, adj));
            }
        }
        return temp;
    }
    private void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        visited[node] = true;
        for(int item: adj.get(node)){
            if(!visited[item]){
                dfs(item, visited, adj, st);
            }
        }
        st.push(node);
    }
}

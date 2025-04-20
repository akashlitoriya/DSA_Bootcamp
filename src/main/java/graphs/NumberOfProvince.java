package graphs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NumberOfProvince {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        //inputting the edges.
        for(int i = 0; i < m; i++){
            String[] edge = bf.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        System.out.println(getNumberProvince(graph, n));
    }
    public static int getNumberProvince(ArrayList<ArrayList<Integer>> graph, int v){
        boolean visited[] = new boolean[v];
        int count = 0;
        for(int i = 0; i < v; i++){
            if(!visited[i]){
                count++;
                dfs(graph, i, visited);
            }
        }
        return count;
    }
    public static void dfs(ArrayList<ArrayList<Integer>> graph, int node, boolean visited[]){
        visited[node] = true;
        for(int items: graph.get(node)){
            if(!visited[node]){
                dfs(graph, items, visited);
            }
        }
    }

}

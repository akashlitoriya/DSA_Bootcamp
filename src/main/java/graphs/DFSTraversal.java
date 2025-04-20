package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DFSTraversal {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }
    private static ArrayList<Integer> graphDFS(int n, ArrayList<Integer>[] graph){
        boolean visited[] = new boolean[n];
        return getDFS(0, graph, visited);
    }
    private static ArrayList<Integer> getDFS(int node, ArrayList<Integer>[]graph, boolean visited[]){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int item: graph[node]){
            if(!visited[item]){
                visited[item] = true;
                ans.addAll(getDFS(item, graph, visited));
            }
        }
        return ans;
    }

}

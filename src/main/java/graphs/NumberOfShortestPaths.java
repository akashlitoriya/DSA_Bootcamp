package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfShortestPaths {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nodeEdge = br.readLine().split(" ");
        int node = Integer.parseInt(nodeEdge[0]);
        int edge = Integer.parseInt(nodeEdge[1]);
        ArrayList<Integer>[] graph = new ArrayList[node + 1];
        for(int i = 0; i < node + 1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < edge; i++){
            String[] edges = br.readLine().split(" ");
            int v = Integer.parseInt(edges[1]);
            int u = Integer.parseInt(edges[0]);
            graph[v].add(u);
            graph[u].add(v);
        }

        int source = Integer.parseInt(br.readLine());

        int ways[] = getNumberOfWays(graph, source);
        System.out.println(Arrays.toString(ways));
    }
    private static int[] getNumberOfWays(ArrayList<Integer>[] graph, int source){
        int n = graph.length;
        boolean visited[] = new boolean[n];
        int ways[] = new int[n];
        int level[] = new int[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        level[source] = 0;
        visited[source] = true;
        while(!q.isEmpty()){
            int removed = q.poll();
            for(int item: graph[removed]){
                if(!visited[item]){
                    q.add(item);
                    level[item] = level[removed] + 1;
                    ways[item] = 1;
                    visited[item] = true;
                }else{
                    if(level[removed] + 1 == level[item]){
                        ways[item] = ways[item] + ways[removed];
                    }
                }
            }
        }
        return ways;
    }
}

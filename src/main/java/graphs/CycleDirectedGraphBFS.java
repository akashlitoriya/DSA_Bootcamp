package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDirectedGraphBFS {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int indegree[] = new int[V];
        for(int i = 0; i < adj.size(); i++){
            for(int item: adj.get(i)){
                indegree[item]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }


        int pointer = 0;

        while(!q.isEmpty()){
            int popped = q.poll();
            for(int item: adj.get(popped)){
                if(indegree[item] > 0){
                    indegree[item]--;
                    if(indegree[item] == 0){
                        q.add(item);
                    }
                }
            }

            pointer++;
        }
        return pointer == V? false: true;
    }
}

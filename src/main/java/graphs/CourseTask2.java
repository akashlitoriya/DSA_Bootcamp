package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseTask2 {
    static int[] findOrder(int N, int P, ArrayList<ArrayList<Integer>> prerequisites)
    {
        // add your code here
        int[] indegree = new int[N];
        ArrayList<Integer> adj[] = new ArrayList[N];
        for(int i = 0; i < N; i++){
            adj[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < P; i++){
            indegree[prerequisites.get(i).get(0)]++;
            adj[prerequisites.get(i).get(1)].add(prerequisites.get(i).get(0));
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            if(indegree[i] == 0) q.add(i);
        }

        int count = 0;
        int order[] = new int[N];
        while(!q.isEmpty()){
            int popped = q.poll();
            order[count] = popped;
            count++;
            for(int item: adj[popped]){
                if(indegree[item] > 0){
                    indegree[item]--;
                    if(indegree[item] == 0){
                        q.add(item);
                    }
                }
            }
        }
        if(count != N){
            return new int[]{};
        }
        return order;
    }
}

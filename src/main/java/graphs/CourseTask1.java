package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseTask1 {
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        // Your Code goes here
        int[] indegree = new int[N];
        ArrayList<Integer> adj[] = new ArrayList[N];
        for(int i = 0; i < N; i++){
            adj[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < P; i++){
            indegree[prerequisites[i][1]]++;
            adj[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            if(indegree[i] == 0) q.add(i);
        }

        int count = 0;
        while(!q.isEmpty()){
            int popped = q.poll();
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
        return count == N;
    }
}

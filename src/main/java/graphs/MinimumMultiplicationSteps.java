package graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationSteps {
    static class Pair{
        int dis;
        int val;
        Pair(int dis, int val){
            this.dis = dis;
            this.val = val;
        }
    }
    public static int minimumOperations(int n, int start, int end, int []a) {
        // Write your code here
        Queue<Pair> q = new LinkedList<>();
        int dis[] = new int[1000];
        Arrays.fill(dis, (int)1e9);
        dis[start] = 0;
        q.add(new Pair(0, start));
        while(!q.isEmpty()){
            Pair node = q.poll();
            if(node.val == end){
                return dis[node.val];
            }
            for(int i  =0; i < n; i++){
                int item = (node.val * a[i]) % (int)1e3;
                if(dis[item] > node.dis + 1){
                    q.add(new Pair(node.dis + 1,item));
                    dis[item] = node.dis + 1;
                }
            }
        }
        return -1;

    }
}

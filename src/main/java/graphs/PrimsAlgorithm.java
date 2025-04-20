package graphs;
import java.util.*;
public class PrimsAlgorithm {
    static class Entry{
        int wt;
        int node;
        int parent;

        Entry(int wt, int node, int parent){
            this.wt = wt;
            this.node = node;
            this.parent = parent;
        }
        public String toString(){
            return "[ " + this.wt + " , " + this.node + " , " + this.parent + " ]";
        }
    }


    public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int n) {
        ArrayList<ArrayList<Entry>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.size(); i++){
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            int wt = edges.get(i).get(2);
            adj.get(u).add(new Entry(wt, v, -1));
            adj.get(v).add(new Entry(wt, u, -1));
        }
        //Your code goes here
        PriorityQueue<Entry> pq = new PriorityQueue<>((a,b)->a.wt - b.wt);
        boolean visited[] = new boolean[n];
        pq.add(new Entry(0,0,-1));
        int mst = 0;
        ArrayList<Entry> spanningTree = new ArrayList<>();
        while(!pq.isEmpty()){
            Entry et = pq.poll();
            if(!visited[et.node]){
                visited[et.node] = true;
                mst += et.wt;
                spanningTree.add(new Entry(et.wt, et.node, et.parent));
                for(Entry item: adj.get(et.node)){
                    if(!visited[item.node]){
                        pq.add(new Entry(item.wt, item.node, et.node));
                    }
                }
            }
        }
        System.out.println(spanningTree);
        return mst;
    }
}

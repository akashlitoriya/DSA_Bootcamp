package graphs;
import java.util.*;
public class KruskalAlgorithm {
    public static class DisJointSets {
        private int parent[];
        private int rank[];
        private int size[];

        DisJointSets(int n){
            parent = new int[n];
            rank = new int[n];
            size = new int[n];
            Arrays.fill(size, 1);
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }

        private int getUltimateParent(int node){
            if(parent[node] == node){
                return node;
            }
            return parent[node] = getUltimateParent(parent[node]);
        }
        private void unionByRank(int u, int v){
            int pu = getUltimateParent(u);
            int pv = getUltimateParent(v);

            if(pu == pv){
                return;
            }

            int rankU = rank[pu];
            int rankV = rank[pv];
            if(rankU > rankV){
                parent[pv] = pu;
            }else if(rankU < rankV){
                parent[pu] = pv;
            }else{
                parent[pv] = pu;
                rank[pu]++;
            }
        }
        private void unionBySize(int u, int v){
            int pu = getUltimateParent(u);
            int pv = getUltimateParent(v);

            if(pu == pv){
                return ;
            }

            int sizeU = size[pu];
            int sizeV = size[pv];
            if(sizeU > sizeV){
                size[pu] += size[pv];
                parent[pv] = pu;
            }else if(sizeV > sizeU){
                size[pv] += size[pu];
                parent[pu] = pv;
            }else{
                size[pv] += size[pu];
                parent[pu] = pv;
            }
        }

        private void checkComponent(int a, int b){
            if(getUltimateParent(a) == getUltimateParent(b)){
                System.out.printf("Node %d and node %d belongs to same component\n", a, b);
            }else{
                System.out.printf("Node %d and node %d doesn't belongs to same component\n", a, b);
            }
        }
    }
    public static class Edge{
        int u;
        int v;
        int wt;

        Edge(int u, int v, int wt){
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    public static int kruskalMST(int n,int [][]edges) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b)->a.wt-b.wt);
        for(int i = 0; i < edges.length; i++){
            pq.add(new Edge(edges[i][0], edges[i][1], edges[i][2]));
        }
        int mst = 0;
        DisJointSets djs = new DisJointSets(n + 1);
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            if(djs.getUltimateParent(e.u) != djs.getUltimateParent(e.v)){
                djs.unionByRank(e.u, e.v);
                mst += e.wt;
            }
        }
        return mst;

    }
}

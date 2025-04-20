package graphs;

import java.util.Arrays;

public class OperationToMakeNetworkConnected {
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
    }
    public int makeConnected(int n, int[][] connections) {
        DisJointSets djs = new DisJointSets(n);
        int extraEdges = 0;
        for(int i = 0; i < connections.length; i++){
            int u = connections[i][0];
            int v = connections[i][1];
            if(djs.getUltimateParent(u) == djs.getUltimateParent(v)){
                extraEdges++;
            }else{
                djs.unionByRank(u, v);
            }
        }
        int components = 0;
        for(int i = 0; i < n; i++){
            if(djs.getUltimateParent(i) == i){
                components++;
            }
        }
        if(components - 1 > extraEdges) return -1;
        return components - 1;
    }
}

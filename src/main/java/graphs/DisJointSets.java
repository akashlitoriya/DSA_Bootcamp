package graphs;
import java.util.*;
public class DisJointSets {
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

    public static void main(String[] args) {
        DisJointSets djs = new DisJointSets(8);
        djs.unionByRank(1,2);
        djs.unionByRank(2,3);
        djs.unionByRank(4,5);
        djs.unionByRank(6,7);

        djs.checkComponent(1,6);

        djs.unionByRank(5,6);
        djs.unionByRank(3,7);
        djs.checkComponent(1,6);

        DisJointSets js = new DisJointSets(8);
        js.unionBySize(1,2);
        js.unionBySize(2,3);
        js.unionBySize(4,5);
        js.unionBySize(6,7);

        js.checkComponent(1,6);
        js.unionBySize(5,6);
        js.unionBySize(3,7);
        js.checkComponent(1,6);
    }



}

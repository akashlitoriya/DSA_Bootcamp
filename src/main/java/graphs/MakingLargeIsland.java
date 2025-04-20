package graphs;
import java.util.*;
public class MakingLargeIsland {
    public class DisJointSets {
        private int parent[];
        private int size[];

        DisJointSets(int n){
            parent = new int[n];
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
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        DisJointSets djs = new DisJointSets(n * m);
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};
        //make the components
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    int node = getNode(i, j, m);
                    for(int k = 0; k < 4; k++){
                        int adjr = i + dr[k];
                        int adjc = j + dc[k];
                        if(adjr >= 0 && adjr < n && adjc >= 0 && adjc < m){
                            int adj = getNode(adjr, adjc, m);
                            if(grid[adjr][adjc] == 1 && djs.getUltimateParent(node) != djs.getUltimateParent(adj)){
                                djs.unionBySize(node, adj);
                            }
                        }
                    }
                }
            }
        }

        //now converting all the 0 to 1
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    HashSet<Integer> set = new HashSet();
                    for(int k = 0; k < 4; k++){
                        int adjr = i + dr[k];
                        int adjc = j + dc[k];
                        if(adjr >= 0 && adjr < n && adjc >= 0 && adjc < m){
                            if(grid[adjr][adjc] == 1){
                                int adj = getNode(adjr, adjc, m);
                                set.add(djs.getUltimateParent(adj));
                            }
                        }
                    }
                    Iterator it = set.iterator();
                    int size = 0;
                    while(it.hasNext()){
                        size += djs.size[(int)it.next()];
                    }
                    max = Math.max(max, size + 1);
                }
            }
        }
        if(max == Integer.MIN_VALUE){
            return n * m;
        }
        return max;
    }
    private int getNode(int r, int c, int m){
        return r * m + c;
    }
}

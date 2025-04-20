package graphs;
import java.util.*;
public class NumberOfIslandsII {
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

    public List<Integer> numOfIslands(int n, int m, int[][] operators) {
        DisJointSets djs = new DisJointSets(n * m);
        List<Integer> ans = new ArrayList<>();
        int grid[][] = new int[n][m];
        int count = 0;
        boolean visited[][] = new boolean[n][m];
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};
        for(int i = 0; i < operators.length; i++){
            int r = operators[i][0];
            int c = operators[i][1];
            if(!visited[r][c]){
                visited[r][c] = true;
                grid[r][c] = 1;
                count++;

                //checking the adjacents cells
                for(int j = 0; j < 4; j++){
                    int adjr = r + dr[j];
                    int adjc = c + dc[j];
                    if(adjr >= 0 && adjr < n && adjc >= 0 && adjc < m){
                        if(grid[adjr][adjc] == 1 && djs.getUltimateParent(getNodeNumber(adjr, adjc, m)) != djs.getUltimateParent(getNodeNumber(r, c, m))){
                            count--;
                            djs.unionBySize(getNodeNumber(adjr, adjc, m) , getNodeNumber(r, c, m));
                        }
                    }
                }

            }
            ans.add(count);
        }
        return ans;
    }
    public int getNodeNumber(int r, int c, int m){
        return r * m + c;
    }
}

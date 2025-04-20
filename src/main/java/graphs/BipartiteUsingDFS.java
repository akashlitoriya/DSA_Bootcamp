package graphs;

public class BipartiteUsingDFS {
    class Pair{
        int val;
        int col;
        Pair(int val, int col){
            this.val = val;
            this.col = col;
        }
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for(int i = 0; i < n; i++){
            if(color[i] == 0){
                color[i] = 1;
                if(!dfs(new Pair(i, 1), graph, color)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(Pair root, int graph[][], int color[]){
        for(int connected: graph[root.val]){
            if(color[connected] == 0){
                if(root.col == 1){
                    color[connected] = 2;
                    if(!dfs(new Pair(connected, 2), graph, color)){
                        return false;
                    }
                } else{
                    color[connected] = 1;
                    if(!dfs(new Pair(connected, 1), graph, color)){
                        return false;
                    }
                }

            }else if(color[connected] == root.col){
                return false;
            }
        }
        return true;
    }
}

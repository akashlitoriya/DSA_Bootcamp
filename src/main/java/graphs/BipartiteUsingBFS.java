package graphs;
import java.util.Queue;
import java.util.LinkedList;
public class BipartiteUsingBFS {
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
                if(!bfs(new Pair(i, 1), graph, color)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean bfs(Pair root, int graph[][], int color[]){
        Queue<Pair> q = new LinkedList<>();
        q.add(root);
        color[root.val] = 1;
        while(!q.isEmpty()){
            Pair node = q.poll();
            for(int connected : graph[node.val]){
                if(color[connected] == 0){
                    if(node.col == 1){
                        q.add(new Pair(connected, 2));
                        color[connected] = 2;
                    }else{
                        q.add(new Pair(connected, 1));
                        color[connected] = 1;
                    }
                }else if(color[connected] == node.col){
                    return false;
                }
            }
        }
        return true;
    }
}

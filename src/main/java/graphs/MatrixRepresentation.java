package graphs;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixRepresentation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of Nodes : ");
        int n = in.nextInt();
        System.out.print("Enter number of edges : ");
        int m = in.nextInt();

        //declaring matrix for storing the nodes.
        int graph[][] = new int[n][n];
        for(int i = 0; i < m; i++){
            System.out.println("Enter edge as x -> y");
            int x = in.nextInt();
            int y = in.nextInt();

            //considering the graph is undirected
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        System.out.println(Arrays.deepToString(graph));

        System.out.println("Nodes connected with 1 : " + getNodeDirectlyConnected(1, graph));
    }

    private static int getNodeDirectlyConnected(int node, int[][] graph){
        int count = 0;
        int n = graph[node].length;
        for(int i = 0; i < n; i++){
            if(graph[node][i] == 1) count++;
        }
        return count;
    }
}

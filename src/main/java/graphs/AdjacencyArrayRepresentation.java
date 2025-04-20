package graphs;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
public class AdjacencyArrayRepresentation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of nodes : ");
        int n = in.nextInt();
        System.out.println("Enter number of edges : ");
        int m = in.nextInt();

        //declaring arrayList
        ArrayList<Integer> arr[] = new ArrayList[n];
        for(int i = 0; i < n; i++){
            arr[i] = new ArrayList<>();
        }

        //reading edges
        for(int i = 0; i < m; i++){
            System.out.println("Enter edge in form of x -> y");
            int x = in.nextInt();
            int y = in.nextInt();

            arr[x].add(y);
            arr[y].add(x);
        }

        System.out.println(Arrays.deepToString(arr));
        System.out.println("Nodes connected to 1 : " + getNodesDirectlyConnected(1, arr));
    }

    private static ArrayList<Integer> getNodesDirectlyConnected(int node, ArrayList<Integer>[] graph){
        return graph[node];
    }

}

package graphs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSTraversal {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of nodes : ");
        int n = in.nextInt();
        System.out.print("Enter the number of edges : ");
        int m = in.nextInt();

        ArrayList<Integer>[] graph = new ArrayList[n + 5];      //n + 5 to be on safer side, else can also take n + 1
        //creating a list for every node in the graph
        for(int i = 0; i < n + 5; i++){
            graph[i] = new ArrayList<>();
        }

        //new getting all the edges from the user and generating graph
        //Edge input will be like x -> y
        for(int i = 0; i < m; i++){
            System.out.println("Give edge in x->y form : ");
            int from = in.nextInt();
            int to = in.nextInt();

            graph[from].add(to);
            graph[to].add(from);
        }

        //getBFS Traversal
        System.out.println("BFS Traversal of the graph");
        getBFSTraversal(graph, 3);
        getBFSTraversalWithLevels(graph, 3);


    }

    private static void getBFSTraversal(ArrayList<Integer>[] graph, int st){
        int n = graph.length;
        int visited[] = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(st);
        visited[st] = 1;
        while(!q.isEmpty()){
            int removed = q.poll();
            System.out.print(removed + " ");
            for(int item : graph[removed]){
                if(visited[item] != 1){
                    q.add(item);
                    visited[item] = 1;
                }
            }
        }
        System.out.println();
    }
    private static void getBFSTraversalWithLevels(ArrayList<Integer>[] graph, int st){
        int n = graph.length;
        int visited[] = new int[n + 1];
        int level[] = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(st);
        level[st] = 0;
        visited[st] = 1;
        while(!q.isEmpty()){
            int removed = q.poll();
            System.out.print(removed + " - " + level[removed] + " ---> ");
            for(int item : graph[removed]){
                if(visited[item] != 1){
                    q.add(item);
                    visited[item] = 1;
                    level[item] = level[removed] + 1;
                }
            }
        }
        System.out.println();
    }

}

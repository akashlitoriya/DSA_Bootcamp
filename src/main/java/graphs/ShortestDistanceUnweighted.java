package graphs;
import java.util.*;

public class ShortestDistanceUnweighted {
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

        int dis[] = getShortestDistance(graph, 3);
        System.out.println(Arrays.toString(dis));

    }
    private static int[] getShortestDistance(ArrayList<Integer>[] graph, int st){
        int n = graph.length;
        int[] level = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(st);
        level[st] = 0;
        visited[st] = true;
        while(!q.isEmpty()){
            int removed = q.poll();
            for(int item: graph[removed]){
                if(!visited[item]){
                    q.add(item);
                    visited[item] = true;
                    level[item] = level[removed] + 1;
                }
            }

        }
        return level;
    }
}


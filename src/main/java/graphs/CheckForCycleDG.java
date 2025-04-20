package graphs;
import java.util.*;
public class CheckForCycleDG {
    static class Edge{
        int target;
        int weight;

        Edge(int des, int weight){
            this.target = des;
            this.weight = weight;
        }
    }
    public static int[] findCyclesAndMinWeights(int n, List<Edge>[] graph) {
        int[] minCycleWeights = new int[n + 1];
        Arrays.fill(minCycleWeights, -1); // Initialize with -1 indicating no cycle

        // Check for self-loops
        for (int u = 1; u <= n; u++) {
            for (Edge edge : graph[u]) {
                if (u == edge.target) {
                    if (minCycleWeights[u] == -1) {
                        minCycleWeights[u] = edge.weight;
                    } else {
                        minCycleWeights[u] = Math.min(minCycleWeights[u], edge.weight);
                    }
                }
            }
        }

        boolean[] visited = new boolean[n + 1];
        boolean[] recStack = new boolean[n + 1];

        // DFS to detect other cycles
        for (int u = 1; u <= n; u++) {
            if (!visited[u]) {
                int cycleWeight = dfs(u, visited, recStack, graph, new int[n + 1]);
                if (cycleWeight != Integer.MAX_VALUE) {
                    if (minCycleWeights[u] == -1) {
                        minCycleWeights[u] = cycleWeight;
                    } else {
                        minCycleWeights[u] = Math.min(minCycleWeights[u], cycleWeight);
                    }
                }
            }
        }

        return minCycleWeights;
    }

    private static int dfs(int u, boolean[] visited, boolean[] recStack, List<Edge>[] graph, int[] weights) {
        visited[u] = true;
        recStack[u] = true;
        int cycleWeight = Integer.MAX_VALUE;

        for (Edge edge : graph[u]) {
            if (!visited[edge.target]) {
                weights[edge.target] = weights[u] + edge.weight;
                int result = dfs(edge.target, visited, recStack, graph, weights);
                if (result != Integer.MAX_VALUE) {
                    cycleWeight = Math.min(cycleWeight, result + edge.weight);
                }
            } else if (recStack[edge.target]) {
                cycleWeight = Math.min(cycleWeight, weights[u] + edge.weight - weights[edge.target]);
            }
        }

        recStack[u] = false;
        return cycleWeight;
    }
}

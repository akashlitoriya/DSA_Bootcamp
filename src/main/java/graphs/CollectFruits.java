package graphs;

public class CollectFruits {
    private static int maxFruits;

    public static int collectMaxFruits(int M, int N, int X, int Y, int K, int[][] garden) {
        maxFruits = 0;
        boolean[][] visited = new boolean[M][N];
        dfs(garden, X - 1, Y - 1, K, 0, visited);
        return maxFruits;
    }

    private static void dfs(int[][] garden, int x, int y, int stepsRemaining, int currentFruits, boolean[][] visited) {
        if (stepsRemaining < 0) {
            return;
        }

        maxFruits = Math.max(maxFruits, currentFruits);

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (isValidMove(garden, newX, newY, visited)) {
                dfs(garden, newX, newY, stepsRemaining - 1, currentFruits + garden[newX][newY], visited);
            }
        }

        visited[x][y] = false;
    }

    private static boolean isValidMove(int[][] garden, int x, int y, boolean[][] visited) {
        return x >= 0 && x < garden.length && y >= 0 && y < garden[0].length && !visited[x][y];
    }

    public static void main(String[] args) {
        int M = 3;
        int N = 4;
        int X = 3;
        int Y = 3;
        int K = 3;
        int[][] garden = {
                {2,1,4,2},
                {3,1,2,3},
                {2,2,0,1}
        };

        System.out.println(collectMaxFruits(M, N, X, Y, K, garden)); // Output will depend on the garden configuration
    }
}

package dynamicProgramming;
import java.util.Arrays;
public class MatrixChainMultiplication {
    public static void main(String[] args) {

    }
    //Memoization
    public static int mcm(int[] p){
        int n = p.length;
        int dp[][] = new int[n][n];
        for(int rows[]: dp){
            Arrays.fill(rows, -1);
        }
        return getMCM(1, n - 1,p, dp);
    }
    private static int getMCM(int i, int j, int[]arr, int[][] dp){
        if(i == j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){
            int steps = arr[i - 1] * arr[k] * arr[j] + getMCM(i, k, arr, dp) + getMCM(k+1, j, arr, dp);
            if(steps < mini) mini = steps;
        }
        return dp[i][j] = mini;
    }

    //Tabulation
    public static int tabu(int[] p){
        int n = p.length;
        int dp[][] = new int[n][n];

        for(int i = n - 1; i >= 1; i--){
            for(int j = i + 1; j < n; j++){
                int mini = Integer.MAX_VALUE;
                for(int k = i; k < j; k++){
                    int steps = p[i-1] * p[k] * p[j] + dp[i][k] + dp[k + 1][j];
                    if(steps < mini) mini = steps;
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][n - 1];
    }
}

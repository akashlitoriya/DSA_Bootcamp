package dynamicProgramming;

public class RodCuttingProblem {
    //memoisation
    private static int f(int idx, int N, int[] prices, int[][] dp){
        if(idx == 0){
            return N * prices[0];
        }
        if(dp[idx][N] != -1) return dp[idx][N];
        int notTake = 0 + f(idx - 1, N, prices, dp);
        int take = -(int)1e8;
        if(idx + 1 <= N){
            take = prices[idx] + f(idx, N - idx - 1, prices, dp);
        }
        return dp[idx][N] =  Math.max(notTake, take);
    }

    //Tabulation
    public static int cutRod(int price[], int n) {
        // Write your code here.
        int idx = price.length - 1;
        int dp[][] = new int[idx + 1][n + 1];
        for(int i = 0; i <= n; i++){
            dp[0][i] = i * price[0];
        }
        for(int ind = 1; ind <= idx; ind++){
            for(int i = 0; i <= n; i++){
                int notTake = 0 + dp[ind - 1][i];
                int take = -(int)1e8;
                if(ind + 1 <= i){
                    take = price[ind] + dp[ind][i - ind - 1];
                }
                dp[ind][i] = Math.max(notTake, take);
            }
        }
        return dp[idx][n];
    }
}

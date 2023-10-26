package dynamicProgramming;

public class UnboundedKnapsack {
    //memoization
    private static int getMax(int idx, int maxWeight, int[] profit, int[] weight, int dp[][]){
        if(idx == 0){
            if(weight[0] <= maxWeight){
                return profit[0] * (maxWeight/weight[0]);
            }
            return 0;
        }
        if(dp[idx][maxWeight] != -1) return dp[idx][maxWeight];
        int notTake = 0 + getMax(idx - 1, maxWeight, profit, weight, dp);
        int take = -(int)1e8;
        if(weight[idx] <= maxWeight){
            take = profit[idx] + getMax(idx, maxWeight - weight[idx], profit, weight, dp);
        }
        return dp[idx][maxWeight] = Math.max(take, notTake);
    }
    //Tabulation
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
        int dp[][] = new int[n][w+1];
        for(int wt = 0; wt <= w; wt++){
            dp[0][wt] = profit[0] * (wt/weight[0]);
        }
        for(int idx = 1; idx < n; idx++){
            for(int wt = 0; wt <= w; wt++){
                int notTake = 0 + dp[idx-1][wt];
                int take = -(int)1e8;
                if(weight[idx] <= wt){
                    take = profit[idx] + dp[idx][wt-weight[idx]];
                }
                dp[idx][wt] = Math.max(notTake, take);
            }
        }
        return dp[n-1][w];
    }

    //space optimization
    public static int space(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
        int dp[] = new int[w+1];
        for(int wt = 0; wt <= w; wt++){
            dp[wt] = profit[0] * (wt/weight[0]);
        }
        for(int idx = 1; idx < n; idx++){
            for(int wt = 0; wt <= w; wt++){
                int notTake = 0 + dp[wt];
                int take = -(int)1e8;
                if(weight[idx] <= wt){
                    take = profit[idx] + dp[wt-weight[idx]];
                }
                dp[wt] = Math.max(notTake, take);
            }
        }
        return dp[w];
    }
}

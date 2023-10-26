package dynamicProgramming;

public class KnapSack1 {
    //recursion
    public static int recur(int idx, int maxWeight, int[] weights, int[] value){
        if(idx == 0){
            if(weights[0] <= maxWeight){
                return value[0];
            }
            return 0;
        }
        int notTake = 0 + recur(idx - 1, maxWeight, weights, value);
        int take = Integer.MIN_VALUE;
        if(weights[idx] <= maxWeight){
            take = recur(idx - 1, maxWeight - weights[idx], weights, value);
        }
        return Math.max(take, notTake);
    }

    //Memoization
    static int getKnapsack(int idx, int maxWeight, int[] weight, int[] value, int dp[][]){
        // if(maxWeight == 0){
        //     return 0;
        // }
        if(idx == 0){
            if(weight[0] <= maxWeight){
                return value[0];
            }else{
                return 0;
            }
        }
        if(dp[idx][maxWeight] != -1) return dp[idx][maxWeight];
        int notTake = 0 + getKnapsack(idx - 1,maxWeight,weight, value, dp );
        int take = Integer.MIN_VALUE;
        if(weight[idx] <= maxWeight){
            take = value[idx] + getKnapsack(idx - 1, maxWeight - weight[idx], weight, value, dp);
        }
        return dp[idx][maxWeight] = Math.max(notTake, take);
    }

    //Tabulation
    static int tabulation(int[] weight, int[] value, int n, int maxWeight) {
        int dp[][] = new int[n][maxWeight + 1];
        for(int i = 0; i < maxWeight + 1; i++){
            if(weight[0] <= i){
                dp[0][i] = value[0];
            }else{
                dp[0][i] = 0;
            }
        }

        for(int idx = 1; idx < n; idx++){
            for(int wt = 0; wt <= maxWeight; wt++){
                int notTake = dp[idx - 1][wt];
                int take = Integer.MIN_VALUE;
                if(weight[idx] <= wt){
                    take = value[idx] + dp[idx-1][wt - weight[idx]];
                }
                dp[idx][wt] = Math.max(take, notTake);
            }
        }
        return dp[n-1][maxWeight];
    }

    //Space Optimization
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int dp[] = new int[maxWeight + 1];
        for(int i = 0; i < maxWeight + 1; i++){
            if(weight[0] <= i){
                dp[i] = value[0];
            }else{
                dp[i] = 0;
            }
        }

        for(int idx = 1; idx < n; idx++){
            for(int wt = maxWeight; wt >= 0; wt--){
                int notTake = dp[wt];
                int take = Integer.MIN_VALUE;
                if(weight[idx] <= wt){
                    take = value[idx] + dp[wt - weight[idx]];
                }
                dp[wt] = Math.max(take, notTake);
            }
        }
        return dp[maxWeight];
    }
}

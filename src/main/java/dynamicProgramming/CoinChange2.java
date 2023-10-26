package dynamicProgramming;

public class CoinChange2 {
    //recur
    private int recur(int idx, int target, int coins[]){
        if(idx == 0){
            if(target % coins[0] == 0){
                return 1;
            }
            return 0;
        }

        int take = 0;
        if(coins[idx] <= target){
            take = recur(idx, target - coins[idx], coins);
        }
        int notTake = recur(idx - 1, target, coins);
        return take + notTake;
    }

    //Memoization
    private int recur(int idx, int target, int coins[], int dp[][]){
        if(idx == 0){
            if(target % coins[0] == 0){
                return 1;
            }
            return 0;
        }
        if(dp[idx][target] != -1) return dp[idx][target];
        int take = 0;
        if(coins[idx] <= target){
            take = recur(idx, target - coins[idx], coins,dp);
        }
        int notTake = recur(idx - 1, target, coins, dp);
        return dp[idx][target] =  take + notTake;
    }

    //Tabulation
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];
        for(int tar = amount; tar >= 0; tar--){
            if(tar % coins[0] == 0){
                dp[0][tar] = 1;
            }else{
                dp[0][tar] = 0;
            }
        }
        for(int idx = 1; idx < n; idx++){
            for(int tar = 0; tar <= amount; tar++){
                int notTake = dp[idx - 1][tar];
                int take = 0;
                if(coins[idx] <= tar){
                    take = dp[idx][tar-coins[idx]];
                }
                dp[idx][tar] = take + notTake;
            }
        }
        return dp[n-1][amount];
    }

    //Space Optimization
    public int space(int amount, int[] coins) {
        int n = coins.length;
        int dp[] = new int[amount + 1];
        for(int tar = amount; tar >= 0; tar--){
            if(tar % coins[0] == 0){
                dp[tar] = 1;
            }else{
                dp[tar] = 0;
            }
        }
        for(int idx = 1; idx < n; idx++){
            int cur[] = new int[amount + 1];
            for(int tar = 0; tar <= amount; tar++){
                int notTake = dp[tar];
                int take = 0;
                if(coins[idx] <= tar){
                    take = cur[tar-coins[idx]];
                }
                cur[tar] = take + notTake;
            }
            dp=cur;
        }
        return dp[amount];
    }
}

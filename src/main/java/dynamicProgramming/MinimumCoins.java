package dynamicProgramming;

public class MinimumCoins {
    //memoization
    private int recur(int idx, int target, int coins[], int dp[][]){
        if(idx == 0){
            if(target % coins[idx] == 0){
                return target/coins[idx];
            }else{
                return (int)1e9;
            }
        }
        if(dp[idx][target] != -1) return dp[idx][target];
        int notTake = 0 + recur(idx - 1, target, coins, dp);
        int take = (int)1e9;
        if(coins[idx] <= target){
            take = 1 + recur(idx, target - coins[idx], coins, dp);
        }
        return dp[idx][target] = Math.min(notTake, take);
    }

    //Tabulation
    private int tabu(int[] coins, int amount){
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];
        for(int i = 0; i <= amount; i++){
            if(i % coins[0] == 0){
                dp[0][i] = i/coins[0];
            }else{
                dp[0][i] = (int)1e9;
            }
        }

        for(int idx = 1; idx < n; idx++){
            for(int amt = 0; amt <= amount; amt++){
                int notTake = 0 + dp[idx-1][amt];
                int take = (int)1e9;
                if(coins[idx] <= amt){
                    take = 1 + dp[idx][amt - coins[idx]];
                }
                dp[idx][amt] = Math.min(take, notTake);
            }
        }
        int ans = dp[n-1][amount];
        if(ans >= (int)1e9){
            return -1;
        }
        return ans;
    }
}

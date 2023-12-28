package dynamicProgramming;

import java.util.Arrays;

public class BuyAndSellStockII {
    //Recursion - T.C = O(2^n) S.C = O(N)
    private int recur(int idx, int buy, int prices[]){
        if(idx == prices.length){
            return 0;
        }
        int profit = 0;
        if(buy == 0){
            profit = Math.max(-prices[idx] + recur(idx + 1, 1, prices),
                    0 + recur(idx + 1, 0, prices));
        }else{
            profit = Math.max(prices[idx] + recur(idx + 1, 0, prices),
                    0 + recur(idx + 1, 1, prices));
        }
        return profit;
    }
    //Memoization - T.C = O(N * 2) S.C = O(N * 2) + O(N)
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int rows[] : dp){
            Arrays.fill(rows, -1);
        }
        return memo(0, 0, prices, dp);
    }
    private int memo(int idx, int buy, int prices[], int[][] dp){
        if(idx == prices.length){
            return 0;
        }
        if(dp[idx][buy] != -1) return dp[idx][buy];
        int profit = 0;
        if(buy == 0){
            profit = Math.max(-prices[idx] + memo(idx + 1, 1, prices, dp),
                    0 + memo(idx + 1, 0, prices, dp));
        }else{
            profit = Math.max(prices[idx] + memo(idx + 1, 0, prices, dp),
                    0 + memo(idx + 1, 1, prices, dp));
        }
        return dp[idx][buy] = profit;
    }

    //Tabulation = T.C = O(N * 2) S.C = O(N * 2)
    public int tabu(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n + 1][2];  //n + 1 because the base case is when idx == n
        //Base case handling
        dp[n][0] = dp[n][1] = 0;
        //Exploring all posibilities
        for(int idx = n -1; idx >= 0; idx--){  //bottom up so started from n-1 because base case is idx == n
            for(int buy = 0; buy <= 1; buy++){
                int profit = 0;
                if(buy == 0){
                    profit = Math.max(-prices[idx] + dp[idx + 1][1],
                            0 + dp[idx + 1][0]);
                }else{
                    profit = Math.max(prices[idx] + dp[idx + 1][0],
                            0 + dp[idx + 1][1]);
                }
                dp[idx][buy] = profit;
            }
        }
        return dp[0][0];
    }

    //Space Optimized solution = T.C = O(N * 2) S.C = O(2 * 2)
    public int spaceOptimized(int[] prices) {
        int n = prices.length;
        int curr[] = new int[2];
        int ahead[] = new int[2];
        //Base case handling
        ahead[0] = ahead[1] = 0;
        //Exploring all posibilities
        for(int idx = n -1; idx >= 0; idx--){
            for(int buy = 0; buy <= 1; buy++){
                int profit = 0;
                if(buy == 0){
                    profit = Math.max(-prices[idx] + ahead[1],
                            0 + ahead[0]);
                }else{
                    profit = Math.max(prices[idx] + ahead[0],
                            0 + ahead[1]);
                }
                curr[buy] = profit;
            }
            ahead = curr;
        }
        return ahead[0];
    }
}

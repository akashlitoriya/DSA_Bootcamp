package dynamicProgramming;
import java.util.*;
public class BuySellStockIII {
    public static void main(String[] args) {

    }
    private int recur(int idx, int buy, int cap, int n, int[] prices){
        if(cap == 0) return 0;
        if(idx == n) return 0;
        if(buy == 1){
            return Math.max(-prices[idx] + recur(idx + 1, 0, cap, n, prices),
                    0 + recur(idx + 1, 1, cap, n, prices));
        }else{
            return Math.max(prices[idx] + recur(idx + 1, 1, cap - 1, n, prices),
                    0 + recur(idx + 1, 0, cap, n, prices));
        }
    }

    //Memoization solution
    public int memo(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n][2][3];
        for(int row[][] : dp){
            for(int col[]: row){
                Arrays.fill(col, -1);
            }
        }
        return recur(0, 1, 2, n, prices, dp);
    }
    private int recur(int idx, int buy, int cap, int n, int[] prices, int[][][] dp){
        if(cap == 0) return 0;
        if(idx == n) return 0;
        if(dp[idx][buy][cap] != -1) return dp[idx][buy][cap];
        if(buy == 1){
            return dp[idx][buy][cap] = Math.max(-prices[idx] + recur(idx + 1, 0, cap, n, prices, dp),
                    0 + recur(idx + 1, 1, cap, n, prices, dp));
        }else{
            return dp[idx][buy][cap] = Math.max(prices[idx] + recur(idx + 1, 1, cap - 1, n, prices, dp),
                    0 + recur(idx + 1, 0, cap, n, prices, dp));
        }
    }

    //Tabulation
    public int tabu(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n + 1][2][3];
        //base case
        // for(int buy = 0; buy < 2; buy++){
        //     for(int cap = 0; cap < 3; cap++){
        //         dp[n][buy][cap] = 0;
        //     }
        // }
        //exploring all posibilities
        for(int idx = n - 1; idx >= 0; idx--){
            for(int buy = 0; buy < 2; buy++){
                for(int cap = 1; cap < 3; cap++){
                    if(buy == 0){
                        dp[idx][buy][cap] = Math.max(-prices[idx] + dp[idx + 1][1][cap],
                                0 + dp[idx + 1][0][cap]);
                    }else{
                        dp[idx][buy][cap] = Math.max(prices[idx] + dp[idx + 1][0][cap - 1],
                                0 + dp[idx + 1][1][cap]);
                    }
                }
            }
        }
        return dp[0][0][2];
    }

    //Space Optimization -
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ahead[][] = new int[2][3];
        int curr[][] = new int[2][3];

        //exploring all posibilities
        for(int idx = n - 1; idx >= 0; idx--){
            for(int buy = 0; buy < 2; buy++){
                for(int cap = 1; cap < 3; cap++){
                    if(buy == 0){
                        curr[buy][cap] = Math.max(-prices[idx] + ahead[1][cap],
                                0 + ahead[0][cap]);
                    }else{
                        curr[buy][cap] = Math.max(prices[idx] + ahead[0][cap - 1],
                                0 + ahead[1][cap]);
                    }
                }
            }
            ahead = curr;
        }
        return curr[0][2];
    }
}

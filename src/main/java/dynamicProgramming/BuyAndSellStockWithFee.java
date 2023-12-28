package dynamicProgramming;
import java.util.*;
public class BuyAndSellStockWithFee {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int rows[] : dp){
            Arrays.fill(rows, -1);
        }
        return getMaxProfit(0, 0, n, prices, fee, dp);
    }
    private int getMaxProfit(int idx, int buy, int n, int prices[], int fee, int[][] dp){
        if(idx == n){
            return 0;
        }
        if(dp[idx][buy] != -1) return dp[idx][buy];
        if(buy == 0){
            return dp[idx][buy] = Math.max(-prices[idx] + getMaxProfit(idx + 1, 1, n, prices, fee, dp),
                    0 + getMaxProfit(idx + 1, 0, n, prices, fee, dp));


        }
        return dp[idx][buy] = Math.max(prices[idx] - fee + getMaxProfit(idx + 1, 0, n, prices, fee, dp),
                0 + getMaxProfit(idx + 1, 1, n, prices, fee, dp));
    }
}

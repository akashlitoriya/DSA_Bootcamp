package dynamicProgramming;
import java.util.*;
public class BuyAndSellStockWithCooldown {
    //Memoization
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int rows[]: dp){
            Arrays.fill(rows, -1);
        }
        return getMaxProfit(0, 0,n, prices, dp);
    }
    private int getMaxProfit(int idx, int buy, int n, int prices[], int dp[][]){
        if(idx >= n) return 0;
        if(dp[idx][buy] != -1) return dp[idx][buy];
        if(buy == 0){
            int buy1 = -prices[idx] + getMaxProfit(idx + 1,  1, n, prices, dp);
            int notBuy = 0 + getMaxProfit(idx + 1, 0, n, prices, dp);
            return dp[idx][buy] = Math.max(buy1, notBuy);
        }else{
            int sell = prices[idx] + getMaxProfit(idx + 2, 0, n , prices, dp);
            int notSell = 0 + getMaxProfit(idx + 1, 1, n , prices, dp);
            return dp[idx][buy] = Math.max(sell, notSell);
        }
    }
    //Tabulation
    public int tabu(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n + 2][2]; //n + 2 dp because our n = [0, n + 1];

        //exploring all the possiblilites
        for(int idx = n - 1; idx >= 0; idx--){
            //dp[idx][0] == buying for that index
            dp[idx][0] = Math.max(-prices[idx] + dp[idx + 1][1],
                    0 + dp[idx + 1][0]);

            //dp[idx][1] == selling for that index
            dp[idx][1] = Math.max(prices[idx] + dp[idx + 2][0],
                    0 + dp[idx + 1][1]);


        }
        return dp[0][0];
    }
}

package dynamicProgramming;

public class BuyAndSellStockIV {
    //Memoization: getMaxProfit(0, 0, prices, n, k, dp);
    //T.C = O(n * 2 * k) S.C = O(n * 2 * k) + O(N)
    private int getMaxProfit(int idx, int tranNo, int prices[], int n, int k, int[][] dp){
        if(idx == n || tranNo == 2 * k){
            return 0;
        }
        if(dp[idx][tranNo] != -1) return dp[idx][tranNo];
        if(tranNo % 2 == 0){
            int buy = -prices[idx] + getMaxProfit(idx + 1, tranNo + 1, prices, n, k, dp);
            int NotBuy = 0 + getMaxProfit(idx + 1, tranNo, prices, n, k, dp);
            return dp[idx][tranNo] = Math.max(buy, NotBuy);
        }else{
            int sell = prices[idx] + getMaxProfit(idx + 1, tranNo + 1, prices, n, k, dp);
            int notSell = 0 + getMaxProfit(idx + 1, tranNo, prices, n, k, dp);
            return dp[idx][tranNo] = Math.max(sell, notSell);
        }
    }

    //Tabulation
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n + 1][2*k + 1];
        //base case wants to return 0, so no need to handle base case as default value in array is 0
        for(int i = n - 1; i >= 0; i--){
            for(int transNo = 0; transNo < 2 * k; transNo++){
                if(transNo % 2 == 0){
                    dp[i][transNo] = Math.max(-prices[i] + dp[i + 1][transNo + 1],
                            0 + dp[i + 1][transNo]);
                }else{
                    dp[i][transNo] = Math.max(prices[i] + dp[i + 1][transNo + 1],
                            0 + dp[i + 1][transNo]);
                }
            }
        }

        return dp[0][0];
    }
}

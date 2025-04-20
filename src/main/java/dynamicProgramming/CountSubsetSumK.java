package dynamicProgramming;

import java.util.Arrays;

public class CountSubsetSumK {
    public static int findWays(int num[], int tar) {
        int n= num.length;
        int k = tar;
        int max = Integer.MAX_VALUE;
        int dp[][] = new int[n][k + 1];
        for(int rows[]: dp){
            Arrays.fill(rows, -1);
        }
        int ans = getSubsetsCount(n - 1, k, num, dp);
        return ans;
    }
    private static int getSubsetsCount(int idx, int target, int[] nums, int[][] dp){

        if(idx == 0){
            if(target == 0 && nums[0] == target){
                return 2;
            }
            if(target == 0 || nums[0] == target){
                return 1;
            }
            return 0;
        }
        if(dp[idx][target] != -1) return dp[idx][target];

        int take = 0;
        if(nums[idx] <= target){
            take = getSubsetsCount(idx-1, target-nums[idx], nums, dp);
        }
        int notTake = getSubsetsCount(idx-1, target, nums, dp);
        dp[idx][target] = take + notTake;
        return take + notTake;
    }

    //Tabulations
    public static int tabu(int num[], int tar) {
        int n= num.length;
        int k = tar;
        int dp[][] = new int[n][k + 1];
        for(int i = 0;i < n; i++){
            dp[i][0] = 1;
        }
        if(num[0] <= tar){
            dp[0][num[0]] = 1;
        }
        for(int idx = 1; idx < n; idx++){
            for(int target = 1; target <= tar; target++){
                int notTake = dp[idx-1][target];
                int take = 0;
                if(num[idx] <= target){
                    take = dp[idx-1][target - num[idx]];
                }
                dp[idx][target] = take + notTake;
            }
        }
        return dp[n-1][tar] % 1000000007;
    }
}

package dynamicProgramming;
import java.util.*;
public class LongestIncreasingSubsequence {
    //Recursion: T.C = O(2^n)
    //getMaxLen(0, -1, n, nums);
    private int getMaxLen(int idx, int prevIdx, int n, int[] nums){
        if(idx == n) return 0;
        //not taking element at idx in our subsequence
        int notTake = getMaxLen(idx + 1, prevIdx, n, nums);

        //taking element at idx if it is greater than element at prevIdx
        int take = 0;
        if(prevIdx == -1 || nums[idx] > nums[prevIdx]){
            take = 1 + getMaxLen(idx + 1, idx, n, nums);
        }
        return Math.max(notTake, take);
    }

    //Memoizatio -
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n + 1];
        for(int rows[]: dp){
            Arrays.fill(rows, -1);
        }
        return getMaxLen(0, -1, n, nums, dp);
    }
    private int getMaxLen(int idx, int prevIdx, int n, int[] nums, int[][] dp){
        if(idx == n) return 0;

        if(dp[idx][prevIdx + 1] != -1) return dp[idx][prevIdx + 1];
        //not taking element at idx in our subsequence
        int notTake = getMaxLen(idx + 1, prevIdx, n, nums, dp);

        //taking element at idx if it is greater than element at prevIdx
        int take = 0;
        if(prevIdx == -1 || nums[idx] > nums[prevIdx]){
            take = 1 + getMaxLen(idx + 1, idx, n, nums, dp);
        }
        return dp[idx][prevIdx + 1] = Math.max(notTake, take);
    }


    //Tabulation-
    public int tabu(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n + 1][n + 1];
        //exploring all the possiblities in bottom up manner
        for(int idx = n-1; idx >= 0; idx--){
            for(int prevIdx = idx - 1; prevIdx >= -1; prevIdx--){
                int notTake = dp[idx + 1][prevIdx + 1];
                int take = 0;
                if(prevIdx == -1 || nums[idx] > nums[prevIdx]){
                    take = 1 + dp[idx + 1][idx + 1];
                }
                dp[idx][prevIdx + 1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }

    //Space Optimization-
    public int spaceOpt(int[] nums) {
        int n = nums.length;
        int curr[] = new int[n + 1];
        int ahead[] = new int[n + 1];
        //exploring all the possiblities in bottom up manner
        for(int idx = n-1; idx >= 0; idx--){
            for(int prevIdx = idx - 1; prevIdx >= -1; prevIdx--){
                int notTake = ahead[prevIdx + 1];
                int take = 0;
                if(prevIdx == -1 || nums[idx] > nums[prevIdx]){
                    take = 1 + ahead[idx + 1];
                }
                curr[prevIdx + 1] = Math.max(take, notTake);
            }
            ahead = curr;
        }
        return curr[0];
    }

    //Another Approach
    public int anotherApproach(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int lis = 0;
        Arrays.fill(dp, 1);

        for(int i = 0; i < n; i++){
            for(int prev = 0; prev < i; prev++){
                if(nums[prev] < nums[i]){
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                }
            }
            lis = Math.max(lis, dp[i]);
        }
        return lis;
    }
}

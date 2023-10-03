package dynamicProgramming;
import java.util.*;
public class MaximumSumOfNonAdjacent {
    public static void main(String[] args) {
        int nums[] = {2,1,4,9};
        System.out.println("Recur: " + rec(3, nums));
        System.out.println("Memo: " + memo(3,nums));
        System.out.println("Tabu: "+ tabu(3, nums));
        System.out.println("Space: " + space(3, nums));
    }
    //Recursion
    private static int rec(int idx, int[] nums){
        if(idx == 0) return nums[0];
        if(idx < 0) return 0;

        int take = nums[idx] + rec(idx - 2, nums);
        int notTaken = 0 + rec(idx - 1, nums);
        return Math.max(take, notTaken);
    }
    //Memoization
    private static int memo(int idx, int[] nums){
        int dp[] = new int[idx + 1];
        Arrays.fill(dp, -1);
        return memoHelp(idx, nums,dp);
    }
    private static int memoHelp(int idx, int[] nums, int[] dp){
        if(idx == 0) return nums[0];
        if(idx < 0) return 0;
        if(dp[idx] != -1) return dp[idx];

        int take = nums[idx] + memoHelp(idx - 2, nums, dp);
        int notTake = 0 + memoHelp(idx - 1, nums, dp);
        return dp[idx] = Math.max(take, notTake);
    }

    //Tabulation
    private static int tabu(int idx, int[] nums){
        int dp[] = new int[idx + 1];
        dp[0] = nums[0];
        int neg = 0;
        for(int i = 1; i <= idx; i++){
            int take = nums[idx];
            if(i > 1){
                take += dp[i - 2];
            }
            int notTake = dp[i - 1];
            dp[i] = Math.max(take, notTake);
        }
        return dp[idx - 1];
    }
    //space optimization
    private static int space(int idx, int[] nums){
        int prev = nums[0];
        int prev2 = 0;
        for(int i = 1; i <= idx; i++){
            int take = nums[i];
            if(i > 1) take += prev2;
            int notTake = prev;
            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}

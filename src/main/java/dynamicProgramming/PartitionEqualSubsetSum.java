package dynamicProgramming;
import java.util.*;
public class  PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int item: nums){
            sum += item;
        }
        if(sum % 2 != 0) return false;
        int n = nums.length;
        int k = sum / 2;
        int dp[][] = new int[n][k+1];
        for(int rows[] : dp){
            Arrays.fill(rows, -1);
        }
        return getSubset(n - 1, k, nums, dp);
    }
    private boolean getSubset(int idx, int target, int nums[], int dp[][]){
        if(target == 0) return true;
        if(idx == 0) return nums[idx] == target;
        if(dp[idx][target] != -1) return dp[idx][target] != 0;
        boolean take = false;
        if(nums[idx] <= target){
            take = getSubset(idx - 1, target - nums[idx], nums, dp);
        }
        boolean notTake = getSubset(idx - 1, target, nums, dp);
        dp[idx][target] = take || notTake ? 1 : 0;
        return take || notTake;
    }
}

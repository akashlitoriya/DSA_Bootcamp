package dynamicProgramming;
import java.util.*;
public class PartitionWithGivenDifference {
    //Memoization
    public static int countPartitions(int n, int d, int[] arr) {
        int total = 0;
        for(int item: arr){
            total+= item;
        }
        if(total - d < 0 || (total - d) % 2 != 0){
            return 0;
        }
        int target = (total-d)/2;
        int dp[][] = new int[n][target+1];
        for(int rows[]:dp){
            Arrays.fill(rows, -1);
        }
        return getSubsets(n-1, target, arr, dp) % ((int)Math.pow(10,9) + 7);
    }
    private static int getSubsets(int idx, int target, int nums[], int dp[][]){
        if(idx == 0){
            if(target == 0 && nums[0] == 0){
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
            take = getSubsets(idx-1, target-nums[idx], nums, dp);
        }
        int notTake = getSubsets(idx-1, target, nums, dp);
        dp[idx][target] = take + notTake;
        return take+notTake;
    }

    //Tabulation

}

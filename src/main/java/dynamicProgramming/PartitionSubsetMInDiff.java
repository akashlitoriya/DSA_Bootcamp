package dynamicProgramming;

public class PartitionSubsetMInDiff {
    public static int minSubsetSumDifference(int []arr, int n) {
        int totalSum = 0;
        for(int item: arr){
            totalSum += item;
        }

        boolean dp[][] = new boolean[n][totalSum + 1];
        for(int i = 0; i < n; i++){
            dp[i][0] = true;
        }
        dp[0][arr[0]] = true;
        for(int idx = 1; idx < n; idx++){
            for(int target = 1; target <= totalSum; target++){
                boolean notTake = dp[idx-1][target];
                boolean take = false;
                if(arr[idx] <= target) take = dp[idx-1][target-arr[idx]];
                dp[idx][target] = take || notTake;
            }
        }
        int mini = (int)1e8;
        for(int i = 0; i <= totalSum / 2; i++){
            if(dp[n-1][i]){
                int s1 = i;
                int s2 = totalSum - s1;
                mini = Math.min(mini, Math.abs(s1 - s2));
            }
        }
        return mini;
    }
}

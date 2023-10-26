package dynamicProgramming;

public class SubsetSumK {
    //Recursion
    public static boolean subsetSumToK(int n, int k, int arr[]){
        return getSubsets(0,k,arr);
    }
    private static boolean getSubsets(int idx, int target, int arr[]){
        if(target < 0){
            return false;
        }
        if(target == 0){
            return true;
        }
        if(idx >= arr.length){
            return false;
        }
        boolean take = getSubsets(idx+1,target - arr[idx], arr);
        if(take){
            return true;
        }
        boolean notTake = getSubsets(idx + 1, target, arr);
        return take || notTake;
    }

    //Memoization
    private static boolean getSubsets(int idx, int target, int arr[], int[][] dp){
        if(target == 0) return true;
        if(idx == 0) return arr[idx] == target;
        if(dp[idx][target] != -1){
            return dp[idx][target] == 0? false:true;
        }
        boolean take = false;
        if(arr[idx] <= target){
            take = getSubsets(idx-1, target-arr[idx], arr, dp);
        }
        boolean notTake = getSubsets(idx-1, target, arr, dp);
        dp[idx][target] = take || notTake ? 1:0;
        return take || notTake;
    }

    //Tabulation
    public static boolean Tabu(int n, int k, int arr[]){
        if(k == 0)return true;
        boolean dp[][] = new boolean[n][k+1];
        for(int i = 0; i< n; i++){
            dp[i][0] = true;
        }
        if(arr[0]<=k)
            dp[0][arr[0]] = true;
        for(int idx = 1; idx < n; idx++){
            for(int target = 1; target <= k; target++){
                boolean notTake = dp[idx-1][target];
                boolean take = false;
                if(arr[idx] <= target)
                    take = dp[idx-1][target-arr[idx]];
                dp[idx][target] = take || notTake;
            }
        }
        return dp[n-1][k];
    }

    //Space optimization
    public static boolean spaceOptimization(int n, int k, int arr[]){
        if(k == 0)return true;
        boolean dp[] = new boolean[k+1];
        dp[0] = true;
        if(arr[0] <= k)
            dp[arr[0]] = true;
        for(int idx = 1; idx < n; idx++){
            boolean curr[] = new boolean[k + 1];
            curr[0] = true;
            for(int target = 1; target <= k; target++){
                boolean notTake = dp[target];
                boolean take = false;
                if(arr[idx] <= target)
                    take = dp[target-arr[idx]];
                curr[target] = take | notTake;
            }
            dp=curr;

        }
        return dp[k];
    }
}

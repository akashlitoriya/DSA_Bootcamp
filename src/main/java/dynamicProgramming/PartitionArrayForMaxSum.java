package dynamicProgramming;

public class PartitionArrayForMaxSum {
    private int getMaxSum(int i, int k, int arr[], int dp[]){
        if(i == arr.length) return 0;
        if(dp[i] != -1) return dp[i];
        int max = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        for(int j = i; j < Math.min(i + k, arr.length); j++){
            max = Math.max(arr[j], max);
            int sum = max * (j - i + 1) + getMaxSum(j + 1, k, arr, dp);
            ans = Math.max(sum, ans);
        }
        return dp[i] = ans;
    }
    private int getMaxSum(int arr[], int k){
        int n = arr.length;
        int dp[] = new int[n + 1];
        for(int i = n-1; i >= 0; i--){
            int max = Integer.MIN_VALUE;
            int maxAns = Integer.MIN_VALUE;
            for(int j = i; j < Math.min(n, i + k); j++){
                max = Math.max(max, arr[j]);
                int sum = max * (j - i + 1) + dp[j + 1];
                maxAns = Math.max(maxAns, sum);
            }
            dp[i] = maxAns;
        }
        return dp[0];
    }
}

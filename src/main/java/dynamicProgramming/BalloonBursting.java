package dynamicProgramming;
import java.util.Arrays;
public class BalloonBursting {
    //Memoization
    public int memo(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n + 2];
        for(int i = 0; i < n; i++){
            arr[i + 1] = nums[i];
        }
        arr[0] = 1;
        arr[n + 1] = 1;
        int dp[][] = new int[n + 2][n + 2];
        for(int rows[]: dp){
            Arrays.fill(rows, -1);
        }
        return getCoins(1, n, arr, dp);
    }
    private int getCoins(int i, int j, int[] nums, int[][] dp){
        if(i > j){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int maxi = Integer.MIN_VALUE;
        for(int idx = i; idx <=j; idx++){
            int coins = nums[i - 1] * nums[idx] * nums[j + 1] + getCoins(i, idx - 1, nums, dp) + getCoins(idx + 1, j, nums, dp);
            maxi = Math.max(maxi, coins);
        }
        return dp[i][j] = maxi;
    }

    //Tabulation
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n + 2];
        for(int i = 0; i < n; i++){
            arr[i + 1] = nums[i];
        }
        arr[0] = 1;
        arr[n + 1] = 1;
        int dp[][] = new int[n + 2][n + 2];

        for(int i = n; i >= 1; i--){
            for(int j = i; j <=n; j++){
                int maxi = Integer.MIN_VALUE;
                for(int idx = i; idx <= j; idx++){
                    int coins = arr[i - 1] * arr[idx] * arr[j + 1] + dp[i][idx-1] + dp[idx + 1][j];
                    maxi = Math.max(maxi, coins);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][n];
    }
}

package dpQuestion;

public class Session20 {
    public static void main(String[] args) {
        int arr[] = {5, 10, -2, -8, -1};
        System.out.println(getMaxSum(arr));
    }
    private static int getMaxSum(int nums[]){
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        for(int i = 1; i < n; i++){
            dp[i][0] = nums[i] + Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = -nums[i] + dp[i-1][0];

        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}

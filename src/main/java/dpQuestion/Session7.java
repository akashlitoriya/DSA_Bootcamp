package dpQuestion;

public class Session7 {
    public static void main(String[] args) {
        int arr[] = {5, 8, 3, 100, -5, -5, 5, 10};
        System.out.println(getMaxSum(arr));
    }
    private static int getMaxSum(int arr[]){
        int n = arr.length;
        int dp[] = new int[n];
        dp[0] = arr[0];
        dp[1] = arr[1] + dp[0];
        dp[2] = arr[2] + dp[1];
        dp[3] = Math.max(arr[3] + dp[2], arr[3] + dp[0]);
        for(int i = 4; i < n; i++){
            int max = arr[i] + dp[i - 1];
            max = Math.max(arr[i] + dp[i - 3], max);
            if(i - 5 >= 0)
            max = Math.max(arr[i] + dp[i - 5], max);
            dp[i] = max;
        }
        return dp[n - 1];
    }
}

package OAQuestions;

public class KPartitionsGoogleGirlOA {
    public static void main(String[] args) {
        int arr[] = {-3, -1, -3};
        System.out.println(maxSum(arr));
    }
    private static int maxSum(int arr[]){
        int n = arr.length;
        int dp[][] = new int[n][2];
        dp[0][0] = arr[0];
        dp[0][1] = Integer.MIN_VALUE;
        for(int i = 1; i < n; i++){
            //positive sign
            dp[i][0] = arr[i] + Math.max(dp[i - 1][0], dp[i - 1][1]);
            //negative sign
            dp[i][1] = -arr[i] + dp[i - 1][0];
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}

package dpQuestion;

public class AmazonMLMinCost1 {
    public static void main(String[] args) {
        int arr[] = {4, 12,13,18,10,12};
        System.out.println(getMinCost(arr));
    }
    private static int getMinCost(int arr[]){
        int n = arr.length;
        int dp[] = new int[n];
        dp[0] = 0;
        dp[1] = Math.abs(arr[1] - arr[0]);
        dp[2] = Math.abs(arr[2] - arr[1]) + dp[1];
        for(int i = 3; i < n; i++){
            int oneStep = Math.abs(arr[i] - arr[i - 1]) + dp[i - 1];
            int threeStep = Math.abs(arr[i] - arr[i - 3]) + dp[i - 3];
            dp[i] = Math.min(oneStep, threeStep);
        }
        return dp[n - 1];
    }
}

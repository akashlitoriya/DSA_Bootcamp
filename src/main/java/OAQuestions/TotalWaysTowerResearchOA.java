package OAQuestions;

public class TotalWaysTowerResearchOA {
    public static void main(String[] args) {

    }
    private static int getTotalWays(int arr[]){
        int n = arr.length;
        int dp[] = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i < n; i++){
            dp[i] = dp[i - 1];
            if(arr[i - 2] == 2){
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}

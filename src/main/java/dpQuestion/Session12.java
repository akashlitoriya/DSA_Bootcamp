package dpQuestion;
import java.util.Arrays;
public class Session12 {
    public static void main(String[] args) {
        int arr[] = {2, 10, 8, -5, -10, 5};
        System.out.println(getMinCost(arr));
    }
    private static int getMinCost(int cost[]){
        int n = cost.length;
        int dp[][] = new int[n][2];
        for(int row[]: dp){
            Arrays.fill(row, (int)1e8);
        }
        dp[0][0] = cost[0]; //forward jump
        dp[1][0] = cost[1] + dp[0][0];
        for(int i = 2; i < n; i++){
            //reaching ith index with backward jump ie. (i + 1) -> i
            if(i < n - 1) {
                dp[i][1] = cost[i] + cost[i + 1] + dp[i - 1][0];   //as no consecutive backward are possible.
            }

            //reaching ith index with forward jump i.e. (i - 2) -> i
            dp[i][0] = cost[i] + Math.min(dp[i-2][0], dp[i - 2][1]);   //reaching i with forward so it might possible that we have
            //reached i - 2 with either forward or backward jump. so we will take max of both
        }
        return Math.min(dp[n-1][0], Math.max(dp[n - 2][0], dp[n - 2][1]));
    }
}

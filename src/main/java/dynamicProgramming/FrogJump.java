package dynamicProgramming;
import java.util.*;
public class FrogJump {
    public static void main(String[] args) {
        int height[] = {10,20,30,10};
        System.out.println(recFrog(3,height));
    }
    //Recursion
    private static int recFrog(int n, int[] height){
        if(n == 0){
            return 0;
        }
        int left = recFrog(n - 1, height) + Math.abs(height[n] - height[n-1]);
        int right = Integer.MAX_VALUE;
        if(n > 1) right = recFrog(n-2, height) + Math.abs(height[n] - height[n - 2]);

        return Math.min(left, right);
    }
    //Memoization
    private static int memoFrog(int n, int [] height){
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return memo(n, height, dp);
    }
    private static int memo(int n, int[] height, int[] dp){
        if(n == 0){
            return 1;
        }
        if(dp[n] != -1) return dp[n];
        int left = memo(n - 1, height, dp) + Math.abs(height[n] - height[n - 1]);
        int right = Integer.MAX_VALUE;
        if(n > 1) right = memo(n - 2, height, dp) + Math.abs(height[n] - height[n - 2]);
        return dp[n] = Math.min(left, right);
    }

    //Tabulation
    private static int tabFrog(int n, int height[]){
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            int fs = dp[i - 1] + Math.abs(height[i] - height[i - 1]);
            int ss = Integer.MAX_VALUE;
            if(i > 1){
                ss = dp[i - 2] + Math.abs(height[i] - height[i - 2]);
            }
            dp[i] = Math.min(fs,ss);
        }
        return dp[n - 1];
    }
    private static int optFrog(int n, int[] height){
        int prev2i = 0;
        int previ = 0;
        for(int i = 1; i <= n; i++){
            int left = previ + Math.abs(height[i] - height[i - 1]);
            int right = Integer.MAX_VALUE;
            if(i > 1) right = prev2i + Math.abs(height[i] - height[i - 2]);
            int curri = Math.min(left, right);
            prev2i = previ;
            previ = curri;
        }
        return previ;
    }
}

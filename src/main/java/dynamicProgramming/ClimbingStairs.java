package dynamicProgramming;
import java.util.*;
public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(getTotalWays(3));
    }
    //Recursion
    private static int getTotalWays(int n){
        if(n == 0){
            return 1;
        }
        int count = 0;
        if(n - 1 >= 0) count += getTotalWays(n - 1);
        if(n - 2 >= 0) count += getTotalWays(n - 2);
        return count;
    }

    //Memoization - T.C = O(N) S.C. = O(N)
    public static int climbStairs(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp , -1);
        return getAll(n, dp);
    }
    private static int getAll(int n, int[] dp){
        if(n == 0) return 1;

        if(n == 1) return 1;

        if(dp[n] != -1) return dp[n];

        return dp[n] = getAll(n - 1, dp) + getAll(n - 2, dp);
    }
}

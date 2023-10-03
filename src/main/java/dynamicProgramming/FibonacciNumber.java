package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println("Recursion - " + getFibo(5));
        System.out.println("Memoization - " + fibo(5));
        System.out.println("Tabulation - " + tabFibo(5));
        System.out.println("Optimized - " + optFibo(5));
    }
    //Recursion without memoization
    private static int getFibo(int n){
        if(n <= 1){
            return n;
        }
        return getFibo(n - 1) + getFibo(n - 2);
    }
    //DP memoization
    private static int fibo(int n){
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return memoFibo(n,dp);
    }
    private static int memoFibo(int n, int[] dp){
        if(n <= 1) return n;
        if(dp[n] != -1) return dp[n];

        return dp[n] = memoFibo(n - 1, dp) + memoFibo(n - 2, dp);
    }
    //DP tabulation
    private static int tabFibo(int n){
        //step 1- declare dp
        int[] dp = new int[n + 1];
        //setting base case
        dp[0] = 0;
        dp[1] = 1;
        //finding rest solution using this
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //Optimized tabulation method
    private static int optFibo(int n){
        int prev2 = 0;
        int prev = 1;
        for(int i = 2; i <= n; i++){
            int curri = prev + prev2;
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }
}

package dynamicProgramming;
import java.util.*;
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        String s2 = reverse(s);
        int n = s.length();
        int dp[][] = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return lcs(n-1, n-1, s, s2, dp);
    }
    private int lcs(int i, int j, String s1, String s2, int[][] dp){
        if(i<0 || j < 0){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + lcs(i - 1, j - 1, s1, s2, dp);
        }
        return dp[i][j] =  Math.max(lcs(i - 1, j, s1, s2, dp), lcs(i, j - 1, s1, s2, dp));
    }
    private String reverse(String str){
        String rev = "";
        for(int i = str.length() - 1; i >= 0; i--){
            rev += str.charAt(i);
        }
        return rev;
    }

    //Tabulation code
    public int tabu(String s) {
        String s2 = reverse(s);
        int n = s.length();
        int dp[][] = new int[n + 1][n + 1];
        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j <= n; j++){
            dp[0][j] = 0;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][ j - 1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
}

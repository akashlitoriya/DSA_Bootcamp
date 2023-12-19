package dynamicProgramming;
import java.util.Arrays;
public class LongestCommonSubsequence {
    //Recursion
    private int f(int idx1, int idx2, String str1, String str2){
        if(idx1 < 0 || idx2 < 0) return 0;

        if(str1.charAt(idx1) == str2.charAt(idx2)){
            return 1 + f(idx1 - 1, idx2 - 1, str1, str2);
        }
        return 0 + Math.max(f(idx1 - 1, idx2, str1, str2), f(idx1, idx2 - 1, str1, str2));
    }

    //Memoization solution
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n][m];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return f(n-1, m-1, text1, text2, dp);
    }
    private int f(int idx1, int idx2, String str1, String str2, int[][] dp){
        if(idx1 < 0 || idx2 < 0) return 0;

        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if(str1.charAt(idx1) == str2.charAt(idx2)){
            return dp[idx1][idx2] =  1 + f(idx1 - 1, idx2 - 1, str1, str2, dp);
        }
        return dp[idx1][idx2] =  0 + Math.max(f(idx1 - 1, idx2, str1, str2, dp), f(idx1, idx2 - 1, str1, str2, dp));
    }

    //Tabulation
    public int tabu(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n + 1][m + 1]; //Shifting of the index

        //Handling base cases
        //when either i or j is negative
        for(int j = 0; j <= m; j++){
            dp[0][j] = 0;
        }
        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;
        }

        // Bottom up
        for(int idx1 = 1; idx1 <= n; idx1++){
            for(int idx2 = 1; idx2 <= m; idx2++){

                // iF Character matched
                if(text1.charAt(idx1 - 1) == text2.charAt(idx2 - 1)){
                    dp[idx1][idx2] = 1 + dp[idx1 - 1][idx2 - 1];
                }else{
                    //if character not matched
                    dp[idx1][idx2] = Math.max(dp[idx1 - 1][idx2] , dp[idx1][idx2 - 1]);
                }
            }
        }
        return dp[n][m];

    }
}

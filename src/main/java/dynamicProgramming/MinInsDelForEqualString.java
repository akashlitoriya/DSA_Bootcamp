package dynamicProgramming;

public class MinInsDelForEqualString {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n + 1][m + 1];
        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j <= m; j++){
            dp[0][j] = 0;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return n + m - 2 * dp[n][m];
    }
}

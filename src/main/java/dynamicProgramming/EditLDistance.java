package dynamicProgramming;

public class EditLDistance {
    //Recursion - T.C = Exponential  S.C = O(N + M)
    private int recur(int i, int j, String word1, String word2){
        if(i < 0)  //s1 exhausted so insert the remaining character of s2 into s1
            return j + 1;
        if(j < 0)  // s2 exhausted so delete the remaining character of s1
            return i + 1;

        if(word1.charAt(i) == word2.charAt(j)){
            return recur(i-1, j-1, word1, word2);   //as character matches so 0 operation and reduce the size of both
        }

        int insert = 1 + recur(i, j-1, word1, word2);
        int delete = 1 + recur(i - 1, j, word1, word2);
        int replace = 1 + recur(i - 1, j - 1, word1, word2);
        return Math.min(insert, Math.min(delete, replace));
    }

    // Memoization - T.C = O(nxm)  S.C = O(nxm) + O(n + m)
    private int memo(int i, int j, String word1, String word2, int[][] dp){
        if(i < 0)  //s1 exhausted so insert the remaining character of s2 into s1
            return j + 1;
        if(j < 0)  // s2 exhausted so delete the remaining character of s1
            return i + 1;

        if(dp[i][j] != -1) return dp[i][j];
        if(word1.charAt(i) == word2.charAt(j)){
            return dp[i][j] = memo(i-1, j-1, word1, word2, dp);
        }

        int insert = 1 + memo(i, j-1, word1, word2, dp);
        int delete = 1 + memo(i - 1, j, word1, word2, dp);
        int replace = 1 + memo(i - 1, j - 1, word1, word2, dp);
        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }


    //Tabulation - T.C = O(n x m)  S.C = O(n x m)
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n + 1][m + 1];
        //handling s1 exhaust case
        for(int j = 0; j <=m; j++){
            dp[0][j] = j;   //1-based indexing so not added 1 to answer
        }
        for(int i = 1; i <= n; i++){
            dp[i][0] = i;   //1-based indexing so not added 1 to answer
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int insert = 1 + dp[i][j-1];
                    int delete = 1 + dp[i-1][j];
                    int replace = 1 + dp[i-1][j-1];
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[n][m];
    }

    //Space optimized solution
    public int spaceOptimized(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if(n == 0) return m;
        if(m == 0) return n;
        int curr[] = new int[m + 1];
        int prev[] = new int[m + 1];
        //handling s1 exhaust case
        for(int j = 0; j <= m; j++){
            prev[j] = j;
        }

        for(int i = 1; i <= n; i++){
            curr[0] = i;
            for(int j = 1; j <= m; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    curr[j] = prev[j-1];
                }else{
                    int insert = curr[j-1];
                    int delete = prev[j];
                    int replace = prev[j-1];
                    curr[j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
            prev = curr.clone();
        }
        return curr[m];
    }
}

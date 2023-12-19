package dynamicProgramming;
import java.util.*;
public class DistinctSubsequences {
    //Recursion
    public int numDistinctRec(String s, String t) {
        int n = s.length();
        int m = t.length();
        return rec(n-1, m-1, s, t);
    }
    private int rec(int i, int j, String s1, String s2){
        if(j < 0){
            return 1;
        }
        if(i < 0){
            return 0;
        }

        //character matched
        if(s1.charAt(i) == s2.charAt(j)){
            return rec(i-1,j-1,s1,s2) + rec(i-1, j, s1, s2);
        }else{
            return rec(i-1, j, s1, s2);
        }
    }

    //Memoization
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n][m];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return rec(n-1, m-1, s, t, dp);
    }
    private int rec(int i, int j, String s1, String s2, int dp[][]){
        if(j < 0){
            return 1;
        }
        if(i < 0){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        //character matched
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = rec(i-1,j-1,s1,s2, dp) + rec(i-1, j, s1, s2, dp);
        }else{
            return dp[i][j] = rec(i-1, j, s1, s2, dp);
        }
    }

    //Tabulation
    public int tabulation(String s, String t) {
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n + 1][m + 1];
        for(int i = 0; i <= n; i++) dp[i][0] = 1; //handling when s2 exhauted
        for(int j = 1; j <= m; j++) dp[0][j] = 0; //when s1 exhausted and in s2 we have some character to matched -- dp[0][0] special case
        //Exploring all Posibilities
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];  //pick and not-pick
                }else{
                    dp[i][j] = dp[i-1][j];  //character not matched
                }
            }
        }
        return dp[n][m];
    }

    //Space optimization using 2 1-d array
    public int spaceOpt1(String s, String t){
        int n = s.length();
        int m = t.length();
        int prev[] = new int[m + 1]; //row represents the idx of s and column represent the index of t
        int curr[] = new int[m + 1];
        //Base case handle when s2 exhausted
        prev[0] = 1;
        curr[0] = 1;
        //Exploring all the possibilities
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    curr[j] = prev[j-1] + prev[j];
                }else{
                    curr[j] = prev[j];
                }
            }
            prev = curr;
        }
        return prev[m];
    }

    //1-D Array Optimization
    public int spaceOpt2(String s, String t){
        int n = s.length();
        int m = t.length();

        int curr[] = new int[m + 1];
        curr[0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = m; j >= 1; j--){  //started filling values from the backside, so that we will have unmodified value of
                                            // j and j - 1;
                if(s.charAt(i-1) == t.charAt(j-1)){
                    curr[j] = curr[j] + curr[j - 1];
                }else{
                    curr[j] = curr[j];
                }
            }
        }
        return curr[m];
    }
}



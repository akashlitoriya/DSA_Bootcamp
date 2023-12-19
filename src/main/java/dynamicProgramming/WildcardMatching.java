package dynamicProgramming;

public class WildcardMatching {
    //Recursion
    private boolean recur(int i, int j, String s1, String s2){
        if(i<0 && j < 0) return true;
        if(i<0 && j >= 0) return false;
        if(j < 0 && i >=0){
            for(int p = 0; p <= i; p++){
                if(s1.charAt(p) != '*'){
                    return false;
                }
            }
            return true;
        }
        if(s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?'){
            return recur(i-1, j-1, s1, s2);
        }
        if(s1.charAt(i) == '*'){
            return recur(i-1, j, s1,s2) || recur(i, j-1, s1, s2);
        }
        return false;
    }

    //Memoization
    private boolean memo(int i, int j, String s1, String s2, int dp[][]){
        if(i<0 && j < 0) return true;
        if(i<0 && j >= 0) return false;
        if(j < 0 && i >=0){
            for(int p = 0; p <= i; p++){
                if(s1.charAt(p) != '*'){
                    return false;
                }
            }
            return true;
        }
        if(dp[i][j] != -1) return dp[i][j] == 0 ? false : true;
        if(s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?'){
            boolean ans = recur(i-1, j-1, s1, s2, dp);
            dp[i][j] = ans? 1: 0;
            return ans;
        }
        if(s1.charAt(i) == '*'){
            boolean ans = recur(i-1, j, s1,s2, dp) || recur(i, j-1, s1, s2, dp);
            dp[i][j] = ans? 1: 0;
            return ans;
        }
        dp[i][j] = 0;
        return false;
    }

    //Tabulation
    public boolean tabu(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean dp[][] = new boolean[m + 1][n + 1];
        dp[0][0] = true; //s1 and s2 both exhausted
        for(int j = 1; j <= n; j++){
            dp[0][j] = false;  //s1 exhausted but s2 has some character to match
        }

        for(int i = 1; i <= m; i++){   //s2 exhausted but s1 has some character
            boolean flag = true;
            for(int q = 0; q < i; q++){
                if(p.charAt(q) != '*'){
                    flag = false;
                    break;
                }
            }
            dp[i][0] = flag;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(i-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }
}

package dynamicProgramming;

public class PrintLCS {
    public static String findLCS(int n, int m, String s1, String s2){
        int dp[][] = new int[n + 1][m + 1];
        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;

        }
        for(int j = 0; j <= m; j++){
            dp[0][j] = 0;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j - 1]);
                }
            }
        }

        //Till now we have generated the dp now we will print the ans;
        int len = dp[n][m];
        char ans[] = new char[len];
        int idx = len - 1;
        int i = n;
        int j = m;
        while(i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j - 1)){
                ans[idx] = s1.charAt(i-1);
                idx--;
                i--;
                j--;
            }else if(dp[i - 1][j] > dp[i][j - 1]){
                i = i - 1;
            }else{
                j = j - 1;
            }
        }
        String str = "";
        for(int p = 0; p < len; p++){
            str += ans[p];
        }
        return str;
    }
}

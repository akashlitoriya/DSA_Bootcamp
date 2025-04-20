package dpQuestion;

import java.util.Scanner;

public class Session8{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[][] = new int[n][3];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 3; j++){
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(getMaxScore(arr));
    }
    private static int getMaxScore(int arr[][]){
        int n = arr.length;
        int dp[][] = new int[n][3];
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 3; j++){
                for(int prev = 0; prev < 3; prev++){
                    if(prev != j){
                        dp[i][j] = Math.max(dp[i][j], arr[i][j] + dp[i-1][prev]);
                    }
                }
            }
        }
        int ans = Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2]));
        return ans;
    }
}

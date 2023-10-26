package dynamicProgramming;

import java.util.Arrays;

public class MaxMinFallingPathSum {
    //Recursion
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            int path = f(n - 1, i, matrix);
            min = Math.min(min, path);
        }
        return min;
    }
    private int f(int row, int col, int[][] matrix){
        if(col < 0 || col >= matrix[0].length) return (int)1e9;

        if(row == 0) return matrix[row][col];

        int up = matrix[row][col] + f(row-1, col, matrix);
        int left = matrix[row][col] + f(row - 1, col - 1, matrix);
        int right = matrix[row][col] + f(row - 1, col + 1, matrix);

        return Math.min(up,Math.min(left, right));
    }

    //Memoisation
    public int minFallingPathSum2(int[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;

        int min = Integer.MAX_VALUE;

        int dp[][] = new int[n][m];
        for(int []row : dp){
            Arrays.fill(row, -1);
        }

        for(int i = 0; i < m; i++){
            int path = f(n - 1, i, matrix, dp);
            min = Math.min(min, path);
        }
        return min;
    }
    private int f(int row, int col, int[][] matrix, int[][] dp){
        if(col < 0 || col >= matrix[0].length) return (int)1e9;

        if(row == 0) return dp[row][col] = matrix[row][col];
        if(dp[row][col] != -1) return dp[row][col];
        int up = matrix[row][col] + f(row-1, col, matrix, dp);
        int left = matrix[row][col] + f(row - 1, col - 1, matrix, dp);
        int right = matrix[row][col] + f(row - 1, col + 1, matrix, dp);

        return dp[row][col] = Math.min(up,Math.min(left, right));
    }

    //Tabulation
    public int Tabulation(int[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;

        int dp[][] = new int[n][m];
        //filling base cases
        for(int i = 0; i < m; i++){
            dp[0][i] = matrix[0][i];

        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                int up = matrix[i][j] + dp[i-1][j];
                int left = matrix[i][j];
                if(j >= 1){
                    left += dp[i-1][j-1];
                }else{
                    left += (int)1e9;
                }
                int right = matrix[i][j];
                if(j < m-1){
                    right += dp[i - 1][j + 1];
                }else{
                    right += (int) 1e9;
                }

                dp[i][j] = Math.min(up, Math.min(left, right));
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            min=Math.min(min, dp[n-1][i]);
        }

        return min;

    }
    //Space optimization
    public int spaceOptimized(int[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;

        int dp[] = new int[m];
        for(int i = 0; i < m; i++){
            dp[i] = matrix[0][i];
        }

        for(int i = 1; i < n; i++){
            int temp[] = new int[m];
            for(int j = 0; j < m; j++){
                int up = matrix[i][j] + dp[j];
                int left = matrix[i][j];
                if(j > 0){
                    left += dp[j - 1];
                }else{
                    left += (int) 1e9;
                }
                int right = matrix[i][j];
                if(j < m-1){
                    right += dp[j + 1];
                }else{
                    right += (int) 1e9;
                }
                temp[j] = Math.min(up, Math.min(left, right));
            }
            dp = temp;
        }
        int min = dp[0];
        for(int i = 1; i < m; i++){
            min = Math.min(min, dp[i]);
        }
        return min;
    }
}

package dynamicProgramming;

public class MinPathSumGrid {
    //recursion
    public int recur(int row, int col, int[][] grid){
        if(row == 0&& col == 0){
            return grid[0][0];
        }
        if(row < 0 || col < 0){
            return Integer.MAX_VALUE;
        }
        int top = grid[row][col] + recur(row - 1, col, grid);
        int left = grid[row][col] + recur(row, col - 1, grid);
        return Math.min(top, left);
    }
    //Memoization
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        return memo(m - 1,n - 1,grid, dp);
    }
    private int memo(int row, int col, int[][] grid, int[][] dp){
        if(row == 0 && col == 0){
            return grid[row][col];
        }
        if(row < 0 || col < 0) return Integer.MAX_VALUE - 200;
        if(dp[row][col] != -1) return dp[row][col];
        int top = 0;
        top = grid[row][col] + memo(row - 1, col, grid, dp);

        int left = 0;
        left = grid[row][col] + memo(row, col - 1, grid, dp);

        return dp[row][col] = Math.min(top, left);
    }

    //Tabulation
    public int tabu(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        dp[0][0] = grid[0][0];
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(row == 0 && col == 0){
                    dp[row][col] = grid[row][col];
                }else{
                    int top = grid[row][col];
                    if(row > 0){ top += dp[row - 1][col];}
                    else{top += Integer.MAX_VALUE - 200;}
                    int left = grid[row][col];
                    if(col > 0){
                        left = left + dp[row][col - 1];
                    }
                    else{left += Integer.MAX_VALUE - 200;}
                    dp[row][col] = Math.min(top, left);
                }
            }
        }
        return dp[m-1][n-1];
    }
}

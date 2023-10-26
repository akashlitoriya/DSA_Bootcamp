package dynamicProgramming;

import java.util.Arrays;

public class CherryPickup {
    //Recursion solution
    public static int recur(int r, int c, int[][] grid){
        return getMax(0,0,c-1, grid);
    }
    private static int getMax(int r, int c1, int c2, int[][] grid){
        if(c1 < 0 || c1 >= grid[0].length || c2 < 0 || c2 >= grid[0].length){
            return (int)-1e9;
        }
        if(r == grid.length - 1){
            if(c1 == c2){
                return grid[r][c1];
            }else{
                return grid[r][c1] + grid[r][c2];
            }
        }
        int max = 0;
        for(int a = -1; a <= 1; a++){
            for(int b = -1; b <= 1; b++){
                int candies = 0;
                if(c1 == c2){
                    candies = grid[r][c1] + getMax(r + 1, c1 + a, c2 + b, grid);
                }else{
                    candies = grid[r][c1] + grid[r][c2] + getMax(r + 1, c1 + a, c2 + b, grid);
                }
                max = Math.max(max, candies);
            }
        }
        return max;
    }

    //Memoization
    public static int maximumChocolates(int r, int c, int[][] grid) {
        int[][][] dp = new int[r][c][c];
        for (int row1[][] : dp){
            for (int row2[] : row1){
                Arrays.fill(row2, -1);
            }
        }
        return getMax(0,0,c-1, grid, dp);
    }
    private static int getMax(int r, int c1, int c2, int[][] grid, int[][][] dp){
        if(c1 < 0 || c1 >= grid[0].length || c2 < 0 || c2 >= grid[0].length){
            return (int)-1e9;
        }
        if(r == grid.length - 1){
            if(c1 == c2){
                return dp[r][c1][c2] = grid[r][c1];
            }else{
                return dp[r][c1][c2] = grid[r][c1] + grid[r][c2];
            }
        }
        if(dp[r][c1][c2] != -1) return dp[r][c1][c2];
        int max = 0;
        for(int a = -1; a <= 1; a++){
            for(int b = -1; b <= 1; b++){
                int candies = 0;
                if(c1 == c2){
                    candies = grid[r][c1] + getMax(r + 1, c1 + a, c2 + b, grid, dp);
                }else{
                    candies = grid[r][c1] + grid[r][c2] + getMax(r + 1, c1 + a, c2 + b, grid, dp);
                }
                max = Math.max(max, candies);
            }
        }
        return dp[r][c1][c2] = max;
    }

    //Tabulation
    public static int Tabu(int r, int c, int[][] grid) {
        int[][][] dp = new int[r][c][c];
        //base cases handled
        for(int j1 = 0; j1 < c; j1++){
            for(int j2 = 0; j2 < c; j2++){
                if(j1 == j2) dp[r-1][j1][j2] = grid[r-1][j1];
                else dp[r-1][j1][j2] = grid[r-1][j1] + grid[r-1][j2];
            }
        }

        for(int i = r-2; i >= 0; i--){
            for(int j1 = 0; j1 < c; j1++){
                for(int j2 = 0; j2 < c; j2++){
                    int maxi = Integer.MIN_VALUE;
                    for(int dj1 = -1; dj1 <= 1; dj1++){
                        for(int dj2 = -1; dj2 <= 1; dj2++){
                            int value = (int)-1e8;
                            if(j1 == j2){
                                value = grid[i][j1];
                            }else{
                                value = grid[i][j1] + grid[i][j2];
                            }
                            if((j1 + dj1 < 0 || j1 + dj1 >= c) || (j2 + dj2 < 0 || j2 + dj2 >= c)){
                                value += (int)-1e8;
                            }else{
                                value += dp[i + 1][j1 + dj1][j2 + dj2];
                            }
                            maxi = Math.max(maxi, value);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }
        return dp[0][0][c-1];
    }
}

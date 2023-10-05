package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        return recur(0,0,triangle);
    }
    private int recur(int i, int j, List<List<Integer>> triangle){
        if(i == triangle.size() - 1){
            return triangle.get(i).get(j);
        }
        int down = triangle.get(i).get(j) + recur(i + 1, j , triangle);
        int diagonal = triangle.get(i).get(j) + recur(i+1, j+1, triangle);
        return Math.min(down,diagonal);
    }

    //Memoisation
    public static int memo(List<List<Integer>> triangle){
        int dp[][] = new int[triangle.size()][triangle.size()];
        Arrays.fill(dp, -1);
        return memoHelper(0,0,triangle, dp);
    }
    private static int memoHelper(int i, int j, List<List<Integer>> triangle, int[][] dp){
        if(i == triangle.size() - 1){
            return triangle.get(i).get(j);
        }
        if(dp[i][j] != -1) return dp[i][j];

        int down = triangle.get(i).get(j) + memoHelper(i+1, j, triangle, dp);
        int diagonal = triangle.get(i).get(j) + memoHelper(i+1, j+1, triangle, dp);
        return dp[i][j] = Math.min(down, diagonal);
    }
    //Tabulation method
    private int tabu(List<List<Integer>> triangle){
        int n= triangle.size();
        int dp[][] = new int[n][n];
        for(int i = 0; i < n; i++)
            dp[n-1][i] = triangle.get(n-1).get(i);

        for(int i = n-2; i >= 0; i--){
            for(int j = i; j >= 0; j--){
                int down = triangle.get(i).get(j) + dp[i + 1][j];
                int diagonal = triangle.get(i).get(j) + dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, diagonal);
            }
        }
        return dp[0][0];
    }

    //Space Optimization
    private int spaceOPT(List<List<Integer>> triangle){
        int n = triangle.size();
        int dp[] = new int[n];
        for(int i = 0; i < n; i++) dp[i] = triangle.get(n-1).get(i);
        for(int i = n - 2; i >= 0; i--){
            int curr[] = new int[n];
            for(int j = i; j >=0; j--){
                int down = triangle.get(i).get(j) + dp[j];
                int diagonal = triangle.get(i).get(j) + dp[j + 1];
                curr[j] = Math.min(down, diagonal);
            }
            dp = curr;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int [][] triangle = {{2},{3,4},{6,5,7},{4,1,8,3}};
        ArrayList<ArrayList> tri = new ArrayList<>();
        //System.out.println(memo());
    }
}

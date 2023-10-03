package dynamicProgramming;
import java.util.*;
public class NinjaTraining {
    //Recursion
    public static int getMaxPoints(int n, int[][] points){
        return f(n-1, 3, points);
    }
    private static  int f(int day, int last, int[][] points){
        if(day == 0){
            int maxi = 0;
            for(int i = 0; i < 3; i++){
                if(i != last){
                    maxi = Math.max(maxi, points[day][i]);
                }
            }
            return maxi;
        }

        int maxPoints = 0;
        for(int i = 0; i <= 2; i++){
            if(i != last){
                int point = points[day][i] + f(day - 1, i, points);
                maxPoints = Math.max(maxPoints, point);
            }
        }
        return maxPoints;
    }


    //Memoization
    public static int getMemo(int n, int[][] points){
        int dp[][] = new int[n][4];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return memo(n-1,3,points,dp);
    }
    private static int memo(int day, int last, int[][] points, int[][] dp){
        if(day == 0){
            int maxi = 0;
            for(int i = 0; i < 3; i++){
                if(i != last) maxi = Math.max(maxi, points[day][i]);
            }
            return maxi;
        }
        if(dp[day][last] != -1) return dp[day][last];

        int maxPoints = 0;
        for(int i = 0; i < 3; i++){
            if(i != last){
                int point = points[day][i] + memo(day - 1, i, points, dp);
                maxPoints = Math.max(maxPoints, point);
            }
        }
        return dp[day][last] = maxPoints;
    }
    public static int getTabu(int n, int[][] points){
        int dp[][] = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for(int day = 1; day < n; day++){
            for(int last = 0; last < 4; last++){
                int maxPoints = 0;
                for(int i = 0; i < 3; i++){
                    if(i != last){
                        int point = points[day][i] + dp[day - 1][i];
                        maxPoints = Math.max(maxPoints, point);
                    }
                }
                dp[day][last] = maxPoints;
            }
        }
        return dp[n - 1][3];
    }
    public static int getSpaceOpt(int n, int[][] points){
        int prev[]= new int[4];
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for(int day = 1; day < n; day++){
            int[] temp = new int[4];
            for(int last = 0; last < 4; last++){

                for(int i = 0; i < 3; i++){
                    if(i != last){
                        int point = points[day][i] + prev[i];
                        temp[last] = Math.max(temp[last], point);
                    }
                }

            }
            prev = temp;
        }
        return prev[3];
    }
}

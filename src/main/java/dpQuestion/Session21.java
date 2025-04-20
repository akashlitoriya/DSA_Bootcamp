package dpQuestion;

public class Session21 {
    public static void main(String[] args) {

    }
    private static int getMaxScore(int[][] points){
        int n = points.length;
        int dp[][] = new int[n][3];
        dp[0][0] = points[0][0];
        dp[1][0] = points[1][0] + dp[0][0];
        dp[1][1] = 0; //as there is no prev prev day
        dp[1][2] = 0;
        for(int i = 2; i < n; i++){
            //easy task
            dp[i][0] = points[i][0] + Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
            //medium task
            dp[i][1] = points[i][1] + points[i-1][0] + dp[i-2][1];
            //hard task -> if you have performed easy task on day before prev day
            dp[i][2] = points[i][2] + points[i - 1][0] + dp[i-2][0];   //hard -> prev easy -> easy
            if(i-3 >= 0){
                dp[i][2] = Math.max(dp[i][2], points[i][2] + points[i-1][1] + points[i-2][0] + dp[i-3][1]);
                dp[i][2] = Math.max(dp[i][2], points[i][2] + points[i-1][1] + points[i-2][0] + dp[i-3][0]);
            }

        }
        return Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2]));
    }
}

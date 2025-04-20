package dpQuestion;
//https://www.desiqna.in/10567/barclays-sde-coding-oa-questions-and-solutions-set-8-2022-dp
public class Session16 {
    public static void main(String[] args) {
        int earn[][] = {{1,2},{4,10},{20,21},{2,23}};
        System.out.println(getMaxSalary(earn));
    }
    private static int getMaxSalary(int earn[][]){
        int n = earn.length;
        int dp[][] = new int[n][3];
        dp[0][0] = 0;
        dp[0][1] = earn[0][0];
        dp[0][2] = earn[0][1];

        for(int i = 1; i < n; i++){
            //performing no task
            dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
            //performing easy task
            dp[i][1] = earn[i][0] + Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
            //performing hard task
            dp[i][2] = earn[i][1] + dp[i-1][0];
        }
        return Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2]));
    }
}

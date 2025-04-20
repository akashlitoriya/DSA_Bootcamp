package dpQuestion;

public class Session18 {
    public static void main(String[] args) {
        System.out.println(4);
    }
    private static int getNoOfWays(int y){
        int num[] = {1,2,4,6};
        int dp[][] = new int[y + 1][3];
        dp[0][0] = 1; dp[0][1] = 1; dp[0][2] = 1;
        dp[1][0] = 1;
        dp[2][0] = 2;
        dp[3][0] = 3;
        for(int i = 4; i <= y; i++){
            //j -> number of 4 used to reach i
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < num.length; k++){
                    if(num[k] != 4){
                        if(i - num[k] >= 0) dp[i][j] += dp[i - num[k]][0];
                    }else{
                        if(j != 0) dp[i][j] += dp[i - num[k]][j - 1];
                    }
                }
            }
        }
        return dp[y][0] + dp[y][1] + dp[y][2];
    }
}

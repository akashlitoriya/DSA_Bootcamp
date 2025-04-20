package dpQuestion;
//https://docs.google.com/document/d/1diIi3RmKJiL8BypYXLR3Tp9m4PiK_FRNX0Uoy2loLW0/edit
public class Session11 {
    public static void main(String[] args) {

    }
    private static int getMinCost(int n){
        int dp[] = new int[n + 1];
        dp[1] = 0;
        for(int i = 2; i <= n; i++){
            int temp = 1 + dp[i - 1];
            if(i % 2 == 0){
                temp = Math.min(temp, 1 + dp[i / 2]);
            }
            if(i % 3 == 0){
                temp = Math.min(temp, 1 + dp[i / 3]);
            }
            dp[i] = temp;
        }
        return dp[n];
    }
    private static int getMin(int n){
        int dp[] = new int[n + 1];
        dp[1] = 0;
        for(int i = 2; i <= n; i++){
            if(i % 2 == 0){
                dp[i] = 1 + dp[i / 2];
            }else{
                //if i is odd the you can +1, -1
                //dp[i] = Math.min(1 + dp[i - 1], 1 + dp[i + 1]);   //as i is odd so i + 1 will be even
                dp[i] = Math.min(1 + dp[i - 1], 1 + 1 + dp[(i + 1) / 2]);
            }
        }
        return dp[n];
    }
}

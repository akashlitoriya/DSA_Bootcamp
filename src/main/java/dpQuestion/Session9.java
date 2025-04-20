package dpQuestion;
//https://docs.google.com/document/d/19i4iFDHcQf6xmr_q5ZO9NNoggWOQXoHPgwCxv07MrK4/edit
public class Session9 {
    public static void main(String[] args) {
        int arr[] = {5,4,2,6};
        System.out.println(getWays(arr));
    }
    private static int getWays(int arr[]){
        int n = arr.length;
        int dp[][] = new int[n][2];
        if(arr[0] % 2 == 0){
            dp[0][0] = 1;
        }else{
            dp[0][1] = 1;
        }
        dp[1][0] = dp[0][0];
        dp[1][1] = dp[0][1];
        for(int i = 2; i < n; i++){
            if(arr[i] % 2 == 0){
                dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
                dp[i][1] =dp[i - 1][1] + dp[i - 2][1];
            }else{
                dp[i][0] = dp[i - 1][1] + dp[i - 2][1];
                dp[i][1] = dp[i - 1][0] + dp[i - 2][0];
            }
        }
        return dp[n - 1][1];
    }
}

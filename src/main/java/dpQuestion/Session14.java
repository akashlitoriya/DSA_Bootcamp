package dpQuestion;
//https://docs.google.com/document/d/1yykv6-Ox3lxOhWIdDi9lrSeWK7wpbI9avVQbCFkVTE4/edit
public class Session14 {
    public static void main(String[] args) {
        int a[] = {25, 4, 5, 101};
        int b[] = {21, 1, 10, 100};
        System.out.println(getMaxEarning(a,b));
    }
    private static int getMaxEarning(int a[], int b[]){
        int n = a.length;
        int dp[][] = new int[n][2];
        dp[0][0] = a[0]; //0-> traveling city a
        dp[0][1] = b[0];

        for(int i = 1; i < n; i++){
            if(i == 1){
                dp[i][0] = a[i] + dp[i-1][0];
                dp[i][1] = b[i] + dp[i-1][1];
            }else{
                dp[i][0] = Math.max(dp[i - 1][0], dp[i-2][1]) + a[i];
                dp[i][1] = Math.max(dp[i - 1][1], dp[i-2][0]) + b[i];
            }
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}

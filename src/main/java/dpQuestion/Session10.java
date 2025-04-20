package dpQuestion;
//https://docs.google.com/document/d/13ydHMmLXcvIbpvH-rn-9F3Oc4IiekKu8ItLr05HZRJI/edit
public class Session10 {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(getMinCost(n, 1, 100, 500, 100000));
    }
    private static int getMinCost(int n, int x, int y, int z, int b){
        int dp[] = new int[n + 1];
        dp[1] = 0;
        for(int i = 2; i <= n; i++){
            int temp = y + dp[i - 1];
            if(i % 7 == 0){
                temp = Math.min(temp, x + dp[i / 7]);
            }
            if(i % 3 == 0){
                temp = Math.min(temp, z + dp[i / 3]);
            }
            if(i % 5 == 0){
                temp = Math.min(temp, b + dp[i / 5]);
            }
            dp[i] = temp;
        }
        return dp[n];
    }
}

package OAQuestions;
//https://docs.google.com/document/d/1zqjc95zDgkDbLtOoiK5zaRS7VPSAEiF3VXh7n3tYvH8/edit
public class PhonePeOA {
    public static void main(String[] args) {
        int arr1[] = {1,2};
        int arr2[] = {1,2,3};
        int arr3[] = {1,2,3,4};
        int arr4[] = {4,1,1,5,6};
        System.out.println(getMaxAmount(arr1));
        System.out.println(getMaxAmount(arr2));
        System.out.println(getMaxAmount(arr3));
        System.out.println(getMaxAmount(arr4));

        System.out.println(optimization(arr1));
        System.out.println(optimization(arr2));
        System.out.println(optimization(arr3));
        System.out.println(optimization(arr4));
    }
    private static int getMaxAmount(int h[]){
        int n = h.length;
        int dp[][] = new int[n][4];
        dp[1][2] = h[1] + h[0];
        if(n >= 3)
        dp[2][3] = h[0] + h[1] + h[2];
        for(int i = 3; i < n; i++){
            dp[i][2] = h[i] + h[i - 1] + dp[i-3][2];
            for(int j = i - 4; j >= 0; j--){
                dp[i][2] = Math.max(dp[i][2], h[i] + h[i-1] + Math.max(dp[j][2], dp[j][3]));
            }
            dp[i][3] = (i - 5 >= 0)? dp[i - 5][3] : 0;
            for(int j = i - 6; j >= 0; j--){
                dp[i][3] = Math.max(dp[i][3], Math.max(dp[j][2], dp[j][3]));
            }
            dp[i][3] = dp[i][3] + h[i] + h[i - 1] + h[i - 2];
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            max = Math.max(max, Math.max(dp[i][2], dp[i][3]));
        }
        return max;
    }

    private static int optimization(int h[]){
        int n = h.length;
        int dp[][] = new int[n][4];
        int max2[] = new int[n];
        int max3[] = new int[n];
        dp[1][2] = h[1] + h[0];
        max2[1] = dp[1][2];
        if(n >= 3) {
            dp[2][3] = h[2] + h[1] + h[0];
            max3[2] = dp[2][3];
        }
        for(int i = 3; i < n; i++){
            dp[i][2] = h[i] + h[i - 1] + max2[i - 3];
            dp[i][3] = h[i] + h[i-1] + h[i-2] + ((i-4 >= 0)? max3[i-4] : 0);
            max2[i] = Math.max(max2[i - 1], dp[i][2]);
            max3[i] = Math.max(max3[i - 1], dp[i][3]);
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            ans = Math.max(ans, Math.max(dp[i][2], dp[i][3]));
        }
        return ans;
    }
}

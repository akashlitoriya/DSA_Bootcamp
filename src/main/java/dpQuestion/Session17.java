package dpQuestion;

import java.util.Arrays;

//https://docs.google.com/document/d/1qSv9hJcj1nNsvMOdbGx1HFbJLWcIX7Plt2I_vKOz8pA/edit
public class Session17 {
    public static void main(String[] args) {
        int a[] = {0,1,4,5};
        int b[] = {1,3,2,6};
        System.out.println(Arrays.toString(getEvenAndOdd(a,b)));
    }
    private static int[] getEvenAndOdd(int a[], int b[]){
        int n = a.length;
        int dp1[][] = new int[n][2];
        int dp2[][] = new int[n][2];
        if(a[0] % 2 == 0){
            dp1[0][0] = 1;
        }else{
            dp1[0][1] = 1;
        }
        if(b[0] % 2 == 0){
            dp2[0][0] = 1;
        }else{
            dp2[0][1] = 1;
        }

        for(int i = 1; i < n; i++){
            if(a[i] % 2 == 0){
                dp1[i][0] = dp1[i-1][0] + dp2[i-1][0];
                dp1[i][1] = dp1[i-1][1] + dp2[i-1][1];
            }else{
                dp1[i][0] = dp1[i-1][1] + dp2[i-1][1];
                dp1[i][1] = dp1[i-1][0] + dp2[i-1][0];
            }
            if(b[i] % 2 == 0){
                dp2[i][0] = dp1[i-1][0] + dp2[i-1][0];
                dp2[i][1] = dp1[i-1][1] + dp2[i-1][1];
            }else{
                dp2[i][0] = dp1[i-1][1] + dp2[i-1][1];
                dp2[i][1] = dp1[i-1][0] + dp2[i-1][0];
            }
        }
        int ans[] = new int[2];
        ans[0] = dp1[n-1][0] + dp2[n-1][0];
        ans[1] = dp1[n-1][1] + dp2[n-1][1];
        return ans;
    }
}

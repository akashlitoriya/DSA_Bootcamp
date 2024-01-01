package dynamicProgramming;
import java.util.*;
public class LongestBitonicSubsequence {
    public static void main(String[] args) {
        int nums[] = {1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println(getLBS(nums));
    }
    private static int getLBS(int arr[]){
        int n = arr.length;
        int dp1[] = new int[n];
        int dp2[] = new int[n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        for(int i = 0; i < n; i++){
            for(int prev = 0; prev < i; prev++){
                if(arr[i] > arr[prev]){
                    dp1[i] = Math.max(dp1[i], dp1[prev] + 1);
                }

                if(arr[n - i - 1] > arr[n - prev - 1]){
                    dp2[n- i -1] = Math.max(dp2[n - i - 1], dp2[n - prev - 1] + 1);
                }
            }

        }
        int lbs = 0;
        for(int i = 0; i < n; i++){
            lbs = Math.max(lbs, dp1[i] + dp2[i] - 1);
        }
        return lbs;
    }
}

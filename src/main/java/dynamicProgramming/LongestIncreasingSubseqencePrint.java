package dynamicProgramming;
import java.util.*;
public class LongestIncreasingSubseqencePrint {
    public static void main(String[] args) {
        int nums[] = {5, 4, 11, 1, 16, 8};
        System.out.println(Arrays.toString(getIncreasingSubsequence(nums)));
    }
    private static int[] getIncreasingSubsequence(int arr[]){
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int hash[] = new int[n];  //this array is to store the value of prev for which we get max at dp[i]
        int lis = 0;   //contains the index that has max value or longest LIS
        for(int i = 0; i < n; i++){
            int max = i;
            for(int prev = 0; prev < i; prev++){
                if(arr[i] > arr[prev]){
                    if(dp[prev] + 1 > dp[i]){
                        max = prev;
                        dp[i] = dp[prev] + 1;
                    }
                }
            }
            hash[i] = max;
            if(dp[i] > dp[lis]){
                lis = i;
            }
        }

        int longestIncreasingSubsequence[] = new int[dp[lis]];
        int i = lis;
        int pos = 0;
        longestIncreasingSubsequence[pos] = arr[i];
        pos++;
        while(i != hash[i]){
            longestIncreasingSubsequence[pos] = arr[hash[i]];
            pos++;
            i = hash[i];
        }
        for(i = 0; i < lis / 2; i++){
            int temp = longestIncreasingSubsequence[i];
            longestIncreasingSubsequence[i] = longestIncreasingSubsequence[longestIncreasingSubsequence.length - i - 1];
            longestIncreasingSubsequence[longestIncreasingSubsequence.length - i - 1] = temp;
        }
        return longestIncreasingSubsequence;
    }
}

package dynamicProgramming;
import java.util.*;
public class NumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int count[] = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int lis = 0;
        for(int i = 0; i <= n - 1; i++){
            for(int j = 0; j <= i - 1; j++){
                if(nums[i] > nums[j] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];
                }else if(nums[i] > nums[j] && dp[i] == dp[j] + 1){
                    count[i] += count[j];
                }
            }
            lis = Math.max(lis, dp[i]);
        }
        int num = 0;
        for(int i = 0; i <= n - 1; i++){
            if(dp[i] == lis){
                num += count[i];
            }
        }
        return num;
    }
}

package dynamicProgramming;
import java.util.*;
public class LongestDivisibleSubset {
    private List<Integer> getLDS(int nums[]){
        int n = nums.length;
        int dp[] = new int[n];
        int hash[] = new int[n];
        Arrays.fill(dp, 1);
        //sort the given array
        Arrays.sort(nums);
        int lds = 0;
        for(int i = 0; i < n; i++){
            hash[i] = i;
            for(int prev = 0; prev < i; prev++){
                if(nums[i] % nums[prev] == 0){
                    if(dp[i] < dp[prev] + 1){
                        dp[i] = dp[prev] + 1;
                        hash[i] = prev;
                    }
                }
            }
            if(dp[i] > dp[lds]){
                lds = i;
            }
        }
        ArrayList<Integer> larDivisible = new ArrayList<>();
        larDivisible.add(0, nums[lds]);
        int i = lds;
        while(i != hash[i]){
            larDivisible.add(0,nums[hash[i]]);
            i = hash[i];

        }
        return larDivisible;
    }
}

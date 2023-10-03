package dynamicProgramming;
import java.util.*;
public class FrogJumpKSteps {
    private static int rec(int n, int k, int heights[]){
        if(n == 0){
            return 0;
        }
        int minEnergy = Integer.MAX_VALUE;
        for(int i = 1; i <= k; i++){
            if(n - i >= 0){
                int energy = rec(n - i, k,heights) + Math.abs(heights[n] - heights[n - i]);
                minEnergy = Math.min(minEnergy, energy);
            }
        }
        return minEnergy;
    }
    //Memoization
    private static int memo(int n, int k, int heights[]){
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return memoHelper(n,k,heights, dp);
    }
    private static int memoHelper(int n, int k, int heights[], int dp[]){
        if(n == 0) return 0;
        if(dp[n] != -1) return dp[n];
        int minEnergy = Integer.MAX_VALUE;
        for(int i = 1; i <= k; i++){
            if(n - i >= 0){
                int energy = memoHelper(n - i, k, heights,dp) + Math.abs(heights[n] - heights[n - i]);
                minEnergy = Math.min(minEnergy, energy);
            }
        }
        return dp[n] = minEnergy;
    }
    //Tabulation
    private static int tabu(int n, int k, int heights[]){
        int dp[] = new int[n + 1];
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            int minEnergy = Integer.MAX_VALUE;
            for(int j = 1; j <= k; j++){
                if(i - j >= 0){
                    int energy = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                    minEnergy = Math.min(minEnergy, energy);
                }
            }
            dp[i] = minEnergy;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int heights[] = {30,10,60,10,60,50};
        System.out.println("Recursion: "+ rec(5,3,heights));
        System.out.println("Memoization: " + memo(5, 3, heights));
        System.out.println("Tabulation: " + tabu(5, 3, heights));
    }
}

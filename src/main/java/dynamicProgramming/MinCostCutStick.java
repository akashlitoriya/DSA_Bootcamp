package dynamicProgramming;
import java.util.Arrays;
public class MinCostCutStick {
    //Recursion
    public int recur(int n, int[] cuts) {
        int cutsLen = cuts.length;
        Arrays.sort(cuts);
        int cut[] = new int[cutsLen + 2];
        for(int i = 0; i < cutsLen; i++){
            cut[i + 1] = cuts[i];
        }
        cut[0] = 0;
        cut[cutsLen + 1] = n;

        return getMinCost(1, cutsLen, cut);
    }
    private int getMinCost(int i, int j, int[] cuts){
        if(i > j) return 0;

        int mini = Integer.MAX_VALUE;
        for(int k = i; k <= j; k++){
            int cost = cuts[j + 1] - cuts[i - 1] + getMinCost(i, k-1, cuts) + getMinCost(k + 1, j, cuts);
            mini = Math.min(mini, cost);
        }
        return mini;
    }

    //Memoization
    public int minCost(int n, int[] cuts) {
        int cutsLen = cuts.length;
        Arrays.sort(cuts);
        int cut[] = new int[cutsLen + 2];
        for(int i = 0; i < cutsLen; i++){
            cut[i + 1] = cuts[i];
        }
        cut[0] = 0;
        cut[cutsLen + 1] = n;
        int dp[][] = new int[cut[cutsLen] + 1][cut[cutsLen] + 1];
        for(int rows[]: dp){
            Arrays.fill(rows, -1);
        }
        return getMinCost(1, cutsLen, cut, dp);
    }
    private int getMinCost(int i, int j, int[] cuts, int dp[][]){
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int mini = Integer.MAX_VALUE;
        for(int k = i; k <= j; k++){
            int cost = cuts[j + 1] - cuts[i - 1] + getMinCost(i, k-1, cuts, dp) + getMinCost(k + 1, j, cuts, dp);
            mini = Math.min(mini, cost);
        }
        return dp[i][j] = mini;
    }

    //Tabulation
    public int tabu(int n, int[] cuts) {
        int cutsLen = cuts.length;
        Arrays.sort(cuts);
        int cut[] = new int[cutsLen + 2];
        for(int i = 0; i < cutsLen; i++){
            cut[i + 1] = cuts[i];
        }
        cut[0] = 0;
        cut[cutsLen + 1] = n;
        int dp[][] = new int[cut[cutsLen] + 2][cut[cutsLen] + 2];

        //No need to handle base case as the default value for an array is zero
        for(int i = cutsLen; i >= 1; i--){
            for(int j = i; j <= cutsLen; j++){
                if(i > j) continue;
                int mini = Integer.MAX_VALUE;
                for(int k = i; k <= j; k++){
                    int cost = cut[j + 1] - cut[i - 1] + dp[i][k-1] + dp[k + 1][j];
                    mini = Math.min(mini, cost);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][cutsLen];
    }
}

package dynamicProgramming;

public class PalindromePartitionTwo {
    public static void main(String[] args) {
        String str = "aabb";
        System.out.println(getMinPartition(0, str) - 1);
    }
    private static int getMinPartition(int i, String str){
        if(i == str.length()) return 0;

        int minCost = Integer.MAX_VALUE;
        for(int j = i; j < str.length(); j++){
            if(isPalindrome(i,j,str)){
                int cost = 1 + getMinPartition(j + 1, str);
                minCost = Math.min(cost, minCost);
            }
        }
        return minCost;
    }
    private static int memo(int i, String str, int dp[]){
        if(i == str.length()) return 0;
        if(dp[i] != -1) return dp[i];
        int minCost = Integer.MAX_VALUE;
        for(int j = i; j < str.length(); j++){
            if(isPalindrome(i,j,str)){
                int cost = 1 + memo(j + 1, str, dp);
                minCost = Math.min(cost, minCost);
            }
        }
        return dp[i] = minCost;
    }

    private static int tabu(String str){
        int n = str.length();
        int dp[] = new int[n + 1];
        for(int i = n - 1; i >= 0; i--){
            int minCost = Integer.MAX_VALUE;
            for(int j = i; j < n; j++){
                if(isPalindrome(i,j,str)){
                    int cost = 1 + dp[j + 1];
                    minCost = Math.min(minCost, cost);
                }
            }
            dp[i] = minCost;
        }
        return dp[0] - 1;
    }
    private static boolean isPalindrome(int i, int j, String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

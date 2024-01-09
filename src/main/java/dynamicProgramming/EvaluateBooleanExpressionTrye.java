package dynamicProgramming;
import java.util.Arrays;
public class EvaluateBooleanExpressionTrye {
    public static void main(String[] args) {
        String exp = "F|T^F";
        int len = exp.length();
        int dp[][][] = new int[len][len][2];
        for(int rows[][] : dp){
            for(int cols[]: rows){
                Arrays.fill(cols, -1);
            }
        }
        System.out.println("True ways : "+ getTrue(0, len - 1, 1, exp));
        System.out.println("True ways memoization : "+ getTrueMemoization(0, len - 1, 1, exp, dp));
        System.out.println("True ways tabulation : "+ getTrueTabulation(exp));
    }
    private static int getTrue(int i, int j, int isTrue, String exp){
        if(i > j) return 0;
        if(i == j){ //when we are left with only T or F
            if(isTrue == 1) { //Looking for True
                return (exp.charAt(i) == 'T'? 1 : 0);
            }else{
                return (exp.charAt(i) == 'F' ? 1 : 0);
            }
        }
        int ways = 0;
        for(int ind = i + 1; ind <= j - 1; ind = ind + 2){
            int leftTrue = getTrue(i, ind - 1, 1, exp);
            int leftFalse = getTrue(i, ind - 1, 0, exp);
            int rightTrue = getTrue(ind + 1, j, 1, exp);
            int rightFalse = getTrue(ind + 1, j, 0, exp);
            if(exp.charAt(ind) == '&'){
                if(isTrue == 1){
                    ways += leftTrue * rightTrue;
                }else{
                    ways += leftFalse * rightTrue + leftFalse * rightFalse + leftTrue * rightFalse;
                }
            }else if(exp.charAt(ind) == '|'){
                if(isTrue == 1){
                    ways += leftTrue * rightFalse + leftFalse * rightTrue + leftTrue * rightTrue;
                }else{
                    ways += leftFalse * rightFalse;
                }
            }else{
                if(isTrue == 1){
                    ways += leftTrue * rightFalse + leftFalse * rightTrue;

                }else{
                    ways += leftTrue * rightTrue + leftFalse * rightFalse;
                }
            }
        }
        return ways;
    }
    //Memoization - T.C(O(n*n*2)*n)
    private static int getTrueMemoization(int i, int j, int isTrue, String exp, int[][][] dp){
        if(i > j) return 0;
        if(i == j){ //when we are left with only T or F
            if(isTrue == 1) { //Looking for True
                return (exp.charAt(i) == 'T'? 1 : 0);
            }else{
                return (exp.charAt(i) == 'F' ? 1 : 0);
            }
        }
        if(dp[i][j][isTrue] != -1) return dp[i][j][isTrue];
        int ways = 0;
        for(int ind = i + 1; ind <= j - 1; ind = ind + 2){
            int leftTrue = getTrueMemoization(i, ind - 1, 1, exp, dp);
            int leftFalse = getTrueMemoization(i, ind - 1, 0, exp, dp);
            int rightTrue = getTrueMemoization(ind + 1, j, 1, exp, dp);
            int rightFalse = getTrueMemoization(ind + 1, j, 0, exp, dp);
            if(exp.charAt(ind) == '&'){
                if(isTrue == 1){
                    ways += leftTrue * rightTrue;
                }else{
                    ways += leftFalse * rightTrue + leftFalse * rightFalse + leftTrue * rightFalse;
                }
            }else if(exp.charAt(ind) == '|'){
                if(isTrue == 1){
                    ways += leftTrue * rightFalse + leftFalse * rightTrue + leftTrue * rightTrue;
                }else{
                    ways += leftFalse * rightFalse;
                }
            }else{
                if(isTrue == 1){
                    ways += leftTrue * rightFalse + leftFalse * rightTrue;

                }else{
                    ways += leftTrue * rightTrue + leftFalse * rightFalse;
                }
            }
        }
        return dp[i][j][isTrue] =  ways;
    }

    //Tabulation -
    private static int getTrueTabulation(String exp){
        int len = exp.length();
        int dp[][][] = new int[len + 1][len + 1][2];
        //when i == j
        for(int i = 0; i < len; i++){
            dp[i][i][1] = (exp.charAt(i) == 'T'? 1: 0);
            dp[i][i][0] = (exp.charAt(i) == 'F'? 1: 0);
        }

        //Exploring all posibilities
        for(int i = len - 1; i >= 0; i--){
            for(int j = i + 1; j <= len; j++){
                for(int isTrue = 0; isTrue <= 1; isTrue++){
                    int ways = 0;
                    for(int ind = i + 1; ind <= j - 1; ind+= 2){
                        int leftFalse = dp[i][ind - 1][0];
                        int leftTrue = dp[i][ind - 1][1];
                        int rightFalse = dp[ind + 1][j][0];
                        int rightTrue = dp[ind + 1][j][1];
                        if(exp.charAt(ind) == '&'){
                            if(isTrue == 1){
                                ways += leftTrue * rightTrue;
                            }else{
                                ways += leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
                            }
                        }else if(exp.charAt(ind) == '|'){
                            if(isTrue == 1){
                                ways += leftTrue * rightFalse + leftFalse * rightTrue + leftTrue * rightTrue;
                            }else{
                                ways += leftFalse * rightFalse;
                            }
                        }else{
                            if(isTrue == 1){
                                ways += leftTrue * rightFalse + leftFalse * rightTrue;
                            }else{
                                ways += leftTrue * rightTrue + leftFalse * rightFalse;
                            }
                        }
                    }
                    dp[i][j][isTrue] = ways;
                }
            }
        }
        return dp[0][len - 1][1];
    }
}

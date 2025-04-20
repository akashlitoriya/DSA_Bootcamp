package hashingQuestion;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class SplinklrOAStringQueries {
    public static void main(String[] args) {
        String s = "abcaab";
        int queries[][] = {{1,1}, {2,5},{3,6}, {1,6}};
        System.out.println(Arrays.toString(getQueriesResult(s, queries)));
    }
    private static int[] getQueriesResult(String s, int[][] queries){
        int qLen = queries.length;
        int n = s.length();
        int prefix[][] = new int[n + 1][26];
        for(int i = 0; i < n; i++){
            int e = (int)s.charAt(i) - 97;
            for(int j = 0; j < 26; j++){
                prefix[i + 1][j] = (e == j)? 1 : 0;
                prefix[i + 1][j] += prefix[i][j];
            }

        }
        int ans[] = new int[qLen];
        for(int q = 0; q < qLen; q++){
            int l = queries[q][0];
            int r = queries[q][1];
            int temp = 0;
            for(int i = 0; i < 26; i++){
                int freq = prefix[r][i] - prefix[l-1][i];
                temp += freq*(freq + 1)/2;
            }
            ans[q] = temp;
        }
        return ans;
    }

}

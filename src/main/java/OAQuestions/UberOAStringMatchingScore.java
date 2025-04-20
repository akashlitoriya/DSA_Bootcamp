package OAQuestions;

import java.util.Arrays;

public class UberOAStringMatchingScore {
    public static void main(String[] args) {
        String arr[] = {"bbz","zaz","aaa","zaa","zzz"};
        System.out.println(Arrays.toString(getScore(arr)));
    }
    private static int[] getScore(String arr[]){
        int n = arr.length;
        int maxLen = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            maxLen = Math.max(maxLen, arr[i].length());
        }
        int suffix[][] = new int[26][maxLen];
        int ans[] = new int[n];
        for(int i = n - 1; i >= 0; i--){
            int score = 0;
            for(int j = 0; j < arr[i].length(); j++){
                int idx = arr[i].charAt(j) - 'a';
                score += suffix[idx][j];
                suffix[idx][j]++;
            }
            ans[i] = score;
        }
        return ans;
    }
}

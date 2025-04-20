package GreedyQuestions;

import java.util.Arrays;

//https://docs.google.com/document/d/13MKczzXCMLXRmytm4Yk_EwXXQCqz_nUewR7GdHNiQO8/edit
public class Session2 {
    public static void main(String[] args) {
        String str = "0111010101";
        System.out.println(minOperation(str));
    }
    private static int minOperation(String s){
        //we are making s as substring of ...0001111....

        int n = s.length();
        int prefixOne[] = new int[n];
        prefixOne[0] = s.charAt(0) == '1' ? 1 : 0;
        for(int i = 1; i < n; i++){
            prefixOne[i] = prefixOne[i - 1] + ((s.charAt(i) == '1') ? 1 : 0);
        }
        int suffixZero[] = new int[n];
        suffixZero[n - 1] = s.charAt(n - 1) == '0'? 1 : 0;
        for(int i = n - 2; i >= 0; i--){
            suffixZero[i] = suffixZero[i + 1] + ((s.charAt(i) == '0' )? 1 : 0);
        }
        System.out.println("PRE : " + Arrays.toString(prefixOne));
        System.out.println("SUF : " + Arrays.toString(suffixZero));
        int minOp = prefixOne[0] + suffixZero[0] - 1;
        for(int i = 1; i < n; i++){
            minOp = Math.min(minOp, prefixOne[i] + suffixZero[i] - 1);
        }
        return minOp;
    }
}

package dynamicProgramming;
import java.util.*;
public class LongestStringChain {
    public static void main(String[] args) {

    }
    //for sorting the string based on their length
    static Comparator<String> comp = (s1, s2) -> s1.length() - s2.length();
    private boolean canChain(String s1, String s2){
        // s1 -> smaller one s2 -> bigger one

        if(s1.length() + 1 != s2.length()){
            return false;
        }
        int m = 0;
        int n = 0;
        while(n != s2.length()){
            if(m < s1.length() && s1.charAt(m) == s2.charAt(n)){
                m++;
                n++;
            }else{
                n++;
            }
        }
        return (m == s1.length() && n == s2.length());
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words, comp);
        int n = words.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int prev = 0; prev < i; prev++){
                if(canChain(words[prev], words[i])){
                    dp[i] = Math.max(dp[i], dp[prev] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}

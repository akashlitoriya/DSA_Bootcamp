package OAQuestions;

import java.util.Arrays;

public class SystemAndStringIBM {
    public static void main(String[] args) {
        String str[] = {"ljis", "lhm", "gms"};
        System.out.println(Arrays.toString(getWhoWins(str)));
    }
    private static String[] getWhoWins(String[] game){
        int n = game.length;
        String ans[] = new String[n];
        for(int i = 0; i < n; i++){
            int numVowels = getNumberVowels(game[i]);
            if(numVowels == 0){
                ans[i] = "Chris";
            }else{
                ans[i] = "Alex";
            }
        }
        return ans;
    }
    private static int getNumberVowels(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(isVowel(s.charAt(i))){
                count++;
            }
        }
        return count;
    }
    private static boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
            return true;
        }
        return false;
    }
}

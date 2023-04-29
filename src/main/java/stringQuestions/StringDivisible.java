package stringQuestions;
import java.util.*;
//https://leetcode.com/problems/find-the-divisibility-array-of-a-string/
public class StringDivisible {

    //Approach - 1;
    public int[] divisibilityArray(String word, int m) {
        int[] divArray = new int[word.length()];
        for(int i = 0; i < word.length(); i++){
            if(divisible(word.substring(0, i + 1),m)){
                divArray[i] = 1;
            }else{
                divArray[i] = 0;
            }
        }
        return divArray;
    }

    private boolean divisible(String str, int m){
        boolean div = true;
        int carry = 0;
        for(int i = 0; i < str.length(); i++){
            carry = carry * 10 + (int)(str.charAt(i) - 48);
            if(carry % m == 0){
                carry = 0;
                div = true;
            }else{
                carry = carry % m;
                div = false;
            }
        }
        return div;
    }

    //Approach - 2
    public int[] divisibilityArray2(String word, int m){
        int[] div = new int[word.length()];
        int idx = -1;
        for(int i = 0; i < word.length(); i++){
            if(divisible2(word.substring(0, i + 1),m,idx)){
                div[i] = 1;
                idx = i;
            }else{
                div[i] = 0;
            }
        }
        return div;
    }
    private boolean divisible2(String str, int m, int idx){
        boolean div = true;
        int carry = 0;
        for(int i = idx + 1; i < str.length(); i++){
            carry = carry * 10 + (int)(str.charAt(i) - 48);
            if(carry % m == 0){
                carry = 0;
                div = true;
            }else{
                carry = carry % m;
                div = false;
            }
        }
        return div;
    }

    public static void main(String[] args) {
        StringDivisible obj = new StringDivisible();
        String word = "8917171717276217174131";
        int m = 17;
        System.out.println(Arrays.toString(obj.divisibilityArray2(word,m)));
    }
}

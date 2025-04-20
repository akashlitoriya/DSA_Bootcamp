package OAQuestions;

import java.util.HashMap;

public class MinOpAtoBIntuit {
    public static void main(String[] args) {
        String a = "ACBGB";
        String b = "AGCBB";
        System.out.println(getMinOp(a, b));
        String p = "ABCDE";
        String q = "EDCBA";
        System.out.println(getMinOp(p, q));
    }

    private static int getMinOp(String a, String b){
        if(a.length() != b.length()) return -1;
        HashMap<Character, Integer> freqA = new HashMap<>();
        HashMap<Character, Integer> freqB = new HashMap<>();
        for(int i = 0; i < a.length(); i++){
            if(freqA.containsKey(a.charAt(i))){
                int val = freqA.get(a.charAt(i));
                freqA.put(a.charAt(i), val + 1);
            }else{
                freqA.put(a.charAt(i), 1);
            }
            if(freqB.containsKey(b.charAt(i))){
                int val = freqB.get(b.charAt(i));
                freqB.put(b.charAt(i), val + 1);
            }else{
                freqB.put(b.charAt(i), 1);
            }
        }

        //matching the freq of characters
        for(int i = 0; i < a.length(); i++){
            if(freqA.get(a.charAt(i)) != freqB.get(a.charAt(i))){
                return -1;
            }
        }

        //now start making the bond
        int i = b.length() - 1;
        int j = a.length() - 1;
        int matched = 0;
        while(j >= 0){
            if(b.charAt(i) == a.charAt(j)){
                matched++;
                i--;
            }
            j--;
        }
        return a.length() - matched;
    }

}

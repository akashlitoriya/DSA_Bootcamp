package hashingQuestion;

import java.util.HashMap;
import java.util.Map;

public class LonPalindromeConcate {
    public static void main(String[] args) {
        String[] words = {"ab","ty","yt","lc","cl","ab"};
        System.out.println(longestPalindrome(words));
    }
    public static int longestPalindrome(String[] words) {
        int len = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            String rev = ""+words[i].charAt(1) + words[i].charAt(0);
            if(map.containsKey(rev)){
                len += 4;
                int val = map.get(rev);
                if(val == 1)
                    map.remove(rev);
                else map.put(rev, val - 1);
            }else{
                map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            }
        }
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            String key = entry.getKey();
            if(key.charAt(0) == key.charAt(1)){
                len += 2;
                break;
            }
        }
        return len;
    }
}

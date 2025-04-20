package hashingQuestion;
import java.util.*;
public class FindCommonCharacter {
    public static void main(String[] args) {

    }
    public List<String> commonChars(String[] words) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(int i = 0; i < words[0].length(); i++){
            if(hmap.containsKey(words[0].charAt(i))){
                int val = hmap.get(words[0].charAt(i)) + 1;
                hmap.put(words[0].charAt(i), val);
            }else{
                hmap.put(words[0].charAt(i), 1);
            }
        }

        for(int i = 1; i < words.length; i++){
            HashMap<Character, Integer> temp = new HashMap<>();
            String tempStr = words[i];
            for(int j = 0; j < tempStr.length(); j++){
                if(temp.containsKey(tempStr.charAt(j))){
                    int val = temp.get(tempStr.charAt(j)) + 1;
                    temp.put(tempStr.charAt(j), val);
                }else{
                    temp.put(tempStr.charAt(j), 1);
                }
            }

            for(Character ch: hmap.keySet()){
                if(temp.containsKey(ch)){
                    hmap.put(ch, Math.min(temp.get(ch), hmap.get(ch)));
                }else{
                    hmap.put(ch, 0);
                }
            }
        }

        List<String> ans = new ArrayList<>();
        for(Character ch: hmap.keySet()){
            if(hmap.get(ch) != 0){
                for(int k = 0; k < hmap.get(ch); k++)
                    ans.add(""+ch);
            }
        }
        return ans;
    }
}

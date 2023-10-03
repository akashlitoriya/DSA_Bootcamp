package recursion;
import java.util.*;
public class LetterCombination {
    public static void main(String[] args) {
        String no = "25274";
        System.out.println(letterCombinations(no));
    }
    public static  List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<String>();
        }
        return letterComb("", digits);
    }
    private static List<String> letterComb(String pro, String unPro){
        if(unPro.length() == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(pro);
            return list;
        }
        List<String> ans = new ArrayList<>();
        int btn = unPro.charAt(0) - '0';
        int st;
        int end;
        if(btn == 8){
            st = (btn - 2)* 3 + 1;
            end = (btn - 1 )* 3 + 1;
        }
        else if(btn == 7){
            st = (btn - 2) * 3;
            end = (btn - 1) * 3 + 1;
        }else if(btn == 9){
            st = (btn - 2) * 3 + 1;
            end = (btn - 1) * 3 + 2;
        }else{
            st = (btn - 2) * 3;
            end = (btn - 1) * 3;
        }
        for(int i = st; i < end; i++){
            char ch = (char)((int)'a' + i);
            ans.addAll(letterComb(pro + ch, unPro.substring(1)));
        }
        return ans;
    }
}

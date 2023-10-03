package recursion;
import java.util.*;
public class DialPad {
    public static void main(String[] args) {
        String no = "23";
        getLetterComb("",no);
        System.out.printf("Number of combinations : %d\n",countLetterComb("",no));
        System.out.println("Combinations : " + getAllLetterComb("","235"));
    }
    public static void getLetterComb(String pro, String unPro){
        if(unPro.length() == 0){
            System.out.println(pro);
            return;
        }
        int btn =  unPro.charAt(0) - '0';
        for(int i = (btn - 1) * 3; i < btn * 3; i++){
            if(i != 26){
                char ch = (char)((int)'a' + i);
                getLetterComb(pro + ch, unPro.substring(1));
            }
        }
    }
    public static int countLetterComb(String pro, String unPro){
        if(unPro.length() == 0){
            return 1;
        }
        int btn =  unPro.charAt(0) - '0';
        int count = 0;
        for(int i = (btn - 1) * 3; i < btn * 3; i++){
            if(i != 26){
                char ch = (char)((int)'a' + i);
                count += countLetterComb(pro + ch, unPro.substring(1));
            }
        }
        return count;
    }
    public static List<String> getAllLetterComb(String pro, String unPro){
        if(unPro.length() == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(pro);
            return list;
        }
        List<String> ans = new ArrayList<>();
        int btn = unPro.charAt(0) - '0';
        for(int i = (btn - 1) * 3; i < (btn * 3); i++){
            if(i != 26){
                char ch = (char)((int)'a' + i);
                ans.addAll(getAllLetterComb(pro + ch, unPro.substring(1)));
            }
        }
        return ans;
    }
}

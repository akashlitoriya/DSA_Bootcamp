package ArraysQuestion;
import java.util.*;
public class LongestconseONes {
    public static void main(String[] args){
        int len,  ones;
        Scanner in = new Scanner(System.in);
        len = in.nextInt();
        ones = in.nextInt();
        int longestConZeroes = getLongestConZero(len, ones);
        System.out.println(longestConZeroes);
    }

    private static  int getLongestConZero(int leng, int ones){
        if(leng == ones){
            return 0;
        }
        if(ones == 0){
            return leng;
        }
        String given = "";
        for(int i = 0; i < ones; i++) {
            given = given + '1';
        }
        for(int i = 0; i < leng - ones; i++){
            given = given + '0';
        }

        ArrayList<String> ans = getAllPermutations("", given);
        int mini = Integer.MAX_VALUE;
        for(int i = 0; i < ans.size(); i++){
            int temp = getLongestConsecutive(ans.get(i));
            mini = Math.min(mini, temp);
        }
        return mini;
    }
    private static  ArrayList<String> getAllPermutations(String pro, String unPro){
        if(unPro.length() == 0){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(pro);
            return ans;
        }
        ArrayList<String> allAns = new ArrayList<>();
        for(int i = 0; i <= pro.length(); i++){
            char ch = unPro.charAt(0);
            String first = pro.substring(0, i);
            String second = pro.substring(i, pro.length());
            allAns.addAll(getAllPermutations(first + ch + second, unPro.substring(1)));
        }
        return allAns;
    }
    private static  int getLongestConsecutive(String str){
        int maxi= Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '0'){
                count = count + 1;
            }else{
                maxi= Math.max(maxi, count);
                count = 0;
            }

        }
        maxi = Math.max(maxi, count);
        return maxi;
    }
}

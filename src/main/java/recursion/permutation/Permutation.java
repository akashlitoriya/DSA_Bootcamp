package recursion.permutation;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        String str = "abc";
        permutations("", str);
        System.out.println(permutationList("", str));
        System.out.printf("No of permutations of %s is %d",str, countPermutations("", str));
    }
    public static void permutations(String pro, String unPro){
        if(unPro.length() == 0){
            System.out.println(pro);
            return;
        }
        char ch = unPro.charAt(0);
        for(int i = 0; i <= pro.length(); i++){
            String f = pro.substring(0,i);
            String s = pro.substring(i, pro.length());
            permutations(f + ch + s, unPro.substring(1));
        }
    }
    public static  ArrayList<String> permutationList(String pro, String unPro){
        if(unPro.length() == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(pro);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        char ch = unPro.charAt(0);
        for(int i = 0; i <= pro.length(); i++){
            String f = pro.substring(0, i);
            String s = pro.substring(i, pro.length());
            ans.addAll(permutationList(f + ch + s, unPro.substring(1)));
        }
        return ans;
    }
    public static int countPermutations(String pro, String unPro){
        if(unPro.length() == 0){
            return 1;
        }
        int count = 0;
        char ch = unPro.charAt(0);
        for(int i =0; i < pro.length() + 1; i++){
            String f = pro.substring(0, i);
            String s = pro.substring(i);
            count += countPermutations(f + ch + s, unPro.substring(1));
        }
        return count;
    }
}

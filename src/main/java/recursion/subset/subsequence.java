package recursion.subset;

import java.util.ArrayList;

public class subsequence {
    private static void subseq(String pro, String unPro){
        if(unPro.length() == 0){ //this means there is no character left to accept or reject
            System.out.println(pro);
            return ;
        }
        char ch = unPro.charAt(0);
        subseq(pro + ch, unPro.substring(1)); //taking the character
        subseq(pro, unPro.substring(1)); //not taking the character
    }
    private static ArrayList<String> subseqList(String p, String un){
        if(un.length() == 0){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        char ch = un.charAt(0);
        ArrayList<String> notTaking = subseqList(p, un.substring(1));
        ArrayList<String> taking = subseqList(p + ch, un.substring(1));
        notTaking.addAll(taking);
        return notTaking;
    }

    public static void main(String[] args) {
        subseq("","abc");
        System.out.println(subseqList("", "abc"));
    }
}

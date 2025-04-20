package hashingQuestion;

import java.util.HashMap;

public class PrefixCommonArray {
    public static void main(String[] args) {

    }
    public static int[] findThePrefixCommonArray(int[] a, int[] b) {
        int count = 0;
        int n = a.length;
        int ans[] = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(a[i] == b[i]) count++;
            else{
                if(map.containsKey(a[i])) count++;
                if(map.containsKey(b[i])) count++;
            }
            ans[i] = count;
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            map.put(b[i], map.getOrDefault(b[i], 0) + 1);
        }
        return ans;
    }
}

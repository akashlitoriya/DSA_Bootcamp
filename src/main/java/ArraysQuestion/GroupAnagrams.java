package ArraysQuestion;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        int i = 0;
        while(i < strs.length){
            if(ans.size() == 0){
                ans.add(new ArrayList<String>());
                ans.get(0).add(strs[i]);
            }else{
                boolean found = false;
                for(int j = 0; j < ans.size(); j++){
                    if(isAnagram(strs[i], ans.get(j).get(0))){
                        ans.get(j).add(strs[i]);
                        found = true;
                        break;
                    }
                }
                if(!found){
                    ans.add(new ArrayList<String>());
                    ans.get(ans.size() - 1).add(strs[i]);
                }
            }
            i++;

        }
        return ans;
    }
    private boolean isAnagram(String str1, String str2){
        if(str1.length() != str2.length()) return false;
        boolean anagram = false;
        int[] arrStr1 = freqArray(str1);
        int[] arrStr2 = freqArray(str2);
        return checkEqual(arrStr1, arrStr2);
    }
    private int[] freqArray(String str){
        int ans[] = new int[26];
        for(int i = 0; i < str.length(); i++){
            int idx = (int)str.charAt(i) - 97;
            ans[idx]++;
        }
        return ans;
    }
    private boolean checkEqual(int arr1[], int arr2[]){
        if(arr1.length != arr2.length){
            return false;
        }
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
    //METHOD - 2 USING HASHMAPS
    public List<List<String>> groupAnagram(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] sArr = strs[i].toCharArray();
            Arrays.sort(sArr);
            String keyStr = new String(sArr);
            if(map.containsKey(keyStr)){
                map.get(keyStr).add(strs[i]);
            }else{
                map.put(keyStr,new ArrayList<String>());
                map.get(keyStr).add(strs[i]);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        Set<String> keys = map.keySet();
        for(String j : keys){
            ans.add(map.get(j));
        }
        return ans;

    }
}

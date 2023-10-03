package ArraysQuestion;

import java.util.*;

public class TopKFrequentElements {

    /*
    Method-1: Using Arrays and Comparable class
    T.C- O(nlogn)
    */

    class Pair implements Comparable<Pair>{
        int val;
        int freq;
        Pair(int val, int freq){
            this.val = val;
            this.freq = freq;
        }
        public int compareTo(Pair obj){
            return this.freq - obj.freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        ArrayList<Pair> arr = new ArrayList<>();
        int count = 0;
        int j = 0;
        int i = 0;
        while(i < nums.length && j < nums.length){
            if(nums[j] == nums[i]){
                j++;
            }else{
                arr.add(new Pair(nums[i], j - i));
                i = j;
                j++;
            }
        }
        arr.add(new Pair(nums[i], j - i));
        Collections.sort(arr);
        int[] result = new int[k];
        int l = 0;
        for(int p = arr.size() - 1; p >= arr.size() - k; p--){
            result[l++] = arr.get(p).val;
        }
        return result;
    }

    /*

     */
    public int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                int freq = map.get(nums[i]) + 1;
                map.put(nums[i], freq);
            }else{
                map.put(nums[i], 1);
            }
        }

        ArrayList<Pair> arr = new ArrayList<>();
        Set<Integer> key = map.keySet();
        for(int keys: key){
            arr.add(new Pair(keys, map.get(keys)));
        }
        Collections.sort(arr);
        int result[] = new int[k];
        int l = 0;
        for(int i = arr.size() - 1; i >= arr.size() - k; i--){
            result[l++] = arr.get(i).val;
        }
        return result;
    }
}

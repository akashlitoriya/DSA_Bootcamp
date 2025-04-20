package hashingQuestion;

import java.util.HashMap;
import java.util.Map;

public class AtlassianOAGoodSubsets {
    public static void main(String[] args) {
        int arr[] = {1,5,3,7,8};
        System.out.println(getMaximumSubsetSum(arr));
    }
    private static int getMaximumSubsetSum(int arr[]){
        int n = arr.length;
        int subset[] = new int[n];
        for(int i = 0; i < n; i++){
            //find arr[i] - i
            subset[i] = arr[i] - i;
        }
        //Now we will find subset sum
        HashMap<Integer, Integer> subsetSum = new HashMap<>();
        for(int i = 0; i < n; i++){
            subsetSum.put(subset[i], subsetSum.getOrDefault(subset[i], 0) + arr[i]);
        }

        int max = Integer.MIN_VALUE;
        //Now we will find the maximum subset sum
        for(Map.Entry<Integer,Integer> entry: subsetSum.entrySet()){
           max = Math.max(max, entry.getValue());
        }
        return max;
    }
}

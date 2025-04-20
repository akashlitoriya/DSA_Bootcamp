package hashingQuestion;

import java.util.HashMap;

public class NoSubarrSumK {
    public static void main(String[] args) {

    }
    private static int getNoSubarray(int arr[], int k){
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            int diff = sum - k;
            if(sum == k){
                count++;
            }
            if(map.containsKey(diff)){
                count += map.get(diff);
            }
            if(map.containsKey(sum)){
                int val = map.get(sum) + 1;
                map.put(sum, val);

            }else{
                map.put(sum, 1);
            }
        }
        return count;
    }
}

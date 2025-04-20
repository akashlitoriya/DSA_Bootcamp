package hashingQuestion;

import java.util.HashMap;

public class SubarrayXOREqualK {
    public static void main(String[] args) {
        int arr[] = {4,2,2,6,4};
        int k = 6;
        System.out.println(getSubarray(arr,k));
    }
    private static int getSubarray(int arr[], int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int xor = 0;
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            xor = xor ^ arr[i];
            if(xor == k){
                count++;
            }
            if(map.containsKey(xor ^ k)){
                count += map.get(xor ^ k);
            }

            if(map.containsKey(xor)){
                int val = map.get(xor) + 1;
                map.put(xor, val);
            }else{
                map.put(xor, 1);
            }
        }
        return count;
    }
}

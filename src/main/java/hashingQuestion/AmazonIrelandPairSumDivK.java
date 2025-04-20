package hashingQuestion;

import java.util.HashMap;

public class AmazonIrelandPairSumDivK {
    public static void main(String[] args) {
        int arr[] = {5,2,3,1,1};
        int k = 3;
        System.out.println(getPairCount(arr, k));
    }
    private static int getPairCount(int arr[], int k){
        int count = 0;
        HashMap<Integer, Integer> remainder = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int rem = arr[i] % k;
            if(rem != 0){
                if(remainder.containsKey(k - rem)){
                    count += remainder.get(k - rem);

                }
            }else{
                if(remainder.containsKey(rem)){
                    count += remainder.get(rem);
                }
            }
            remainder.put(rem, remainder.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}

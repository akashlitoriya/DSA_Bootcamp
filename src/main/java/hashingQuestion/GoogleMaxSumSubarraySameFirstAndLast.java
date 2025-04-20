package hashingQuestion;

import java.util.HashMap;

public class GoogleMaxSumSubarraySameFirstAndLast {
    public static void main(String[] args) {
        int arr[] = {1,8,10,8,-5,8};
        System.out.println(getMaximumSumSubarray(arr));
    }
    private static int getMaximumSumSubarray(int arr[]){
        int n = arr.length;
        HashMap<Integer,Integer> prefix = new HashMap<>();
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            if(prefix.containsKey(arr[i])){
                int tempSum = sum - prefix.get(arr[i]) + arr[i];
                maxSum = Math.max(maxSum, tempSum);
                prefix.put(arr[i], Math.min(prefix.get(arr[i]), sum));
            }else{
                prefix.put(arr[i], sum);
            }
        }
        return maxSum;
    }
}

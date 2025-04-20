package hashingQuestion;

import java.util.HashMap;

public class AtlassianOAMaxSumSubarray {
    public static void main(String[] args) {
        int arr[] = {1,5,-5,8,8,8,10,15};
        int k = 5;
        System.out.println(getMaxSum(arr, k));
    }
    private static int getMaxSum(int arr[], int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxSum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            int req = arr[i] - k;
            if(map.containsKey(req)){
                int tempSum = sum - map.get(req) + req;
                maxSum = Math.max(maxSum, tempSum);
            }
            if(map.containsKey(arr[i] + k)){
                int tempSum = sum - map.get(arr[i] + k) + arr[i] + k;
                maxSum = Math.max(maxSum, tempSum);
            }
            if(map.containsKey(arr[i])){
                map.put(arr[i], Math.min(map.get(arr[i]), sum));
            }else{
                map.put(arr[i], sum);
            }
        }
        return maxSum;
    }
}

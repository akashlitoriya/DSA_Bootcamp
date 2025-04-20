package hashingQuestion;

import java.util.HashMap;

public class MaxSumOfNumberWithSameDigitSum {
    public static void main(String[] args) {
        int arr[] = {51, 71, 17, 42};
        System.out.println(getMaxSum(arr));
        int arr2[] = {42, 33, 60};
        System.out.println(getMaxSum(arr2));
    }
    private static int getMaxSum(int arr[]){
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int digitSum = getDigitSum(arr[i]);
            if(map.containsKey(digitSum)){
                int sum = map.get(digitSum) + arr[i];
                if(sum > maxSum) maxSum = sum;
            }
            if(map.containsKey(digitSum)){
                int val = map.get(digitSum);
                if(val < arr[i]) map.put(digitSum, arr[i]);
            }else{
                map.put(digitSum, arr[i]);
            }
       }
        return maxSum;
    }
    private static int getDigitSum(int n){
        int sum = 0;
        while(n != 0){
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
}

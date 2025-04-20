package hashingQuestion;

import java.util.HashMap;

public class CountShortestLenSubArray {
    public static void main(String[] args) {
        int arr[] = {10,5,2,7,1,9,8,7};
        int k = 15;
        System.out.println(countShortest(arr, k));
    }
    private static int countShortest(int arr[], int k){
        HashMap<Integer, Integer> store = new HashMap<>();
        int sum = 0;
        int len = arr.length;
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(sum == k){
                if(len > i + 1){
                    len = i + 1;
                    count = 1;
                }else if(len == i + 1){
                    count++;
                }
            }
            if(store.containsKey(sum - k)){
                int size = i - store.get(sum - k);
                if(size < len){
                    len = size;
                    count = 1;
                }else if(size == len){
                    count++;
                }
            }

            store.put(sum, i);
        }
        return count;
    }
}

package hashingQuestion;

import java.util.HashMap;

public class AmazonFirstAndLastSum {
    public static void main(String[] args) {
        int arr[] = {5, 6, 7, 8, 10, 4, 3, 2, 1};
        int sum = 8;
        System.out.println(getSmallestSubarray(arr, sum));
    }
    private static int getSmallestSubarray(int arr[], int sum){
        if(arr.length < 2) return -1;
        HashMap<Integer, Integer> store = new HashMap<>();
        int len = arr.length;
        for(int i = 0; i < arr.length; i++){
            int req = sum - arr[i];
            if(store.containsKey(req)){
                len = Math.min(len, i - store.get(req) +1);
            }
            store.put(arr[i], i);
        }
        return len;
    }
}

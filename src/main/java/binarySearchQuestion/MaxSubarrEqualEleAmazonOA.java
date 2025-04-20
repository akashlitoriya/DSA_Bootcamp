package binarySearchQuestion;
import java.util.*;
public class MaxSubarrEqualEleAmazonOA {
    public static void main(String[] args) {
        int arr[] = {1,2,3,1,1,1,4,1,2,3,1};
        int k = 3;
        System.out.println(bruteForce(arr, k));
    }
    private static int bruteForce(int arr[], int k){
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            int len = 0;
            int countDel = k;
            for(int j = i; j < arr.length; j++){
                if(arr[j] != arr[i]){
                    if(countDel == 0){
                        len = j - i + 1 - k - 1;
                        max = Math.max(len , max);
                        break;
                    }
                    countDel--;
                }
            }
        }
        return max;
    }

    private static int optimized(int arr[], int k){
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int largest = 0;
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                map.get(arr[i]).add(i);
            }else{
                map.put(arr[i], new ArrayList<>());
                map.get(arr[i]).add(i);
            }
        }

        return largest;
    }
}

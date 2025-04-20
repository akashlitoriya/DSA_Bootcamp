package binarySearchQuestion;
import java.util.*;
public class MedianOfUniquenessAmazonOA {
    public int medianOfUniquenessArray(int[] nums) {
        int n = nums.length;
        long total = (long)n * (n + 1) / 2;
        long middle = total / 2;
        System.out.printf("Middle - %d, total - %d\n", middle, total);
        if(total % 2 != 0){
            middle = middle + 1;
        }
        int low = 1;
        int high = n;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            long count = getCountSubarray(mid, nums);
            System.out.println(mid + " + " + count);
            if(count < middle){
                low = mid + 1;
            }else{
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }
    public long getCountSubarray(int k, int arr[]){
        int i = 0;
        int j = 0;
        long count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(j < arr.length){
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            if(map.size() > k){
                while(i < arr.length && map.size() > k){
                    if(map.containsKey(arr[i])){
                        int freq = map.get(arr[i]);
                        map.put(arr[i], freq - 1);
                        if(map.get(arr[i]) == 0){
                            map.remove(arr[i]);
                        }
                    }
                    i++;
                }
            }
            count += j - i + 1;
            j++;
        }
        return count;
    }
}

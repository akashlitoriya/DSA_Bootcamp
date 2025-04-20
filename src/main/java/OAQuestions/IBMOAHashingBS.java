package OAQuestions;
import java.util.*;

public class IBMOAHashingBS {
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5};
        int queries[] = {1,6};
        System.out.println(Arrays.toString(getOperations(nums, queries)));
    }
    private static int[] getOperations(int arr[], int query[]){
        Arrays.sort(arr);
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            prefix[i] = arr[i] + prefix[i - 1];
        }
        int ans[] = new int[query.length];
        for(int i = 0; i < query.length; i++){
            int brk = getLowerBound(arr, query[i]);
            int left = 0;
            if(brk >= 0){
                left = query[i] * (brk + 1) - prefix[brk];
            }
            int right = 0;
            if(brk < arr.length){
                right = prefix[arr.length - 1] - prefix[brk] - query[i] * (arr.length - brk);
            }
            ans[i] = left + right;
        }
        return ans;
    }
    private static int getLowerBound(int arr[], int target){
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
}

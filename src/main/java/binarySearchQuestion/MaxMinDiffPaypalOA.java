package binarySearchQuestion;
import java.util.*;
//https://docs.google.com/document/d/1T3j6PKHw6tbOIWWMsoICs58ffE_hMYiIdoD_EVDMsM8/edit
public class MaxMinDiffPaypalOA {
    public static void main(String[] args) {
        int a[] = {1,4,2,9,8};
        int k = 3;
        System.out.println(getMaxMin(a, k));
    }
    private static int getMaxMin(int arr[], int k){
        Arrays.sort(arr);
        int low = 0;
        int high = (int)1e9;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(arr, k, mid)){
                low = mid + 1;
                ans = mid;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
    private static boolean isPossible(int arr[], int k, int x){
        int prev = arr[0];
        int count = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] - prev >= x){
                prev = arr[i];
                count++;
            }
        }
        if(count >= k){
            return true;
        }
        return false;
    }

}

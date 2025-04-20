package binarySearchQuestion;

import java.util.Arrays;

public class MaxPortfolioWithKStocksDeShaw {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int low = 0;
        int high = (int)1e9;
        int result = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int count = 0;
            for(int i = 0; i < nums.length; i++){
                if(i + 1 < nums.length && Math.abs(nums[i] - nums[i + 1]) <= mid){
                    i++; //done this to not include in other pair
                    count++;
                }
            }
            if(count >= p){
                high = mid - 1;
                result = mid;
            }else{
                low = mid + 1;
            }
        }
        return result;
    }
}

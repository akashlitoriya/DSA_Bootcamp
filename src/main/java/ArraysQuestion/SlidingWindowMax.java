package ArraysQuestion;

import java.util.Arrays;

public class SlidingWindowMax {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] slidMax = new int[n - k + 1];
        int max = nums[0];
        int i = 0;
        while(i < k){
            if(nums[i] > max){
                max = nums[i];
            }
            i++;
        }
        int j = 0;
        int l = 0;
        slidMax[l] = max;
        l++;
        while(i < n){
            if(nums[i] > max){
                slidMax[l] = max;
                l++;

            }else{
                if(nums[j] == max){
                    j++;
                    slidMax[l] = getMax(nums, j, i);
                }else{
                    slidMax[l] = max;
                    j++;
                }
                l++;
            }
            i++;

        }
        return slidMax;
    }
    private static int getMax(int[] arr, int p, int q){
        int max = arr[p];
        for(int i = p; i <= q; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int nums[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums,k)));
    }
}

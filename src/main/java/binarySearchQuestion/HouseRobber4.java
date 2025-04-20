package binarySearchQuestion;

public class HouseRobber4 {
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int low = 1;
        int high = (int)1e9;
        int ans = (int)1e9;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int count = 0;
            for(int i = 0; i < n; i++){
                if(nums[i] <= mid){
                    i++;
                    count++;
                }
            }
            if(count >= k){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}

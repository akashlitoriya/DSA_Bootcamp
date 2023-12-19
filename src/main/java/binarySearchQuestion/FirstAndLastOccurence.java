package binarySearchQuestion;

public class FirstAndLastOccurence {
    public int[] searchRange(int[] nums, int target) {
        int arr[] = new int[2];
        arr[0] = search(nums, target, true);
        arr[1] = search(nums, target, false);
        return arr;
    }
    private int search(int nums[], int target, boolean isFirstOccurence){
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        while(start <= end){
            int mid = start + (end - start) /2;
            if(target > nums[mid]){
                start = mid + 1;
            }
            else if(target < nums[mid]){
                end = mid - 1;
            }
            else{
                ans = mid;
                if(isFirstOccurence){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}

package binarySearchQuestion;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,8,9,0,1,2,3};
        int target = 10;
        System.out.println(search(arr, target));
    }
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                return mid;
            }
            //check in which half of the rotated array you are
            if(nums[mid] >= nums[0]){
                if(target > nums[mid] || target < nums[0]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }else{
                if(target < nums[mid] || target > nums[nums.length - 1]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}

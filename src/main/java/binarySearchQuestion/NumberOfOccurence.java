package binarySearchQuestion;

public class NumberOfOccurence {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,4,4,4,5,6,6,7,8};
        System.out.println(getOccurence(arr, 4));
    }
    private static int getOccurence(int[] nums, int target){
        int first = leftOccurence(nums, target);
        if(first == -1) return 0;
        int last = rightOccurence(nums, target);
        return last - first + 1;
    }
    private static int leftOccurence (int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int first = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                first = mid;
                high = mid - 1;
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return first;
    }
    private static int rightOccurence(int nums[], int target){
        int low = 0;
        int high = nums.length - 1;
        int last = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                last = mid;
                low = mid + 1;
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return last;
    }
}

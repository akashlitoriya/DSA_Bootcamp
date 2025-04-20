package binarySearchQuestion;

public class MiddleOccurrenceOfElement {
    public static void main(String[] args) {
        int arr[] = {1,2,2,2,2,2,3,3,4,5,6,7,8,9};
        int target = 2;
        System.out.println(getMiddle(arr, target));
    }
    private static int getMiddle(int arr[], int target){
        int first = binarySearch(arr, target, true);
        if(first == -1){
            return -1;
        }
        int second = binarySearch(arr, target, false);
        return (first + second) / 2;
    }
    private static int binarySearch(int arr[], int target, boolean isFirst){
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] > target){
                high = mid - 1;
            }
            else if(arr[mid] < target){
                low = mid + 1;
            }else {
                if(isFirst){
                    ans = mid;
                    high = mid - 1;
                }else{
                    ans = mid;
                    low = mid + 1;
                }
            }
        }
        return ans;
    }
}

package binarySearchQuestion;

public class FirstOccOfOne {
    public static void main(String[] args) {
        int arr[] = {0,0,0,0,1,1,1,1,1,1,1,1};
        System.out.println(getFirstOcc(arr));
    }
    private static int getFirstOcc(int arr[]){
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(arr[mid] == 1){
                high = mid - 1;
                ans = high;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}

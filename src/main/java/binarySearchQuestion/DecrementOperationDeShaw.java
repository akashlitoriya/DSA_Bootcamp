package binarySearchQuestion;

public class DecrementOperationDeShaw {
    public static void main(String[] args) {
        int arr[] = {4, 3, 2, 7};
        int max_move = 5;
        System.out.println(getMinOperations(arr, max_move));
    }
    private static int getMinOperations(int nums[], int max_move){
        int low = 0;
        int high = (int)1e9;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(nums, max_move, mid)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    private static boolean isPossible(int arr[], int max_move, int k){
        int move = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > 0){
                move += arr[i] / k;
                if(arr[i] % k != 0){
                    move++;
                }
            }
        }
        return move <= max_move;
    }

}

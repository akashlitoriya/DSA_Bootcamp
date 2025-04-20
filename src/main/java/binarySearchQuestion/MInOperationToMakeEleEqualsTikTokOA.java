package binarySearchQuestion;

public class MInOperationToMakeEleEqualsTikTokOA {
    public static void main(String[] args) {
        int arr[] = {1,1,3,3,5,5};
        System.out.println(getMinOperation(arr));
    }
    private static int getMinOperation(int arr[]){
        int maxi = getMax(arr);
        int low = 0;
        int high = maxi + 2; // As the max value for max value in array can be 1e9
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(arr, mid, maxi) || isPossible(arr, mid, maxi + 1)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    private static boolean isPossible(int arr[], int op, int maxEle){
        int two = op / 2;
        int one = op / 2;
        if(op % 2 != 0){
            one += 1;
        }
        for(int i = 0; i < arr.length; i++){
            int diff = maxEle - arr[i];
            if(two > 0){
                if(two - diff / 2 >= 0 ){
                    int used = diff / 2;
                    diff -= 2 * used;
                    two -= used;
                }else{
                    diff -= 2 * two;
                    two = 0;
                }
            }
            if(one >= diff){
                one -= diff;
                diff = 0;
            }else{
                return false;
            }
            if(diff != 0) return false;
        }
        return true;
    }
    private static int getMax(int arr[]){
        int maxi = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > maxi){
                maxi = arr[i];
            }
        }
        return maxi;
    }
}

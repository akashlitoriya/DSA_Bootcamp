package binarySearchQuestion;
import java.util.Arrays;
//https://docs.google.com/document/d/1tn-dP1ZznNLLghvsYPEQMwKO_uv15qG3Fs5toOdnpq4/edit
public class MaxGreatnessBlackRockOA {
    public static void main(String[] args) {
        int arr[] = {1,2,6,3,2,1};
        System.out.println(getMaxGreatness(arr));
    }
    private static int getMaxGreatness(int arr[]){
        Arrays.sort(arr);
        int low = 0;
        int high = arr.length;
        while(low <= high){
            int mid = low + (high - low) / 2;
            boolean tryMid = possible(arr, mid);
            if(tryMid){
                if(!possible(arr, mid + 1)){
                    return mid;
                }
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;

    }
    private static boolean possible(int arr[], int k){
        int n = arr.length;
        int i = k - 1;
        int j = n - 1;
        while(i >= 0){
            if(arr[i] >= arr[j]){
                return false;
            }
            i--;
            j--;
        }
        return true;
    }

}

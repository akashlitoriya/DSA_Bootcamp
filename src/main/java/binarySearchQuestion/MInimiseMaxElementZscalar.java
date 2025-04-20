package binarySearchQuestion;
//https://docs.google.com/document/d/1Jx6Ily5pkZrjHnpbCppZOEYxiXwmnuyB4Thv9cU5wQ4/edit
public class MInimiseMaxElementZscalar {
    public static void main(String[] args) {
        int arr[] = {1,5,7,6};
        System.out.println(getMinMax(arr));
    }
    private static int getMinMax(int arr[]){
        int low = arr[0];
        int high = arr[0];
        for(int i = 0; i < arr.length; i++){
            high = Math.max(high, arr[i]);
        }
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(arr, mid)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    private static boolean isPossible(int arr[], int k){
        int extra = 0;
        for(int i = arr.length - 1; i >= 1; i--){
            if(arr[i] + extra > k){
                extra = arr[i] + extra - k;
            }
        }
        if(extra + arr[0] > k){
            return false;
        }
        return true;
    }
}

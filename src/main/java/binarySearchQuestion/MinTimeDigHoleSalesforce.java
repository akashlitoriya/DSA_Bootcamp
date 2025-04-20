package binarySearchQuestion;
//https://www.desiqna.in/15662/salesforce-oa-intern-sde1-fresher-2023-set-1
public class MinTimeDigHoleSalesforce {
    public static void main(String[] args) {
        int arr[] = {5, 3, 20, 16, 18, 1, 10, 10, 9, 8};
        int m = 3;
        System.out.println(getMinTime(arr, m));
        int arr1[] = {1, 2, 3, 4, 5};
        int m1= 4;
        System.out.println(getMinTime(arr1, m1));
    }
    private static int getMinTime(int arr[], int m){
        int low = 0;
        int high = 0;
        for(int i = 0; i < arr.length; i++){
            high += arr[i];
        }
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(arr, m, mid)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    private static  boolean isPossible(int arr[], int m, int k){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] + sum <= k){
                sum += arr[i];
            }else{
                if(arr[i] <= k){
                    sum = arr[i];
                    m--;
                }else{
                    return false;
                }
            }
        }
        if(m < 1){
            return false;
        }
        return true;
    }
}

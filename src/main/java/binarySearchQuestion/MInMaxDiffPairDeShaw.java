package binarySearchQuestion;

public class MInMaxDiffPairDeShaw {
    public static void main(String[] args) {
        int stock[] = {3, 3, 3};
        int k = 2;
        System.out.println(getMin(stock, k));
    }
    private static long getMin(int arr[], int p){
        long low = 0;
        long high = (int)1e18;
        long result = 0;
        while(low <= high){
            long mid = low + (high - low) / 2;
            if(isPossible(arr, p, mid)){
                result = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return result;
    }
    private static boolean isPossible(int arr[], int p, long check){
        long req = p * check;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= check){
                req -= check;
            }else{
                req -= arr[i];
            }
        }
        if(req <= 0){
            return true;
        }
        return false;
    }
}

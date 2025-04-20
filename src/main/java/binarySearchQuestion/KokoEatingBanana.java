package binarySearchQuestion;

public class KokoEatingBanana {
    public static void main(String[] args) {
        int arr[] = {3,6,7,11};
        int h = 8;
        System.out.println(minEatingSpeed(arr, h));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for(int i = 1; i < piles.length; i++){
            if(piles[i] > max){
                max = piles[i];
            }
        }
        return binarySearch(1, max, piles, h);

    }
    private static int binarySearch(int low, int high, int arr[], int h){
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isValid(mid, arr, h)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    private static boolean isValid(int k, int arr[], int h){
        int total = 0;
        for(int i = 0; i < arr.length; i++){
            total += Math.ceil((double)arr[i] / k);
        }
        System.out.println(total);
        return total <= h;
    }
}

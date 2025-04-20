package binarySearchQuestion;

public class MaxThroughPutTwillioOA {
    public static void main(String[] args) {
        int pro[] = {4,2,7};
        int cost[] = {3,5,6};
        int budget = 32;
        System.out.println(getMaxThroughPut(pro, cost, budget));
    }
    private static int getMaxThroughPut(int arr[], int up[], int budget){
        int low = 1;
        int high = (int)1e5;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            boolean possible = check(arr, up, budget, mid);
            if(possible){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
    private static boolean check(int arr[], int up[], int budget, int x){
        int cost = 0;
        for(int i = 0; i < arr.length; i++){
            int req  = Math.round((float)x / arr[i]) - 1;
            cost += up[i] * req;
        }
        if(budget >= cost) return true;
        return false;
    }

}

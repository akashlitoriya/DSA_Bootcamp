package binarySearchQuestion;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {

    }
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int low = 0;
        int high = (int)1e9;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int last = stalls[0];
            int count = 1;
            for(int i = 1; i < n; i++){
                if(stalls[i] - last >= mid){
                    last = stalls[i];
                    count++;
                    if(count==k){
                        break;
                    }
                }
            }
            if(count == k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return high;
    }
}

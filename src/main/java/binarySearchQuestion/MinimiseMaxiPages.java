package binarySearchQuestion;

public class MinimiseMaxiPages {
    public static void main(String[] args) {

    }
    private static boolean isPossible(int arr[], int poss, int M){
        int count = 0;
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] + sum > poss){
                count++;
                sum = arr[i];
                if(sum > poss){
                    return false;
                }
            }else{
                sum += arr[i];
            }
        }
        if(count < M){
            return true;
        }
        return false;
    }
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        if(M > N) return -1;
        int high = 0;
        int low = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++){
            high += A[i];
            low = Math.min(A[i], low);
        }
        int result = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(A, mid, M)){
                result = mid;
                high = mid - 1;

            }else{
                low = mid + 1;
            }
        }
        return result;
    }
}

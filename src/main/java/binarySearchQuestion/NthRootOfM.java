package binarySearchQuestion;

public class NthRootOfM {
    public static void main(String[] args) {

    }
    private static int getNthRoot(int n, int m){
        int low = 1;
        int high = m;
        while(low <= high){
            int mid = low + (high - low) / 2;
            double nthRoot = Math.pow(mid, n);
            if(nthRoot > m){
                high = mid - 1;
            }else if(nthRoot < m){
                low = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}

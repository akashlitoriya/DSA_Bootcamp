package binarySearchQuestion;

public class SearchTwoDMatrix {
    public static void main(String[] args) {

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int high = n - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(matrix[mid][m - 1] < target){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        int cLow = 0;
        int cHigh = m - 1;
        while(cLow <= cHigh){
            int mid = cLow + (cHigh - cLow) / 2;
            if(matrix[low][mid] < target){
                cLow = mid + 1;
            }else if(matrix[low][mid] > target){
                cHigh = mid - 1;
            }else{
                return true;
            }
        }
        return false;
    }
}

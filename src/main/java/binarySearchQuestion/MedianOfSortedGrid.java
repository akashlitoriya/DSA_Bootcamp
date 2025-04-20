package binarySearchQuestion;

public class MedianOfSortedGrid {
    int median(int matrix[][], int R, int C) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 1;
        int high = 2000;
        int total = R * C;
        int median = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int lessEle = 0;
            for(int i = 0; i < n; i++){
                lessEle += getLessElement(matrix, i, mid);
            }
            if(lessEle > total / 2){
                median = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return median;
    }
    private static int getLessElement(int matrix[][], int row, int target){
        int idx = -1;
        int low = 0;
        int high = matrix[row].length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(matrix[row][mid] <= target){
                idx = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return idx + 1;
    }
}

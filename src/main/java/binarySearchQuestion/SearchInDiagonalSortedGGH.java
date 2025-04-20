package binarySearchQuestion;

public class SearchInDiagonalSortedGGH {
    public static void main(String[] args) {
        int arr[][] = {
                {1,3,6,10},
                {2,5,9,13},
                {4,8,12,15},
                {7,11,14,16}

        };
        System.out.println(binarySearchDiagonal2(arr,7));
    }
    private static int binarySearchDiagonal(int arr[][], int target){
        int n = arr.length;
        int low = 0;
        int high = (2 * n) - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            System.out.println("mid :" + mid);
            if(mid > n - 1){
                if(arr[n-1][(mid) % n] <= target){
                    low = mid;
                    System.out.println("Low : " + low);
                }else{
                    high = mid - 1;
                    System.out.println("HIGH : " + high);
                }
            }else{
                if(arr[mid][0] <= target){
                    low = mid;
                    System.out.println("Low : " + low);
                }else{
                    high = mid - 1;
                    System.out.println("HIGH : " + high);
                }
            }
        }
        return low;
    }
    private static int binarySearchDiagonal2(int arr[][], int target){
        int n = arr.length;
        int low = 0;
        int high = (2 * n) - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(mid > n - 1){
                if(arr[mid % n][n-1] < target){
                    low = mid + 1;
                }else{
                    high = mid;
                }
            }else{
                if(arr[0][mid] < target){
                    low = mid + 1;
                }else{
                    high = mid;
                }
            }
        }
        return low;
    }
}

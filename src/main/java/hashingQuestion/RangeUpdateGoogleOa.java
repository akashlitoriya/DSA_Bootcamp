package hashingQuestion;

import java.util.Arrays;

public class RangeUpdateGoogleOa {
    public static void main(String[] args) {
        int arr[] = new int[5];
        int queries[][] = {{0,4}, {2,4}};
        getQueriesResult(arr, queries);
        System.out.println(Arrays.toString(arr));

        int arr1[] = {5, 8, 10};
        int k = 2;

        System.out.println(getMaxSubsequence(arr1, 2));

        int arr2[] = {1, 5, 6};
        int t = 1;
        System.out.println(getMaxSubsequence(arr2,t));
    }
    private static int getMaxSubsequence(int arr[], int k){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max) max = arr[i];
        }
        int b[] = new int[max + k + 1];

        int idx = 0;
        while(idx < arr.length){
            int l = arr[idx] - k;
            int r = arr[idx] + k;
            b[l] = b[l] + 1;
            if(r + 1 < b.length) b[r + 1] = b[r + 1] - 1;
            idx++;
        }

        int sum = 0;
        int maxSubsequence = 0;
        for(int i = 0; i < b.length; i++){
            sum += b[i];
            b[i] = sum;
            maxSubsequence = (b[i] > maxSubsequence)? b[i] : maxSubsequence;

        }
        return maxSubsequence;
    }
    private static void getQueriesResult(int arr[], int[][] queries){
        for(int i = 0; i < queries.length; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            // incrementing the value at arr[l] by 1
            arr[l] = arr[l] + 1;
            if(r + 1 < arr.length){
                //decrementing the value at arr[r + 1] by 1
                arr[r+1] = arr[r + 1] - 1;
            }
        }
        //generating the array
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            arr[i] = sum;
        }

    }

    private static void bruteForce(int arr[], int[][] queries){
        for(int i = 0; i < queries.length; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            for(int j = l; j <= r; j++){
                arr[j] = arr[j] + 1;
            }
        }
    }
}

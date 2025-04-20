package OAQuestions;

import java.util.Arrays;

public class MinOpForMedian {
    public static void main(String[] args) {
        int arr[] = {3, 3, 6, 3, 9};
        int k = 2;
        System.out.println(getMinOperation(arr, k));
    }
    private static int getMinOperation(int arr[], int k){
        //Step-1: Sort the array
        Arrays.sort(arr);
        //make middle element as k
        int n = arr.length;
        int operation = 0;
        operation += Math.abs(arr[n/2] - k);
        arr[n/2] = k;

        int i = n / 2 + 1;
        while(i < n && arr[i] <= k){
            operation += Math.abs(arr[i] - k);
            i++;
        }

        int j = n / 2 - 1;
        while(j >= 0 && arr[j] >= k){
            operation += Math.abs(arr[j] - k);
            j--;
        }
        return operation;
    }
}

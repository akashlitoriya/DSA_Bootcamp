package sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {6,15,7,11,1,3,16,2};
        int n = arr.length;
        sort(0, n-1, arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void sort(int low, int high, int arr[]){
        if(low >= high) return ;

        int pivot = arr[low];
        int i = low;
        int j = high;
        while(i < j){
            while(i <= high && arr[i] <= pivot ){
                i++;
            }
            while(j >= low && arr[j] > pivot ){
                j--;
            }
            if(i < j) {
                swap(i,j, arr);
            }
        }
        swap(low, j, arr);
        sort(low, j - 1, arr);
        sort(j + 1, high, arr);
    }
    private static void swap(int p, int q, int arr[]){
        int temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }
}

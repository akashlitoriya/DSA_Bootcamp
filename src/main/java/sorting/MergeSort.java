package sorting;
import java.util.Arrays;
public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {6,15,7,11,1,3,16,2};
        int n = arr.length;
        sort(0, n-1, arr);
        System.out.println("Arrays Sorted: " + Arrays.toString(arr));
    }
    private static void sort(int st, int end, int arr[]){
        if(st == end){
            return ;
        }
        int mid = st + (end - st) / 2;
        sort(st, mid, arr);
        sort(mid + 1, end, arr);
        merge(st, mid, end, arr);
    }
    private static void merge(int st, int mid, int end, int arr[]){
        int temp[] = new int[end - st + 1];
        int i = st;
        int j = mid + 1;
        int k = 0;
        while(i < mid + 1 && j <= end){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i < mid + 1){
            temp[k] = arr[i];
            k++;
            i++;
        }
        while(j <= end){
            temp[k] = arr[j];
            k++;
            j++;
        }
        for(int q = 0; q < temp.length; q++){
            arr[st + q] = temp[q];
        }
    }
}

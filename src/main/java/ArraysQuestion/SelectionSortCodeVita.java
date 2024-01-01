package ArraysQuestion;
import java.util.*;
public class SelectionSortCodeVita {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String a =  in.nextLine();
        String[] strA = a.split(" ");
        int[] arrA = Arrays.stream(strA).mapToInt(Integer::parseInt).toArray();
        String b = in.nextLine();
        String[] strB =  b.split(" ");
        int[] arrB = Arrays.stream(strB).mapToInt(Integer::parseInt).toArray();

        int n = in.nextInt();
        selectionSort(arrA, arrB, n);
        System.out.println(Arrays.toString(arrA));
        for(int item: arrB){
            System.out.print(item+ " ");
        }
    }
    private static void selectionSort(int arrA[], int arrB[], int n){
        for(int i = 0; i < n; i++){
            int minIdx = i;
            for(int j = i + 1; j < arrA.length; j++){
                if(arrA[j] < arrA[minIdx]){
                    minIdx = j;
                }
            }
            swap(arrA, i, minIdx);
            swap(arrB, i, minIdx);
        }
    }
    private static  void swap(int arr[], int p, int q){
        int temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }
}

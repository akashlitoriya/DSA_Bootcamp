package OAQuestions;
import java.util.Arrays;

//https://www.desiqna.in/16369/ibm-oa-coding-questions-ctc-20l-set-10-2024?show=16369#q16369

public class MedianKIBM {
    public static void main(String[] args) {
        int arr[] = {3,3,6,3,9};
        int k = 2;
        System.out.println(getMinOperation(arr, k));
    }
    private static int getMinOperation(int arr[], int k){
        Arrays.sort(arr);
        int operation = 0;
        int n = arr.length;
        operation += Math.abs(arr[n/2] - k);
        //on its left all element needs to be smaller or equals to K
        int i = n/2 - 1;
        while(i >= 0 ){
            if(arr[i] > k){
                operation += arr[i] - k;
            }else{
                break;
            }
            i--;
        }
        //on its right all the elements need to be either equals to greater than k
        int j = n/2 + 1;
        while(j < n){
            if(arr[j] < k){
                operation += k - arr[j];
            }else{
                break;
            }
            j++;
        }
        return operation;
    }
}

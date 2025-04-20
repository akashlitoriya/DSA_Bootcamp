package hashingQuestion;

public class MediaNetOASumBElements {
    public static void main(String[] args) {
        int arr[] = {5,-2,3,1,2};
        int b = 3;
        System.out.println(getMaxSum(arr, b));
    }
    private static int getMaxSum(int arr[], int b){
        int maxSum = Integer.MIN_VALUE;
        int n = arr.length;
        int prefix[] = new int[n];
        int suffix[] = new int[n];
        int prefixSum = 0;
        int suffixSum = 0;
        for(int i = 0; i < n; i++){
            prefixSum += arr[i];
            suffixSum += arr[n - i - 1];
            prefix[i] = prefixSum;
            suffix[n - i - 1] = suffixSum;
        }

        //Now selecting the b elements
        for(int i = 0; i < b; i++){
            int sum = 0;
            if(n - b + i < n) {
                sum = prefix[i] - arr[i] + suffix[n - b + i];
            }else{
                sum = prefix[i] - arr[i];
            }
            if(sum > maxSum) maxSum = sum;
        }
        return maxSum;
    }
}

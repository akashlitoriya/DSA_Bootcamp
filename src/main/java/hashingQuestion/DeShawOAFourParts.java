package hashingQuestion;

public class DeShawOAFourParts {
    public static void main(String[] args) {
        int arr[] = {-3,4,-5,2,6,-5};
        System.out.println(getMaxSum(arr));
    }
    private static int getMaxSum(int arr[]){
        int n = arr.length;
        int suffix[] = new int[n];
        suffix[n-1] = arr[n-1];
        int suffixSum = arr[n-1];
        for(int i = n - 2; i >= 0; i--){
            suffixSum += arr[i];
            suffix[i] = Math.min(suffix[i + 1], suffixSum);
        }

        int prefixSum = 0;
        int prefix[] = new int[n];
        for(int i = 0; i < n; i++){
            prefixSum += arr[i];
            if(prefixSum > arr[i]){
                prefixSum = arr[i];
                prefix[i] = prefixSum;
            }else{
                prefix[i] = prefixSum;
            }
        }

        //Now we will find the minimum value of p2 and p4
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(suffix[i] + prefix[i] < min){
                min = suffix[i] + prefix[i];
            }
            sum += arr[i];
        }
        return sum - min;
    }
}

package OAQuestions;

public class AmazonOAConcatenationOfNumber {
    public static void main(String[] args) {
        int arr[] = {3,14,15};
        System.out.println(getSum(arr));
    }
    private static int getSum(int arr[]){
        int n = arr.length;
        int sum = 0;
        int prefixSum = 0;
        for(int i = 0; i < n; i++){
            int y = getNumDigits(arr[i]);
            sum += (int)Math.pow(10, y) * (prefixSum) + (i) * arr[i];
            prefixSum += arr[i];
        }
        return sum;
    }
    private static int getNumDigits(int n){
        int count = 0;
        while(n > 0){
            count++;
            n = n / 10;
        }
        return count;
    }
}

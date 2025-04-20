package hashingQuestion;

public class UberOAConcateSum {
    public static void main(String[] args) {
        int arr[] = {10,2};
        System.out.println(getSum(arr));
    }
    private static int getSum(int arr[]){
        int n = arr.length;
        int digits[] = new int[6];
        //finding the number of elements having digits
        for(int i = 0; i < n; i++){
            int dig = getNumberOfDigits(arr[i]);
            digits[dig]++;
        }
        int sum = getArraySum(arr);
        //forming the pairs
        int ans = 0;
        for(int idx = 0; idx < n; idx++){
            int temp = 0;
            int j = 0;
            while(j < 6){
                temp += arr[idx] * Math.pow(10, j) * digits[j];
                j++;
            }
            temp = temp + sum;
            ans += temp;
        }
        return ans;

    }
    private static int getArraySum(int arr[]){
        int n = arr.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
        }
        return sum;
    }
    private static int getNumberOfDigits(int n){
        int count = 0;
        while(n != 0){
            count++;
            n = n / 10;
        }
        return count;
    }
}

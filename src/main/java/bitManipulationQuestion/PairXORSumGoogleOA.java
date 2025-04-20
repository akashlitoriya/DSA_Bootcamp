package bitManipulationQuestion;

public class PairXORSumGoogleOA {
    public static void main(String[] args) {
        int a[] = {2,7,1,5,8};
        System.out.println(getSum(a));
    }
    private static long getSum(int arr[]){
        int n = arr.length;
        int prefixSum[][] = new int[32][n];
        for(int i = 0; i < n; i++){
            for(int bit = 0; bit < 32; bit++){
                int temp = (arr[i] >> bit) & 1;
                if(i == 0){
                    prefixSum[bit][i] = temp;
                }else{
                    prefixSum[bit][i] = temp + prefixSum[bit][i - 1];
                }
            }
        }
        long sum = 0;
        for(int bit = 0; bit < 32; bit++){
            int pair = prefixSum[bit][n-1] * (n - prefixSum[bit][n-1]);
            sum += (long)Math.pow(2, bit) * pair;
        }
        return sum;
    }
}

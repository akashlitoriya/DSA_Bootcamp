package bitManipulationQuestion;

public class XORSummationGoogleOA {
    public static void main(String[] args) {
        int a[] = {1,2,3};
        int b[] = {5,5,5};
        System.out.println(getSum(a,b));
    }
    private static long getSum(int a[], int b[]){
        int n = a.length;
        int aPre[][] = getPrefixSum(a, n);
        int bPre[][] = getPrefixSum(b, n);
        long sum = 0;
        for(int bit = 0; bit < 32; bit++){
            int count1 = aPre[bit][n-1] * (n - bPre[bit][n-1]);    //1 of a pair with 0 of b
            int count2 = (n - aPre[bit][n - 1]) * bPre[bit][n-1];  //0 of a pair with 1 of b;
            sum += (long)Math.pow(2, bit) * (count1 + count2);
        }
        return sum;
    }
    private static int[][] getPrefixSum(int a[], int n){
        int prefixSum[][] = new int[32][n];
        for(int i = 0; i < n; i++){
            for(int bit = 0; bit < 32; bit++){
                int temp = (a[i] >> bit) & 1;
                if(i == 0){
                    prefixSum[bit][i] = temp;
                }else{
                    prefixSum[bit][i] = temp + prefixSum[bit][i - 1];
                }
            }
        }
        return prefixSum;
    }
}

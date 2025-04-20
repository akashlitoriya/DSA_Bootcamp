package bitManipulationQuestion;

public class SumOfPairAND {
    public static void main(String[] args) {
        int arr[] = {5,10,15};
        System.out.println(getSum(arr));
    }
    private static long getSum(int arr[]){
        int n = arr.length;
        int matrix[][] = new int[n][32];
        for(int i = 0; i < n; i++){
            for(int bit = 0; bit < 32; bit++){
                if((arr[i] & (1 << bit)) != 0){
                    matrix[i][bit] = 1;
                }
            }
        }

        long ans = 0;
        for(int i = 0; i < 32; i++){
            int pairs = 0;
            int ones = 0;
            for(int j = 0; j < n; j++){
                if(matrix[j][i] == 1){
                    pairs += ones;
                    ones++;
                }
            }
            ans += (long)(pairs * (int)Math.pow(2, i));
        }
        return ans;
    }
}

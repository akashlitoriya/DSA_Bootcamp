package bitManipulationQuestion;
import java.util.Arrays;
public class AndTheBitsCodeNationOA {
    public static void main(String[] args) {
        int a[] = {3,1,7};
        int q[][] = {{1,1,3,3}};
        System.out.println(Arrays.toString(getQueryResult(a, q)));
        int a1[] = {8,6,5,9,7,7,9,3,8};
        int q1[][] = {{3,5,5,5}};
        System.out.println(Arrays.toString(getQueryResult(a1,q1)));
    }
    private static int[] getQueryResult(int arr[], int queries[][]){
        int n = arr.length;
        int prefix[][] = new int[30][n];
        for(int i = 0; i < n; i++){
            for(int bit = 0; bit < 30; bit++){
                int ithBit = arr[i] >> bit & 1;

                if( i != 0){
                    prefix[bit][i] = prefix[bit][i - 1] + ithBit;
                }else{
                    prefix[bit][i] = ithBit;
                }
            }
        }
        int ans[] = new int[queries.length];
        for(int q = 0; q < queries.length; q++){
            int l1 = queries[q][0] - 1;
            int r1 = queries[q][1] - 1;
            int l2 = queries[q][2] - 1;
            int r2 = queries[q][3] - 1;
            int x1 = 0;
            int x2 = 0;
            for(int bit = 0; bit < 30; bit++){
                int diff1 = prefix[bit][r1];
                int diff2 = prefix[bit][r2];
                if(l1 > 0){
                    diff1 -= prefix[bit][l1 - 1];
                }
                if(l2 > 0){
                    diff2 -= prefix[bit][l2 - 1];
                }
                if(diff1 == r1 - l1 + 1){
                    x1 += (int)Math.pow(2, bit);
                }
                if(diff2 == r2 - l2 + 1){
                    x2 += (int)Math.pow(2, bit);
                }
            }
            ans[q] = x1 ^ x2;
        }
        return ans;
    }
}

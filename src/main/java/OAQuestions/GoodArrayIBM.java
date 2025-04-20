package OAQuestions;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.desiqna.in/16124/ibm-oa-coding-questions-ctc-15l-set-1-2023?show=16124#q16124
public class GoodArrayIBM {
    public static void main(String[] args) {
        long n = 26;
        int[][] queries = {{1,2,1009}, {3,3,5}};
        System.out.println(Arrays.toString(goodQuery(n, queries)));
    }
    private static long[] goodQuery(long n, int[][] queries){
        ArrayList<Long> goodArray = getGoodArray(n);
        return getQueryResult(goodArray, queries);
    }
    private static long[] getQueryResult(ArrayList<Long> goodArray, int[][] queries){
        long[] prefixProduct = new long[goodArray.size()];
        long product = 1;
        for(int i = 0; i < goodArray.size(); i++){
            product *= goodArray.get(i);
            prefixProduct[i] = product;
        }
        long[] ans = new long[queries.length];
        for(int i = 0; i < queries.length; i++){
            long left = 1;
            if(queries[i][0] - 1 > 0){
                left = prefixProduct[queries[i][0] - 2];
            }
            long right = prefixProduct[queries[i][1] - 1];
            ans[i] = (right / left) % queries[i][2];
        }
        return ans;
    }
    private static ArrayList<Long> getGoodArray(long N){
        ArrayList<Long> pow = new ArrayList<>();
        while(N != 0){
            pow.add(N%2);
            N = N / 2;
        }
        ArrayList<Long> goodArray = new ArrayList<>();
        for(int i = 0; i < pow.size(); i++){
            if(pow.get(i) == 1){
                goodArray.add((long)Math.pow(2,i));
            }
        }
        return goodArray;
    }
}

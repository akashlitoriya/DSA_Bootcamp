package hashingQuestion;

import java.util.Arrays;

public class CumulativeSumQuery {

    public static void main(String[] args) {
        int arr[] = {1,4,1};
        int query[][] = {{1,1}, {1,2}, {0,2}};
        System.out.println(Arrays.toString(getQuerySum(arr, query)));
    }

    private static int[] getQuerySum(int arr[], int query[][]){
        int n = arr.length;
        int m = query.length;
        int queryResult[] = new int[m];
        int prefixSum[] = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            prefixSum[i] = sum;
        }
        //now execute all the queries
        for(int i = 0; i < m; i++){
            int x = query[i][0];
            int y = query[i][1];
            queryResult[i] = prefixSum[y] - prefixSum[x] + arr[x];
        }
        return queryResult;
    }
}

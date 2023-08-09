package ArraysQuestion;

import java.util.ArrayList;
import java.util.Arrays;

public class HandleSubqueriesUpdate {
    public static void main(String[] args) {
        int[] nums1 = {1,0,1};
        int[] nums2 = {0,0,0};

        int[][] queries = { {1,1,1}, {2,1,0}, {3,0,0} };
        System.out.println(Arrays.toString(handleQuery(nums1,nums2,queries)));
    }
    public static long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        ArrayList<Long> ans = new ArrayList<>();
        for(int i = 0; i < queries.length; i++){
            int type = queries[i][0];
            if(type == 1){
                int l = queries[i][1];
                int r = queries[i][2];
                for(int j = l; j <= r; j++){
                    if(nums1[j] == 1){
                        nums1[j] = 0;
                    }else{
                        nums1[j] = 1;
                    }
                }
            }
            else if(type == 2){
                int p = queries[i][1];
                for(int z = 0; z < nums2.length; z++){
                    nums2[z] = nums2[z] + nums1[z] * p;
                }

            }else{
                long sum = getSum(nums2);
                ans.add(sum);
            }

        }
        long[] result = new long[ans.size()];
        for(int k = 0; k < result.length; k++){
            result[k] = ans.get(k);
        }
        return result;
    }
    private static long getSum(int[] arr){
        long sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }
}

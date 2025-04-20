package bitManipulationQuestion;

public class LongestSubseqAtlassianOA {
    public static void main(String[] args) {
        int arr[] = {7, 4, 11, 8, 3};
        System.out.println(getLongestSubseq(arr));
    }
    private static int getLongestSubseq(int arr[]){
        int n = arr.length;
        int prefixSum[][] = new int[32][n];
        for(int idx = 0; idx < n; idx++){
            for(int bit = 0; bit < 32; bit++){
                int temp = (arr[idx] >> bit) & 1;
                if(idx == 0){
                    prefixSum[bit][idx] = temp;
                }else{
                    prefixSum[bit][idx] = temp + prefixSum[bit][idx - 1];
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 32; i++){
            max = Math.max(max, prefixSum[i][n-1]);
        }
        return max;
    }
}

package hashingQuestion;

public class MicrosoftOARehabilitation {
    public static void main(String[] args) {
        int arr[] = {4,2,5,4,3,5,1,4,2,7};
        int x = 3;
        int y = 2;
        System.out.println(getMinRehabCost(arr, x, y));
        int arr1[] = {10,3,4,7};
        int x1 = 2;
        int y1 = 3;
        System.out.println(getMinRehabCost(arr1, x1,y1));
        int arr2[] = {4,2,3,7};
        int x2 = 2;
        int y2 = 2;
        System.out.println(getMinRehabCost(arr2, x2, y2));
    }
    private static int getMinRehabCost(int arr[], int x, int y){
        int n = arr.length;
        int prefixSum[] = new int[n];
        int minCost = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(i < y){
                prefixSum[i] = arr[i];
            }else{
                prefixSum[i] = prefixSum[i - y] + arr[i];
                if(0 <= i - (x-1)*y){
                    int sum = prefixSum[i] - prefixSum[i - (x - 1)*y] + arr[i - (x-1)*y];
                    minCost = Math.min(minCost, sum);
                }
            }
        }
        return minCost;
    }
}

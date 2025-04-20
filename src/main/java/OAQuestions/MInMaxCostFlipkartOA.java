package OAQuestions;

//https://docs.google.com/document/d/1YQXkGGB3KY6Ml5B-DC9f5De0qPHzL3jCsADqZrDLVqQ/edit
import java.util.Arrays;

public class MInMaxCostFlipkartOA {
    public static void main(String[] args) {
        int arr[] = {2, 3, 1};
        System.out.println(Arrays.toString(getMinAndMaxCost(arr)));
    }
    private static int[] getMinAndMaxCost(int arr[]){
        int n = arr.length;
        int maxEle = arr[0];
        int minEle = arr[0];
        for(int i = 1; i < n; i++){
            if(arr[i] > maxEle){
                maxEle = arr[i];
            }
            if(arr[i] < minEle){
                minEle = arr[i];
            }
        }
        int minCost = maxEle - minEle;
        int maxCost = 0;
        for(int i = 0; i < n; i++){
            maxCost += Math.max(arr[i] - minEle, maxEle - arr[i]);
        }
        return new int[]{minCost, maxCost - minCost};
    }
}

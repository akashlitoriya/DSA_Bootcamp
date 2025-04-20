package hashingQuestion;
import java.util.HashMap;
public class LongestSubarrSumZero {
    public static void main(String[] args) {
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        int n = 8;
        System.out.println(getLongest(arr, n));
    }
    private static int getLongest(int arr[], int n){
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            if(sum == 0) max = i + 1;
            if(map.containsKey(sum)){
                int len = i - map.get(sum);
                if(len > max) max = len;
            }else{
                map.put(sum, i);
            }
        }
        return max;
    }
}

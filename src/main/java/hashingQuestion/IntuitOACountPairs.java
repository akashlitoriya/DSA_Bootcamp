package hashingQuestion;

import java.util.HashMap;

public class IntuitOACountPairs {
    public static void main(String[] args) {
        int arr[] = {1,1,1,2};
        int k = 0;
        System.out.println(getNumberOfPairs(arr, k));
    }
    private static int getNumberOfPairs(int arr[], int k){
        int n = arr.length;
        if(k == 0) return n;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < n; i++){
            int req = arr[i] - k;
            if(map.containsKey(req)){
                count++;
                if(map.get(req) == 1){
                    map.remove(req);
                }else{
                    map.put(req, map.get(req) - 1);
                }
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return count;
    }
}

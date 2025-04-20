package binarySearchQuestion;

//https://www.desiqna.in/17466/code-with-cisco-cache-service-request-online-assessment-kumar

import java.util.HashMap;
import java.util.Map;

public class CiscoOAServiceRequest {
    public static void main(String[] args) {
        int n = 3;
        int cache[] = {1,1,3,1,1};
        System.out.println(getMinTime(cache, 3, cache.length));
    }
    private static int getMinTime(int cache[], int n, int m){
        HashMap<Integer, Integer> map = new HashMap<>();
        int low = 1;
        int high = 0;
        for(int i = 0; i < m; i++){
            map.put(cache[i], map.getOrDefault(cache[i], 0) + 1);
            high = Math.max(map.get(cache[i]), high);
        }
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            boolean check = check(map, n, mid);
            if(check){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;

    }
    private static boolean check(HashMap<Integer, Integer> cache, int n, int k){
        int extra = ((n - cache.size()) * k) / 2;
        int left = 0;

        for(Map.Entry<Integer, Integer> entry: cache.entrySet()){
            if(entry.getValue() > k){
                left += entry.getValue() - k;
            }else{
                extra += (k - entry.getValue()) / 2;
            }
        }
        if(extra >= left){
            return true;
        }
        return false;
    }
}

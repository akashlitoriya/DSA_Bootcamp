package OAQuestions;

import java.util.HashMap;
import java.util.Map;

public class TripletSumDivisibleKIBM {
    public static void main(String[] args) {
        int arr[] = {3,3,4,7,8};
        int d = 5;
        System.out.println(getTriplet(arr, d));
        System.out.println("Brute Force :" + bruteForce(arr, d));
    }
    private static int bruteForce(int arr[], int d){
        int ans = 0;
        int n = arr.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                for(int k = j + 1; k < n; k++){
                    if((arr[i] + arr[j] + arr[k]) % d == 0){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    private static int getTriplet(int arr[], int d){
        int n = arr.length;
        int ans = 0;
        Map<Integer, Integer> store = new HashMap<>();
        for(int j = 0; j < n; j++){
            for(int k = j + 1; k < n; k++){
                int req = (d - (arr[j] + arr[k]) % d ) % d;
                ans += store.getOrDefault(req, 0);
            }
            store.put(arr[j], store.getOrDefault(arr[j], 0) + 1);
        }
        return ans;
    }
}

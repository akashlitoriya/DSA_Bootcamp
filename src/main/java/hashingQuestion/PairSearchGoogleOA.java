package hashingQuestion;

import java.util.HashMap;

public class PairSearchGoogleOA {
    public static void main(String[] args) {
        int arr[] = {4,2,1,2};
        System.out.println(getCountOfPairs(arr));
    }
    private static int getCountOfPairs(int arr[]){
        int count = 0;
        HashMap<Integer, Integer> store = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int req = arr[arr[arr[i] - 1] - 1];
            if(store.containsKey(req)){
                count += store.get(req);

            }
            store.put(req, store.getOrDefault(req, 0) + 1);
        }
        return count;
    }
}

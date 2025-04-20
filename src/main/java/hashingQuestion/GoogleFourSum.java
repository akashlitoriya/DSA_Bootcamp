package hashingQuestion;
import java.util.HashMap;
public class GoogleFourSum {
    public static void main(String[] args) {

    }
    private static int getQuadruplets(int arr[], int sum){
        int count = 0;
        int n = arr.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int req = sum - (arr[i] + arr[j]);
                HashMap<Integer, Integer> store = new HashMap<>();
                //filling the values from j + 1 to n
                for(int k = j + 1; k < n; k++){
                    store.put(arr[k], store.getOrDefault(arr[k], 0) + 1);
                }

                //started finding the actual pairs.
                int count_temp = 0;
                for(int k = j + 1; k < n; k++){
                    if(store.containsKey(req - arr[k])){
                        count_temp += store.get(req - arr[k]);
                    }
                    //it is possible that the remaining sum is equal to arr[k] means that we have selected a pair
                    // arr[i] + arr[j] + arr[k] + arr[k]   -- >    Not valid quadruplet
                    if(req - arr[k] == arr[k]) count_temp--;
                }
                //as we counted the pairs twice, so we will reduce count to half
                // arr[i] + arr[j] + arr[k] + arr[l]  && arr[i] + arr[j] + arr[l] + arr[k] is same
                count_temp /= 2;
                count += count_temp;
            }
        }
        return count;
    }
}

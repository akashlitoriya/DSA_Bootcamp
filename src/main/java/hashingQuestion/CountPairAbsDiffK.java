package hashingQuestion;
import java.util.HashMap;
public class CountPairAbsDiffK {
    public static void main(String[] args) {

    }
    public static int countKDifference(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int pos = k + nums[i];
            int neg = nums[i] - k;
            if(map.containsKey(pos)){
                count += map.get(pos);
            }
            if(map.containsKey(neg)){
                count += map.get(neg);
            }
            if(map.containsKey(nums[i])){
                int val = map.get(nums[i]) + 1;
                map.put(nums[i], val);

            }else{
                map.put(nums[i], 1);
            }
        }
        return count;
    }
}

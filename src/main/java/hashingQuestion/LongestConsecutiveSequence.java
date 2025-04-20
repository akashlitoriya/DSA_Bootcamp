package hashingQuestion;
import java.util.HashMap;
public class LongestConsecutiveSequence {
    public static void main(String[] args) {

    }
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], true);
        }
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i] - 1)){

                int count = 1;

                int key = nums[i]+1;
                while(map.containsKey(key)){
                    map.put(key, false);
                    key += 1;

                    count++;
                }
                if(count > max) max = count;
            }
        }
        return max;
    }
}

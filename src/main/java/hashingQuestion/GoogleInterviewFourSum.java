package hashingQuestion;
import java.util.HashMap;
public class GoogleInterviewFourSum {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        int n = nums1.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int sum = nums1[i] + nums2[j];
                map1.put(sum, map1.getOrDefault(sum, 0) + 1);
            }
        }
        int count = 0;
        for(int k = 0; k < n; k++){
            for(int l = 0; l < n; l++){
                int sum = nums3[k] + nums4[l];
                if(map1.containsKey(-sum)){
                    count+= map1.get(-sum);
                }
            }
        }
        return count;
    }
}

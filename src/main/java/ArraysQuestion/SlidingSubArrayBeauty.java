package ArraysQuestion;
import java.util.TreeMap;
import java.util.PriorityQueue;

public class SlidingSubArrayBeauty {

    /*
    Brute Force Approach : Finds Xth smallest using Priority Queue(minHeap)
     */
    public int[] getSubarrayBeauty1(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int i = 0;
        int j = i + k - 1;
        int z = 0;
        while(j < n){
            ans[z] = getXthMinimum(nums, i, j, x);
            z++;
            i++;
            j++;
        }
        return ans;
    }
    private int getXthMinimum(int[] nums,int i, int j, int x){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int p = i; p <= j; p++){
            pq.add(nums[p]);
        }
        int min = 0;
        while(x > 0){
            min = pq.poll();
            x--;
        }
        return min < 0? min : 0;
    }
    /*
    Optimized Code - DS used are TreeMap
     */
    public int[] getSubarrayBeauty2(int[] nums, int k, int x) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = nums.length;
        int ans[] = new int[n - k + 1];
        for(int i = 0; i < k; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        ans[0] = getMin(map, x);
        for(int i = k; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
            map.put(nums[i - k], map.getOrDefault(nums[i - k],0) - 1);
            if(map.get(nums[i - k]) == 0){
                map.remove(nums[i - k]);
            }
            ans[i-k+1] = getMin(map, x);
        }
        return ans;
    }
    private int getMin(TreeMap<Integer, Integer> map, int x){
        int smallest = 0;
        for(Integer val : map.keySet()){
            if(val < 0){
                smallest += map.get(val);
            }else{
                return 0;
            }
            if(smallest >= x){
                return val;
            }
        }
        return 0;
    }
    /*
    Solution From Discussion Section :-
    Iterate over the counter array and sum the counts of each number. When the sum of counts is greater than or equal to
    x we have found out xth smallest number. If sum of counts is never greater than or equal to x there aren't enough
    negative numbers.
    Line by line explanation:

    1 - if nums[i] < 0: counter[nums[i] + 50] += 1 For negative numbers increment counter, -50 is mapped to 0, -1 is
        mapped to 49.
    2 - if i - k >= 0 and nums[i - k] < 0: counter[nums[i - k] + 50] -= 1 Since we only have to consider a window of
        size k, we need to remove elements on the front of the sliding window. The front will be at index i - k.
        Now since we only added negative numbers to the counter we'll remove only if nums[i - k] is negative.
    3 - if i - k + 1 < 0: continue This checks if the sliding window has atleast k elements
    4 - The rest of the code iterates over the counter array to find the xth smallest number.

    T.C. = O(N * 50)
    S.C. = O(N - K + 1)
     */
    public int[] getSubarrayBeauty3(int[] nums, int k, int x) {
        int[] counter = new int[50], ans = new int[nums.length - k + 1];;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) counter[nums[i] + 50]++;
            if (i - k >= 0 && nums[i - k] < 0) counter[nums[i - k] + 50]--;
            if (i - k + 1 < 0) continue;
            for (int j = 0, count = 0; j < 50; j++) {
                count += counter[j];
                if (count >= x) {
                    ans[i - k + 1] = j - 50;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}

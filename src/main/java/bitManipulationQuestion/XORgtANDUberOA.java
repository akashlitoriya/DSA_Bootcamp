package bitManipulationQuestion;
import java.util.HashMap;
public class XORgtANDUberOA {
    public static void main(String[] args) {
        int arr[] = {4,3,5,2};
        System.out.println(getPairs(arr));
    }
    private static int getPairs(int arr[]){
        int n = arr.length;
        int total = n * (n - 1) / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        int bad = 0;
        for(int i = 0; i < n; i++){
            int bit = leftMostBit(arr[i]);
            if(map.containsKey(bit)){
                bad += map.get(bit);
            }
            map.put(bit, map.getOrDefault(bit, 0) + 1);
        }
        return total - bad;
    }
    private static int leftMostBit(int n){
        int bit = 31;
        while(bit >= 0){
            if((n & (1 << bit)) != 0){
                return bit;
            }
            bit--;
        }
        return bit;
    }
}

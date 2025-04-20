package bitManipulationQuestion;
import java.util.HashMap;
//https://www.desiqna.in/7886/triology-codenation-coding-oa-sde-set-25-2022
public class NumberOfGoodSubArrayCodeNation {

    public static void main(String[] args) {

    }
    private static int getGoodSubArray(int arr[]){
        int n = arr.length;
        int preSum[][] = new int[n][30];
        for(int bit = 0; bit < 30; bit++){
            for(int i = 0; i < n; i++){
                if(i > 0){
                    preSum[i][bit] = preSum[i - 1][bit];
                    if((arr[i] & (1 << bit)) == 1){
                        preSum[i][bit] += 1;
                    }
                }else{
                    if((arr[i] & (1 << bit)) == 1){
                        preSum[i][bit] = 1;
                    }
                }
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int countGood = 0;
        for(int i = 0; i < n; i++){
            int mask = 0;
            for(int bit = 0; bit < 30; bit++){
                if(preSum[i][bit] % 2 != 0){
                    mask += (int)Math.pow(2, bit);
                }
            }
            if(mask == 0){
                countGood += 1;
            }
            countGood += map.getOrDefault(mask, 0);
            map.put(mask, map.getOrDefault(mask, 0) + 1);
        }
        return countGood;
    }
}

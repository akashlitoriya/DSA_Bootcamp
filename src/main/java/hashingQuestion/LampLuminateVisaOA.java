package hashingQuestion;
import java.util.Arrays;
public class LampLuminateVisaOA {
    public static void main(String[] args) {
        int lamps[][] = {{1,7}, {5,11}, {7,9}};
        int pos[] = {7,1,5,10,9,15};
        System.out.println(Arrays.toString(getNoLamps(lamps, pos)));
    }
    private static int[] getNoLamps(int[][] lamps, int pos[]){
        int max = pos[0];
        for(int i = 1; i < pos.length; i++){
            max = Math.max(max, pos[i]);
        }

        int range[] = new int[max + 5];
        for(int i = 0; i < lamps.length; i++){
            int l = lamps[i][0];
            int r = lamps[i][1];
            range[l] = 1;
            if(r + 1 < max + 5){
                range[r + 1] = -1;
            }
        }

        int sum = 0;
        for(int i = 0; i < range.length; i++){
            sum += range[i];
            range[i] = sum;
        }

        int ans[] = new int[pos.length];
        for(int i = 0; i < pos.length; i++){
            ans[i] = range[pos[i]];
        }
        return ans;
    }
}

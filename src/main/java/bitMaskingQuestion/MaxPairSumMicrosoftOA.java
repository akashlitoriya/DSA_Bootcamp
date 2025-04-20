package bitMaskingQuestion;
//https://docs.google.com/document/d/1V_AJraTp12AXORlHQs-yepVpd7WDwp3h3bfgPvnXugo/edit
import java.util.HashMap;
public class MaxPairSumMicrosoftOA {
    public static void main(String[] args) {
        int arr[] = {53,1,36,103,53,5};
        System.out.println(getMaxSum(arr));
    }
    private static String getBitMask(int n){
        StringBuilder sb = new StringBuilder(10);
        for(int i = 0; i < sb.capacity(); i++){
            sb.append('0');
        }
        while(n != 0){
            int digit = n % 10;
            sb.setCharAt(9 - digit, '1');
            n = n / 10;
        }
        return sb.toString();
    }
    private static boolean check(String a, String b){
        int i = 0;
        while(i < 10){
            if(a.charAt(i) == b.charAt(i) && a.charAt(i) == '1'){
                return false;
            }
            i++;
        }
        return true;
    }
    private static int getMaxSum(int arr[]){
        HashMap<String, Integer> map = new HashMap<>();
        int maxSum = 0;
        for(int i = 0; i < arr.length; i++){
            String maskA = getBitMask(arr[i]);
            int possNum = 0;
            while(possNum < 1024){
                String maskB = getBitMask(possNum);
                if(check(maskA, maskB)){
                    int sum = arr[i] + map.getOrDefault(maskB, 0);
                    maxSum = Math.max(maxSum, sum);
                }
                possNum++;
            }
            map.put(maskA, Math.max(arr[i], map.getOrDefault(maskA, 0)));
        }
        return maxSum;

    }
}

package OAQuestions;

import java.util.Arrays;
public class AmazonMLSchoolOA{
    static int mod = (int)1e4 + 7;
    public static void main(String[] args) {
        int n = 4;
        char ch[] = new char[n];
        System.out.println(getSum(0, n, 0));
    }
    private static int getSum(int idx, int n, int zero){
        if(idx == n){
            if(zero >= 2){

                return 1;
            }
            return 0;
        }
        int ans = 0;
        if(idx > 0){
            for(int i = 0; i <= 9; i++){
                if( i == 0){
                    ans += getSum(idx + 1, n, zero + 1);
                }else{
                    ans += getSum(idx + 1, n, zero);
                }
            }
        }else{
            for(int i = 1; i <= 9; i++){
                if( i == 0){
                    ans += getSum(idx + 1, n, zero + 1);
                }else{
                    ans += getSum(idx + 1, n, zero);
                }
            }
        }


        return ans % mod;
    }
}

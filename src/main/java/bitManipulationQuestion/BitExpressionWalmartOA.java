package bitManipulationQuestion;

public class BitExpressionWalmartOA {
    public static void main(String[] args) {
        int a = 1, b = 3, c = 0;
        System.out.println(getX(a,b,c));
    }
    private static int getX(int a, int b, int c){
        int x = 0;
        for(int bit = 0;  bit < 32; bit++){
            int abit = (a >> bit) & 1;
            int bbit = (b >> bit) & 1;
            int cbit = (c >> bit) & 1;

            if(cbit == 0){
                if(abit == 1 && bbit == 1){
                   return -1;
                }else{
                    x = x + 0;
                }
            }else{
                if(abit == 1 && bbit == 1){
                    x = x + 0;
                }else{
                    x = x + (int)Math.pow(2, bit);
                }
            }
        }
        return x;
    }
}

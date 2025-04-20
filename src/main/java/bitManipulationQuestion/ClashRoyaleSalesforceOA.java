package bitManipulationQuestion;

public class ClashRoyaleSalesforceOA {
    public static void main(String[] args) {

    }
    private static int getGreatestSt(int n){
        int msb = MSB(n);
        return (1 << msb) - 1;
    }
    private static int MSB(int n){
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

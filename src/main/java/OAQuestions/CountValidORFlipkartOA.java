package OAQuestions;

import java.util.Scanner;
import java.util.*;

//`https://www.desiqna.in/16932/flipkart-gwc-oa-2024`
public class CountValidORFlipkartOA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = in.nextInt();
        System.out.println("Possible : "+ getNumberOfX(n));

    }
    private static int getNumberOfX(int n){
        String binary = Integer.toBinaryString(n);
        int count = 0;
        for(int i = 0; i < binary.length(); i++){
            if(binary.charAt(i) == '1'){
                count++;
            }
        }
        return 2 * count;
    }
}

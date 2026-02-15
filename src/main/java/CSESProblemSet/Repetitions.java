package CSESProblemSet;

import java.util.Scanner;
public class Repetitions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int max = 1;
        int count = 1;
        int i = 0;
        int j = 1;
        while(j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                count++;
                j++;
            } else {
                if (count > max) {
                    max = count;
                }
                count = 1;
                i = j;
                j++;
            }
        }
        if (count > max) {
            max = count;
        }
        System.out.println(max);
        in.close();
    }
}
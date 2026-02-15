package CSESProblemSet;

import java.util.Scanner;
public class Missing_Number {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long sum = n * (n + 1) / 2;
        for (int i = 1; i < n; i++) {
            sum -= in.nextLong();
        }
        System.out.println(sum);
        in.close();
    }
}
package CSESProblemSet;

import java.util.Scanner;
public class IncreasingArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long count = 0;
        int currMax = in.nextInt();
        int a;
        for (int i = 1; i < n; i++) {
            a = in.nextInt();
            if (a <= currMax) {
                count += (currMax - a);
            } else {
                currMax = a;
            }
        }
        System.out.println(count);
        in.close();
    }
}
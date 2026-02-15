package CSESProblemSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Permutations {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        if (n < 4 && n != 1) {
            System.out.print("NO SOLUTION");
        } else if (n == 1) {
            System.out.print(1);
        } else {
            int inc = n / 2 + 1;
            int dec = 1;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n / 2; i++) {
                sb.append(inc).append(" ").append(dec).append(" ");
                inc++;
                dec++;
            }
            if (n % 2 != 0) {
                sb.append(n);
            }
            System.out.print(sb.toString());
        }
        in.close();
    }
}
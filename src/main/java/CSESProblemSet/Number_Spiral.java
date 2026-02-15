package CSESProblemSet;

import java.io.BufferedReader;
import java.io.*;

public class Number_Spiral {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            long x = Long.parseLong(input[0]);
            long y = Long.parseLong(input[1]);
            long layer = Math.max(x, y);
            long lastLayerEnd = (layer - 1) * (layer - 1);
            if (layer % 2 == 0) {
                lastLayerEnd += x;
                sb.append(lastLayerEnd + (layer - y)).append("\n");
            } else {
                lastLayerEnd += y;
                sb.append(lastLayerEnd + (layer - x)).append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}
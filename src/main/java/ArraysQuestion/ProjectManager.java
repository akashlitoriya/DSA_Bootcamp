package ArraysQuestion;

import java.util.Scanner;
import java.util.Arrays;
public class ProjectManager {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int pair = in.nextInt();

        int conflict[][] = new int[n][pair];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < pair; j++){
                conflict[i][j] = in.nextInt();
            }
        }

        String exp = in.nextLine();
        String strExp[] = exp.split(" ");
        int arrExp[] = Arrays.stream(strExp).mapToInt(Integer::parseInt).toArray();

    }

}

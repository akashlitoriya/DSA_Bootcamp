package ArraysQuestion;
import java.util.*;
public class UpdateArrayUsingQueries {
    public static int[] solveQueries(int[] A, int[][] B) {
        int Q = B.length;
        int[] ans = new int[Q];
        for (int i = 0; i < Q; i++) {
            int type = B[i][0];
            int l = B[i][1] - 1;
            int r = B[i][2] - 1;

            if (type == 1) {
                int v = B[i][3];
                for (int j = l; j <= r; j++) {
                    A[j] = v;
                }
            } else if (type == 2) {
                int v = B[i][3];
                for (int j = l; j <= r; j++) {
                    A[j] |= v;
                }
            } else if (type == 3) {
                int result = 0;
                for (int j = l; j <= r; j++) {
                    int and = A[j];
                    for(int k = j; k <= r; k++){
                        and  &= A[k];
                        result += and;
                    }

                }
                ans[i] = result;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//
        int[] A = {1,0,2,5};
        int[][] B = {
                { 3,1,3,0},
                {1,1,2,4},
                {2,2,4,5},
                {3,1,4,0}
        };

        int[] ans = solveQueries(A, B);
        for (int a : ans) {
            System.out.println(a);
        }
    }
}








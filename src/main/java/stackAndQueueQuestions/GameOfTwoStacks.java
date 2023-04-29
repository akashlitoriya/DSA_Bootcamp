package stackAndQueueQuestions;

//https://www.hackerrank.com/challenges/game-of-two-stacks/problem

import java.util.Arrays;
import java.util.Scanner;

public class GameOfTwoStacks {
    static int gameOftwo(int maxSum, int a[], int b[]){
        return twoStack(maxSum, a, b, 0, 0) - 1;
    }

    private static int twoStack(int maxSum, int a[], int b[], int sum, int count){
        if(sum > maxSum){
            return count;
        }
        if(a.length == 0 || b.length == 0){
            return count;
        }
        int ans1 = twoStack(maxSum, Arrays.copyOfRange(a,1, a.length), b, sum + a[0], count + 1);
        int ans2 = twoStack(maxSum, a, Arrays.copyOfRange(b, 1, b.length), sum + b[0], count + 1);

        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int a[] = new int[n];
            int b[] = new int[m];
            for(int j = 0; j < n; j++){
                a[j] = in.nextInt();
            }
            for(int k = 0; k < m; k++){
                b[k] = in.nextInt();
            }

            System.out.println(gameOftwo(x,a,b));
        }
    }

}

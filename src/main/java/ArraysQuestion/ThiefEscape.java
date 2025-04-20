package ArraysQuestion;
import java.util.*;
public class ThiefEscape {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String mn = in.nextLine();
//        String mnArr[] = mn.split(" ");
//        int[] bound = Arrays.stream(mnArr).mapToInt(Integer::parseInt).toArray();
//        int fortess[][] = new int[bound[0]][bound[1]];
//        for(int i = 0; i < bound[0]; i++){
//            String row = in.nextLine();
//            String rowArr[] = row.split(" ");
//            for(int j = 0; j < rowArr.length; j++){
//                fortess[i][j] = Integer.parseInt(rowArr[j]);
//            }
//        }
//        System.out.println(getEscapeTime(fortess));
    }
//    private static int getEscapeTime(int fortess[][]){
//        int m = fortess.length;
//        int n= fortess[0].length;
//        int mini = Integer.MAX_VALUE;
//        for(int i = 0; i < fortess.length; i++){
//            for(int j = 0; j < fortess[0].length; j++){
//                if(fortess[i][j] == 1 || (i == 0 && j ==0) || (i == m-1 && j == n - 1) ){
//
//                }else{
//                    fortess[i][j] = 1;
//                    int visited[][] = new int[m][n];
//                    int dp[][] = new int[m][n];
//                    for(int[] row: dp){
//                        Arrays.fill(row, -1);
//                    }
//                    int time = maze(m - 1, n -1, fortess, visited, dp);
//                    if(time >= 2) {
//                        mini = Math.min(mini, time);
//                    }
//                    fortess[i][j] = 0;
//                }
//            }
//        }
//        return mini;
//    }
//    private static int maze(int i, int j, int fortess[][], int [][] visited, int[][] dp){
//        if(i == 0 && j == 0) {
//            return 1;
//        }
//        if(i < 0 || i >= fortess.length){
//            return (int)1e8;
//        }
//        if(j < 0 || j >= fortess[0].length) {
//            return (int)1e8;
//        }
//        visited[i][j] = 1;
//        if(dp[i][j] != -1) return dp[i][j];
//        int top = 0;
//        if(i - 1  >= 0 && visited[i - 1][j] == 0 && fortess[i - 1][j] == 0){
//            top = 1 + maze(i - 1, j, fortess, visited, dp);
//        }
//        int left = 0;
//        if(j - 1 >= 0 && visited[i][j - 1] == 0 && fortess[i][j - 1] == 0){
//            left = 1 + maze(i, j - 1, fortess, visited, dp);
//
//        }
//        int down = 0;
//        if(i + 1 <= fortess.length - 1 && visited[i + 1][j] == 0 && fortess[i+ 1][j] == 0){
//            down = 1 + maze(i + 1, j, fortess, visited, dp);
//
//        }
//        int right = 0;
//        if( j + 1 <= fortess[0].length - 1 && visited[i][j + 1] == 0 && fortess[i][j + 1] == 0){
//            right = 1 + maze(i, j + 1, fortess, visited, dp);
//        }
//        visited[i][j] = 0;
//        //return dp[i][j] = Math.min(top, Math.min(left, Math.min(down, right)));
//    }
}

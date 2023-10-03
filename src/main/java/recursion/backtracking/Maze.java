package recursion.backtracking;

import java.util.*;

public class Maze {
    public static void main(String[] args) {
        //getPath(3,3,"");

        System.out.println("No of paths : " + countTotalPath(3,3));
        //getPathDiagonal(3,3,"");

        boolean[][] maze = {{true,true, true},{true,false, true},{true,true, true}};
        System.out.println(mazeObstacles(0,0,"",maze));
    }
    public static int countTotalPath(int row, int col){
        if(row == 1 || col == 1){
            return 1;
        }
        int down = countTotalPath(row - 1, col);
        int right = countTotalPath(row, col - 1);
        return down + right;
    }
    public static void getPath(int row, int col, String path){
        if(row == 1 && col == 1){
            System.out.println(path);
            return;
        }
        if(row > 1){
            getPath(row - 1, col, path + 'D');
        }
        if(col > 1){
            getPath(row, col - 1, path + 'R');
        }
    }
    public static void getPathDiagonal(int row, int col, String path){
        if(row == 1 && col == 1){
            System.out.println(path);
            return;
        }
        if(row>1){
            getPathDiagonal(row-1, col, path + 'V');
        }
        if(row > 1 && col > 1){
            getPathDiagonal(row - 1, col - 1, path + 'D');
        }
        if(col > 1){
            getPathDiagonal(row, col - 1, path + 'H');
        }
    }
    public static List<String> mazeObstacles(int row, int col, String path, boolean[][] maze){
        if(row == maze.length - 1 && col == maze[0].length - 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(path);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        if(!maze[row][col]){
            ArrayList<String> list = new ArrayList();
            return list;
        }
        if(row < maze.length - 1){
            ans.addAll(mazeObstacles(row + 1, col, path + 'D', maze));
        }
        if(col < maze[0].length - 1){
            ans.addAll(mazeObstacles(row, col + 1, path + 'R', maze));
        }
        return ans;
    }
}

package recursion.backtracking;

import java.util.Arrays;

public class AllPathMaze {
    public static void main(String[] args) {
        boolean[][] maze = {{true,true,true},{true,true,true},{true,true,true}};
        //getAllPath(0,0,maze,"");

        int[][] path = new int[maze.length][maze[0].length];
        printAllPath(0,0,path,"",1);
    }
    public static void getAllPath(int row, int col, boolean[][] maze, String path){
        if(row == maze.length - 1 && col == maze[0].length - 1){
            System.out.println(path);
        }
        if(!maze[row][col]){
            return;
        }
        maze[row][col] = false;
        if(row < maze.length - 1){
            getAllPath(row + 1, col, maze, path + 'D');
        }
        if(col < maze[0].length - 1){
            getAllPath(row, col + 1, maze, path + 'R');
        }
        if(row > 0){
            getAllPath(row - 1, col, maze, path + 'U');
        }
        if(col > 0){
            getAllPath(row, col - 1, maze, path + 'L');
        }
        maze[row][col] = true;
    }

    public static void printAllPath(int row, int col, int[][] maze, String path, int step){
        if(row == maze.length - 1 && col == maze[0].length - 1){
            maze[row][col] = step;
            for(int i = 0; i < maze.length; i++){
                System.out.println(Arrays.toString(maze[i]));
            }
            System.out.println(path);
            System.out.println();
        }
        if(maze[row][col] != 0){
            return;
        }
        maze[row][col] = step;
        if(row < maze.length - 1){
            printAllPath(row + 1, col, maze, path + 'D', step + 1);
        }
        if(col < maze[0].length - 1){
            printAllPath(row, col + 1, maze, path + 'R', step + 1);
        }
        if(row > 0){
            printAllPath(row - 1, col, maze, path + 'U', step + 1);
        }
        if(col > 0){
            printAllPath(row, col - 1, maze, path + 'L', step + 1);
        }
        maze[row][col] = 0;
    }
}

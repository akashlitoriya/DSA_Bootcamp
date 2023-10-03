package recursion.backtracking;

public class NQueen {
    public static void main(String[] args) {
        int n = 5;
        getQueens(new boolean[n][n],0,0);
    }
    public static void getQueens(boolean[][] board, int row, int col){
        if(row == board.length){
            display(board);
            return;
        }
        for(int i = 0; i < board[0].length; i++){
            if(isSafe(board, row, i)){
                board[row][i] = true;
                getQueens(board, row + 1, i);
                board[row][i] = false;
            }
        }
    }
    public static boolean isSafe(boolean[][] board, int row, int col){
        //checking vertical col
        for(int i = row; i >= 0; i--){
            if(board[i][col]){
                return false;
            }
        }
        //left side
        for(int i = 1; i <= Math.min(row,col); i++){
            if(board[row - i][col - i]){
                return false;
            }
        }

        //right side
        for(int i = 1; i <= Math.min(row, board[0].length - col - 1); i++){
            if(board[row - i][col + i]){
                return false;
            }
        }
        return true;
    }
    public static void display(boolean[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j]){
                    System.out.print("Q");
                }else {
                    System.out.print("_");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}

package graphs;

public class NumberOfEnclaves {
    public int numEnclaves(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean visited[][] = new boolean[n][m];
        for(int i = 0; i < n; i++){
            //first col
            if(board[i][0] == 1){
                dfs(i, 0, visited, board);
            }
            //last col
            if(board[i][m-1] == 1){
                dfs(i, m-1, visited, board);
            }
        }

        for(int j = 0; j < m; j++){
            //first row
            if(board[0][j] == 1){
                dfs(0, j, visited, board);
            }
            //last row
            if(board[n-1][j] == 1){
                dfs(n-1, j, visited, board);
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 1 && !visited[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(int i, int j, boolean visited[][], int[][] board){
        visited[i][j] = true;
        int row[] = {-1, 0, 1, 0};
        int col[] = {0, 1, 0, -1};
        for(int k = 0; k < 4; k++){
            if(i + row[k] >= 0 && i + row[k] < board.length && j + col[k] >= 0 && j + col[k] < board[0].length){
                if(board[i + row[k]][j + col[k]] == 1 && !visited[i + row[k]][j + col[k]]){
                    dfs(i + row[k], j + col[k], visited, board);
                }
            }
        }

    }
}

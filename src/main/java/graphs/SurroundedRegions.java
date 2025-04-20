package graphs;

public class SurroundedRegions {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean visited[][] = new boolean[n][m];
        for(int i = 0; i < n; i++){
            //first col
            if(board[i][0] == 'O'){
                dfs(i, 0, visited, board);
            }
            //last col
            if(board[i][m-1] == 'O'){
                dfs(i, m-1, visited, board);
            }
        }

        for(int j = 0; j < m; j++){
            //first row
            if(board[0][j] == 'O'){
                dfs(0, j, visited, board);
            }
            //last row
            if(board[n-1][j] == 'O'){
                dfs(n-1, j, visited, board);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O' && !visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }

    }
    private void dfs(int i, int j, boolean visited[][], char[][] board){
        visited[i][j] = true;
        int row[] = {-1, 0, 1, 0};
        int col[] = {0, 1, 0, -1};
        for(int k = 0; k < 4; k++){
            if(i + row[k] >= 0 && i + row[k] < board.length && j + col[k] >= 0 && j + col[k] < board[0].length){
                if(board[i + row[k]][j + col[k]] == 'O' && !visited[i + row[k]][j + col[k]]){
                    dfs(i + row[k], j + col[k], visited, board);
                }
            }
        }

    }
}

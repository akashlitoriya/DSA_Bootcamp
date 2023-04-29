package ArraysQuestion;
//https://leetcode.com/problems/set-matrix-zeroes/
public class SetMatrixZeros {
    /*
    Brute Force - Approach
    T.C. = O(mxn)*O(m + n)
    S.C. = O(1)
     */
    public void bruteForce(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    setEntireRow(matrix, i, j);
                    setEntireCol(matrix, i, j);
                }
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
    private void setEntireRow(int[][] matrix, int row, int col){
        for(int i = 0; i < matrix[0].length; i++){
            matrix[row][i] = -1;
        }
    }
    private void setEntireCol(int[][] matrix, int row, int col){
        for(int i = 0; i < matrix.length; i++){
            matrix[i][col] = -1;
        }
    }

    /*
    Efficient Approach
    T.C. = O(n x m) + O(n x m)
    S.C. = O(n) + O(m)
     */
    public void efficientApproach(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(row[i] == 1 || col[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /*
    Optimized Approach
    T.C. = O(n x m)
    S.C. = O(1)
     */
    public static void optimizedApproach(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int col0 = 1;
        //Traversing matrix and marking 1st row and col accordingly
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    if(j != 0){
                        matrix[0][j] = 0;
                    }
                    else{
                        col0 = 0;
                    }
                }
            }
        }
        //mark with zero from 1,1 -> n - 1, m - 1
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(matrix[i][j] != 0){
                    if(matrix[i][0] == 0 || matrix[0][j] == 0){
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        //Mark 1st col and then 1st row
        if(matrix[0][0] == 0){
            for(int j = 0; j < m; j++){
                matrix[0][j] = 0;
            }
        }
        if(col0 == 0){
            for(int i = 0; i < n; i++){
                matrix[i][0] = 0;
            }
        }
    }
    public static void print(int matrix[][]){
        for(int i = 0; i < matrix.length; i++){
            System.out.print("[ ");
            for(int j = 0; j < matrix[0].length; j++){
                if(j != matrix[0].length - 1){
                    System.out.print(matrix[i][j] + " , ");
                }else{
                    System.out.print(matrix[i][j]);
                }
            }
            System.out.print(" ]");
            System.out.println();
        }
    }

    public static void main(String args[]){
        int matrix1[][] = {{1,1,1},{1,0,1},{1,1,1}};
        int matrix2[][] = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        optimizedApproach(matrix1);
        optimizedApproach(matrix2);
        System.out.println("Matrix 1  :");
        print(matrix1);
        System.out.println("Matrix 2 : ");
        print(matrix2);
    }
}

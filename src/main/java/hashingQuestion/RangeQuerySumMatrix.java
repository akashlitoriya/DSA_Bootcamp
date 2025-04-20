package hashingQuestion;

public class RangeQuerySumMatrix {
    int prefixSum[][];
    public RangeQuerySumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        this.prefixSum = new int[n][m];
        prefixSum[0][0] = matrix[0][0];
        for(int i = 1; i < m; i++){
            prefixSum[0][i] = matrix[0][i] + prefixSum[0][i-1];
        }
        for(int j = 1; j < n; j++){
            prefixSum[j][0] = matrix[j][0] + prefixSum[j-1][0];
        }
        for(int row = 1; row < n; row++){
            for(int col = 1; col < m; col++){
                prefixSum[row][col] = prefixSum[row-1][col] + prefixSum[row][col-1] - prefixSum[row-1][col-1] + matrix[row][col];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = prefixSum[row2][col2];
        if(row1 >= 1 && col1 >= 1){
            sum -= (prefixSum[row2][col1-1] + prefixSum[row1 - 1][col2]);
            sum += prefixSum[row1-1][col1-1];
        }else if(row1 >= 1){
            sum -= prefixSum[row1-1][col2];
        }else if(col1 >= 1){
            sum -= prefixSum[row2][col1-1];
        }
        return sum;
    }
}


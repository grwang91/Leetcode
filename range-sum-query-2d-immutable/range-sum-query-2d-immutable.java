class NumMatrix {

    int[][] sum;
    public NumMatrix(int[][] matrix) {
        sum = new int[matrix.length][matrix[0].length];
        
        for (int i=0; i<sum.length; i++) {
            int rowSum = 0;
            for (int j=0; j<sum[0].length; j++) {
                rowSum+=matrix[i][j];
                sum[i][j] = rowSum;
                if(i>0)
                    sum[i][j]+=sum[i-1][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int output = sum[row2][col2];
        if(col1 > 0) {
            output-=sum[row2][col1-1];
        }
        if(row1 > 0) {
            output-=sum[row1-1][col2];
        }
        if(row1 > 0 && col1 > 0) {
            output+=sum[row1-1][col1-1];
        }
        return output;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
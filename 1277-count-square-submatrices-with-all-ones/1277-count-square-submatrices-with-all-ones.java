class Solution {
    public int countSquares(int[][] matrix) {
        int ans = -matrix[0][0];
        for(int i=0; i<matrix.length; i++) {
            ans+=matrix[i][0];
        }
        for(int i=0; i<matrix[0].length; i++) {
            ans+=matrix[0][i];
        }
        
        for(int i=1; i<matrix.length; i++) {
            for(int j=1; j<matrix[0].length; j++) {
                if(matrix[i][j] == 1) {
                    matrix[i][j] = Math.min(matrix[i-1][j], Math.min(matrix[i-1][j-1], matrix[i][j-1]))+1;
                }
                ans+=matrix[i][j];
            }
        }
        return ans;
    }

}
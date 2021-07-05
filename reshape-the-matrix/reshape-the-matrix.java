class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        
        if(m*n != r*c)
            return mat;
        
        int[][] output = new int[r][c];
        
        for (int i=0; i<r*c; i++) {
            int a = i/n;
            int b = i%n;
            int d = i/c;
            int e = i%c;
            output[d][e] = mat[a][b];
        }
        
        return output;
        
    }
}
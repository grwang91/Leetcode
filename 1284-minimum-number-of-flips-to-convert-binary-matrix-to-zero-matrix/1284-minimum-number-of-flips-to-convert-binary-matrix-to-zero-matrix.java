class Solution {
    int ans = Integer.MAX_VALUE;
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int minFlips(int[][] mat) {
        int ones = 0;
        for (int i=0; i<mat.length; i++) {
            for (int j=0; j<mat[0].length; j++) {
                if(mat[i][j]==1) ones++;
            }
        }
        backTrack(mat, ones, 0, 0);
        
        return ans==Integer.MAX_VALUE? -1 : ans;
    }
    
    private void backTrack(int[][] mat, int ones, int idx, int moves) {
        if(ones == 0) {
            ans = Math.min(ans, moves);
            return;
        }
        if(idx == mat.length*mat[0].length) {
            return;
        }

        int m = mat.length;
        int n = mat[0].length;
        
        for (int i=idx; i<m*n; i++) {
            int row = i/n;
            int col = i%n;
            backTrack(mat, ones, i+1, moves);
            int oneReduced = flip(mat, row, col);
            backTrack(mat, ones-oneReduced, i+1, moves+1);
            flip(mat,row,col);
        }
    }
    
    private int flip(int[][] mat, int row, int col) {
        int reduced = 0;
        if(mat[row][col] == 1) {
            mat[row][col]=0;
            reduced++;
        } else {
            mat[row][col] = 1;
            reduced--;
        }
        
        for (int i=0; i<4; i++) {
            int nRow = row+dir[i][0];
            int nCol = col+dir[i][1];
            
            if(nRow>=0 && nRow<mat.length && nCol>=0 && nCol<mat[0].length) {
                if(mat[nRow][nCol] == 1) {
                    mat[nRow][nCol]=0;
                    reduced++;
                } else {
                    mat[nRow][nCol] = 1;
                    reduced--;
                }
            }
        }
        
        return reduced;
    }
}
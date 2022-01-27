class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] region = new boolean[9][10];
        
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                char c = board[i][j];
                if(c=='.') continue;
                
                if(row[i][c-'0'] || col[j][c-'0'] || region[getRegion(i,j)][c-'0']) {
                    return false;
                }
                
                row[i][c-'0'] = true;
                col[j][c-'0'] = true;
                region[getRegion(i,j)][c-'0'] = true;
            }
        }
        
        return true;
    }
    
    private int getRegion(int i, int j) {
        if(i<3) {
            if(j<3) {
                return 0;
            } else if (j<6) {
                return 1;
            } else {
                return 2;
            }
        } else if (i<6) {
            if(j<3) {
                return 3;
            } else if (j<6) {
                return 4;
            } else {
                return 5;
            }
        } else {
            if(j<3) {
                return 6;
            } else if (j<6) {
                return 7;
            } else {
                return 8;
            }
        }
    }
}
class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] region = new boolean[9][10];
        int cnt = 0;
        
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                char c = board[i][j];
                if(c=='.') {
                    continue;
                }
                cnt++;
                row[i][c-'0'] = true;
                col[j][c-'0'] = true;
                region[getRegion(i,j)][c-'0'] = true;
            }
        }
        
        backTrack(board, row, col, region, cnt);
    }
    
    private boolean backTrack(char[][] board,boolean[][] row, boolean[][] col, boolean[][] region, int cnt) {
        if(cnt == 81) {
            return true;
        }
        
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if(board[i][j]!='.') {
                    continue;
                }
                int regionNum = getRegion(i,j);
                for (int k=1; k<=9; k++) {
                    char c = (char)(k+'0');
                    if(!row[i][c-'0'] && !col[j][c-'0'] && !region[getRegion(i,j)][c-'0']) {
                        board[i][j] = c;
                        row[i][k] = true;
                        col[j][k] = true;
                        region[regionNum][k] = true;
                        boolean isCompleted = backTrack(board, row, col, region, cnt+1);
                        if(isCompleted) {
                            return true;
                        }
                        board[i][j] = '.';
                        row[i][k] = false;
                        col[j][k] = false;
                        region[regionNum][k] = false;
                    }
                }
                return false;
            }
        }
        
        return false;
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
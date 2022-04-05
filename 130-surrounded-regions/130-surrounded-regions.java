class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public void solve(char[][] board) {
        boolean[][] check = new boolean[board.length][board[0].length];
        
        for(int i=0; i<board.length; i++) {
            if(!check[i][0] && board[i][0] == 'O') {
                visit(check, board, i, 0);
            }
            if(!check[i][board[0].length-1] && board[i][board[0].length-1] == 'O') {
                visit(check, board, i, board[0].length-1);
            }
        }
        for(int i=0; i<board[0].length; i++) {
            if(!check[0][i] && board[0][i] == 'O') {
                visit(check, board, 0, i);
            }
            if(!check[board.length-1][i] && board[board.length-1][i] == 'O') {
                visit(check, board, board.length-1, i);
            }
        }
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(!check[i][j] && board[i][j] == 'O') {
                    dfs(check, board, i, j);    
                }
            }
        }
    }
    private void dfs(boolean[][] check, char[][] board, int r, int c) {
        check[r][c] = true;
        board[r][c] = 'X';
        for(int i=0; i<4; i++) {
            int nr = r+dir[i][0];
            int nc = c+dir[i][1];
            
            if(nr>=0 && nr<check.length && nc>=0 && nc<check[0].length && !check[nr][nc] && board[nr][nc] == 'O') {
                check[nr][nc] = true;
                dfs(check, board, nr, nc);
            }
        }
    }
    
    private void visit(boolean[][] check, char[][] board, int r, int c) {
        check[r][c] = true;
        
        for(int i=0; i<4; i++) {
            int nr = r+dir[i][0];
            int nc = c+dir[i][1];
            
            if(nr>=0 && nr<check.length && nc>=0 && nc<check[0].length && !check[nr][nc] && board[nr][nc] == 'O') {
                check[nr][nc] = true;
                visit(check, board, nr, nc);
            }
        }
    }
}
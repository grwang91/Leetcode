class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int getFood(char[][] grid) {
        Queue<Roc> q = new LinkedList<>();
        boolean[][] check = new boolean[grid.length][grid[0].length];
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]=='*') {
                    q.add(new Roc(i,j,0));
                    check[i][j] = true;
                }
            }
        }
        
        while(!q.isEmpty()) {
            Roc cur = q.poll();
            
            if(grid[cur.row][cur.col] == '#') {
                return cur.dist;
            }
            
            for(int i=0; i<4; i++) {
                int nr = cur.row+dir[i][0];
                int nc = cur.col+dir[i][1];
                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && !check[nr][nc] && grid[nr][nc] != 'X') {
                    check[nr][nc] = true;
                    q.add(new Roc(nr,nc,cur.dist+1));
                }
            }
        }
        
        return -1;
    }
    
    class Roc {
        int row;
        int col;
        int dist;
        
        public Roc(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
}
class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int shortestDistance(int[][] grid) {
        int[][] distance = new int[grid.length][grid[0].length];
        boolean[][] reached = new boolean[grid.length][grid[0].length];
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                reached[i][j] = true;
            }
        }
        int ans = Integer.MAX_VALUE;
        
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    bfs(grid, i, j, distance, reached);
                }
            }
        }
        
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if(reached[i][j])
                    ans = Math.min(ans,distance[i][j]);
            }
        }
        
        return ans==Integer.MAX_VALUE? -1 : ans;
    }
    
    private void bfs(int[][] grid, int row, int col, int[][] distance, boolean[][] reached) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] check = new boolean[grid.length][grid[0].length];
        q.add(new Node(row,col, 0));
        
        while(!q.isEmpty()) {
            Node current = q.poll();
            distance[current.row][current.col] += current.dist;
            for (int i=0; i<4; i++) {
                int nRow = current.row+dir[i][0];
                int nCol = current.col+dir[i][1];
                if(nRow>=0 && nRow<grid.length && nCol>=0 && nCol<grid[0].length && !check[nRow][nCol] && grid[nRow][nCol] == 0) {
                    q.add(new Node(nRow,nCol, current.dist+1));
                    check[nRow][nCol] = true;
                }
            }
        }
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                reached[i][j] = reached[i][j] && check[i][j];
            }
        }
    }
    
    class Node{
        int row, col, dist;
        
        public Node(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
}
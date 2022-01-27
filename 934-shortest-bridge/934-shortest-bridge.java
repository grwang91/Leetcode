class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean[][] check = new boolean[n][n];
        
        boolean flag = false;
        for(int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if(grid[i][j] == 1 && !check[i][j]) {
                    int val = flag? 2: 1;
                    grid[i][j] = val;
                    check[i][j] = true;
                    flag = true;
                    dfs(grid, i, j, val, check);
                }
            }
        }
        Queue<Node> q = new LinkedList<>();
        int[][] distance = new int[n][n];
        
        for (int[] d : distance) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    q.add(new Node(i,j));
                    distance[i][j] = 0;
                    
                }
                
            }
        }
        
        return bfs(grid, distance, q);
        
    }
    
    private int bfs(int[][] grid, int[][] distance, Queue<Node> q) {
        int n = grid.length;
        
        while(!q.isEmpty()) {
            Node current = q.poll();
            if(grid[current.row][current.col]==2) {
                return distance[current.row][current.col]-1;
            }
            
            for (int i=0; i<4; i++) {
                int nRow = current.row+dir[i][0];
                int nCol = current.col+dir[i][1];
                
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<n && distance[nRow][nCol] > distance[current.row][current.col]+1 && grid[nRow][nCol] != 1) {
                    distance[nRow][nCol] = distance[current.row][current.col]+1;
                    q.add(new Node(nRow,nCol));
                }
            }
        }
        
        return -1;
    }
    
    private void dfs(int[][] grid, int row, int col, int val, boolean[][] check) {
        int n = grid.length;
        for (int i=0; i<4; i++) {
            int nRow = row+dir[i][0];
            int nCol = col+dir[i][1];
            
            if(nRow>=0 && nRow<n && nCol>=0 && nCol<n && !check[nRow][nCol] && grid[nRow][nCol] == 1) {
                check[nRow][nCol] = true;
                grid[nRow][nCol] = val;
                dfs(grid, nRow, nCol, val, check);
            }
        }
    }
    
    class Node {
        int row, col;
        
        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int maxDistance(int[][] grid) {
        int[][] dist = new int[grid.length][grid[0].length];
        for(int i=0; i<dist.length; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    bfs(grid, dist, i, j);
                }
            }
        }
        int ans = -1;
        for(int i=0; i<dist.length; i++) {
            for(int j=0; j<dist.length; j++) {
                if(dist[i][j] != 0 && dist[i][j] != Integer.MAX_VALUE) {
                    ans = Math.max(ans, dist[i][j]);
                }
            }
        }
        return ans;
    }
    
    private void bfs(int[][] grid, int[][] dist, int row, int col) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(row, col, 0));
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(dist[cur.r][cur.c] <= cur.d) continue;
            dist[cur.r][cur.c] = cur.d;
            
            for(int i=0; i<4; i++) {
                int nr = cur.r+dir[i][0];
                int nc = cur.c+dir[i][1];
                
                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid.length && grid[nr][nc] == 0) {
                    q.add(new Node(nr, nc, cur.d+1));
                }
            }
        }
        
    }
    
    class Node {
        int r;
        int c;
        int d;
        
        public Node(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
}
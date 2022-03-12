class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int maxDistance(int[][] grid) {
        int[][] dist = new int[grid.length][grid[0].length];
        for(int i=0; i<dist.length; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        Queue<Node> q = new LinkedList<>();
        boolean[][] check = new boolean[grid.length][grid[0].length];
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    q.add(new Node(i,j,0));
                    check[i][j] = true;
                }
            }
        }
        int ans = 0;
        while(!q.isEmpty()) {
            Node cur = q.poll();
//             if(!check[cur.r][cur.c]) {
//                 ans = Math.max(ans, cur.d);
//             }
//             check[cur.r][cur.c] = true;
            ans = Math.max(ans, cur.d);
            
            for(int i=0; i<4; i++) {
                int nr = cur.r+dir[i][0];
                int nc = cur.c+dir[i][1];
                
                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid.length && grid[nr][nc] == 0 && !check[nr][nc]) {
                    q.add(new Node(nr, nc, cur.d+1));
                    check[nr][nc] = true;
                }
            }
        }
        
        return ans==0? -1: ans;
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
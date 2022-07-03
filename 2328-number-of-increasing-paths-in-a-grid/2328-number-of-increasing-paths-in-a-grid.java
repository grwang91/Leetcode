class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int countPaths(int[][] grid) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2)->grid[n1.r][n1.c]-grid[n2.r][n2.c]);
        int mod = 1000000007;
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                pq.add(new Node(i,j));
            }
        }
        long[][] dp = new long[n][m];
        for(int i=0; i<n; i++) {
            Arrays.fill(dp[i], 1);
        }
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            for(int i=0; i<4; i++) {
                int nr = cur.r+dir[i][0];
                int nc = cur.c+dir[i][1];
                
                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[cur.r][cur.c] < grid[nr][nc]) {
                    dp[nr][nc] = (dp[nr][nc]+dp[cur.r][cur.c])%mod;
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                ans = (ans+(int)dp[i][j])%mod;
            }
        }
        return ans;
        
    }
    
    class Node {
        int r;
        int c;
        
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
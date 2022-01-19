class Solution {
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n+1];
        return permute(n, 1, visited);
    }
    
    private int permute(int n, int idx, boolean[] visited) {
        if(idx > n) {
            return 1;
        }
        int cnt = 0;
        
        for(int i=1; i<=n; i++) {
            if(visited[i]) {
                continue;
            }
            
            if(idx%i==0 || i%idx==0) {
                visited[i] = true;
                cnt+=permute(n, idx+1, visited);
                visited[i] = false;
            }
        }
        return cnt;
    } 
}
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        // Map<Integer, Set<Integer>> map = new HashMap<>();
        boolean[][] map = new boolean[n][n];
        int[] cnts = new int[n];
        int ans = 0;
        
        // for(int i=0; i<n; i++) {
        //     map.put(i, new HashSet<>());
        // }
        
        for(int[] road: roads) {
            int s = road[0];
            int e = road[1];
            
            map[s][e] = true;
            map[e][s] = true;
            cnts[s]++;
            cnts[e]++;
            // map.get(s).add(e);
            // map.get(e).add(s);
        }
        
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int cnt = 0;
                cnt+=cnts[i]+cnts[j];
                
                if(map[i][j]) {
                    cnt--;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}
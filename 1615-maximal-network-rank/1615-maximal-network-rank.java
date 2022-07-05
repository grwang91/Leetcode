class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int ans = 0;
        
        for(int i=0; i<n; i++) {
            map.put(i, new HashSet<>());
        }
        
        for(int[] road: roads) {
            int s = road[0];
            int e = road[1];
            
            map.get(s).add(e);
            map.get(e).add(s);
        }
        
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int cnt = 0;
                cnt+=map.get(i).size()+map.get(j).size();
                
                if(map.get(i).contains(j)) {
                    cnt--;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}
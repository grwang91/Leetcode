class Solution {
    public int edgeScore(int[] edges) {
        Map<Integer, Long> map = new HashMap<>();
        long max = 0;
        int ans = -1;
        for(int i=0; i<edges.length; i++) {
            map.put(edges[i], map.getOrDefault(edges[i],0L)+i);
        }
        
        for(int key: map.keySet()) {
            long score = map.get(key);
            if(score > max) {
                max = score;
                ans = key;
            } else if (score == max) {
                ans = Math.min(ans, key);
            }
        }
        return ans;
    }
}
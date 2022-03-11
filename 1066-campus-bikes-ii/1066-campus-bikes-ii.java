class Solution {
    int[][] memo;
    public int assignBikes(int[][] workers, int[][] bikes) {
        memo = new int[workers.length][(1<<bikes.length)];
        for(int i=0; i<memo.length; i++) {
            Arrays.fill(memo[i],-1);
        }
        
        return backTrack(workers, bikes, 0, 0);
    }
    
    private int backTrack(int[][] workers, int[][] bikes, int idx, int mask) {
        if(idx == workers.length) {
            return 0;
        }
        
        if(memo[idx][mask] != -1) return memo[idx][mask];
        
        int dist = Integer.MAX_VALUE;
        for(int i=0; i<bikes.length; i++) {
            if((mask&(1<<i)) == 0) {
                int curr = distance(workers[idx],bikes[i]) + backTrack(workers, bikes, idx+1, mask|(1<<i));
                dist = Math.min(curr,dist);
            }
        }
        
        memo[idx][mask] = dist;
        return dist;
    }
    
    private int distance(int[] worker, int[] bike) {
        return Math.abs(worker[0]-bike[0])+Math.abs(worker[1]-bike[1]);
    }
}
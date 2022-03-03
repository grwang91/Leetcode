class Solution {
    int ans = Integer.MAX_VALUE;
    public int assignBikes(int[][] workers, int[][] bikes) {
        boolean[] check = new boolean[bikes.length];
        
        backTrack(workers, bikes, check, 0, 0);
        
        return ans;
    }
    
    private void backTrack(int[][] workers, int[][] bikes, boolean[] check, int idx, int dist) {
        if(idx == workers.length) {
            ans = Math.min(ans, dist);
            return;
        }
        
        for(int i=0; i<bikes.length; i++) {
            if(!check[i]) {
                check[i] = true;
                int added = Math.abs(bikes[i][0]-workers[idx][0])+Math.abs(bikes[i][1]-workers[idx][1]);
                backTrack(workers, bikes, check, idx+1, dist+added);
                check[i] = false;
            }
        }
    }
}
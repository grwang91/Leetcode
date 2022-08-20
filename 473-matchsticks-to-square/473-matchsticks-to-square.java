class Solution {
    public boolean makesquare(int[] matchsticks) {
        Arrays.sort(matchsticks);
        int total = 0;
        for(int i=0; i<matchsticks.length; i++) {
            total+=matchsticks[i];
        }
        if(total%4 != 0) return false;
        int[] sum = new int[4];
        return backTrack(matchsticks, matchsticks.length-1, sum, total/4);
    }
    
    private boolean backTrack(int[] matchsticks, int idx, int[] sum, int target) {
        if(idx == -1) {
            for(int i=0; i<3; i++) {
                if(sum[i] != sum[i+1]) return false;
            }
            return true;
        }
        
        for(int i=0; i<4; i++) {
            if(sum[i] > target) return false;
        }
        
        for(int i=0; i<4; i++) {
            sum[i]+=matchsticks[idx];
            if(backTrack(matchsticks, idx-1, sum, target)) return true;
            sum[i]-=matchsticks[idx];
        }
        
        return false;
    }
}
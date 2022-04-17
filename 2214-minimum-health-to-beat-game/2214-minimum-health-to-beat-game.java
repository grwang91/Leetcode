class Solution {
    public long minimumHealth(int[] damage, int armor) {
        long ans = 1;
        int max = 0;
        
        for(int i=0; i<damage.length; i++) {
            ans+=damage[i];
            max = Math.max(max, damage[i]);
        }
        
        ans-=max;
        ans+=Math.max(0,max-armor);
        
        return ans;
    }
}
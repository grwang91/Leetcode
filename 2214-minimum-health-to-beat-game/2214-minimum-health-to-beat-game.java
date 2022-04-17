class Solution {
    public long minimumHealth(int[] damage, int armor) {
        long ans = 1;
        Arrays.sort(damage);
        for(int i=0; i<damage.length-1; i++) {
            ans+=damage[i];
        }
        
        ans+=Math.max(0, damage[damage.length-1]-armor);
        
        return ans;
    }
}
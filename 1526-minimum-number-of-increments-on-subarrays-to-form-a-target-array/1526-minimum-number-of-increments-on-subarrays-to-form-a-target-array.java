class Solution {
    public int minNumberOperations(int[] target) {
        int pre = 0;
        int ans = 0;
        
        for(int i=0; i<target.length; i++) {
            ans+=Math.max(0, target[i]-pre);
            pre = target[i];
        }
        return ans;
    }
}
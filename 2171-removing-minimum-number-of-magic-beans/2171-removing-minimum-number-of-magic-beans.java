class Solution {
    public long minimumRemoval(int[] beans) {
        long ans = Long.MAX_VALUE;
        Arrays.sort(beans);
        long sum = 0;
        for(int i=0; i<beans.length; i++) {
            sum+=(long)beans[i];
        }
        
        long curSum = 0;
        long erase = 0;
        for(int i=0; i<beans.length; i++) {
            curSum+=(long)beans[i];
            ans = Math.min(ans,erase+sum-curSum-(long)beans[i]*(beans.length-1-i));
            erase+=beans[i];
        }
        return ans;
    }
}
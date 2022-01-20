class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int ans = Integer.MAX_VALUE;
        int l = 1, r = 1000000001;
        
        while(l<r) {
            int m = (l+r)/2;
            int cnt = 0;
            for (int pile : piles) {
                cnt+=pile%m==0? pile/m : pile/m+1;
            }
            
            if(cnt > h) {
                l=m+1;
            } else {
                r = m;
                ans = Math.min(ans, m);
            }
        }
        return ans;
    }
}
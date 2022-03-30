class Solution {
    public int maxLength(int[] ribbons, int k) {
        int ans = 0;
        int s = 0;
        int e = 0;
        for(int ribbon: ribbons) {
            e = Math.max(e, ribbon+1);
        }
        
        while(s<e) {
            int m = (s+e)/2;
            if(m==0) break;
            int cur = 0;
            for(int ribbon: ribbons) {
                cur+=ribbon/m;
            }
            
            if(cur >= k) {
                s=m+1;
                ans = Math.max(ans, m);
            } else {
                e=m;
            }
        }
        
        return ans;
    }
}
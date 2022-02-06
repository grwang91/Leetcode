class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int s = 0, e = 1000000001;
        int ans = 1000000001;
        
        while(s<e) {
            int mid = (s+e)/2;
            
            int bouquets = countBouquet(bloomDay, mid, k);
            // System.out.println(bouquets + " " +mid);
            if(bouquets >= m) {
                ans = Math.min(ans, mid);
                e = mid;
            } else {
                s = mid+1;
            }
        }
        
        return ans==1000000001? -1 : ans;
    }
    
    private int countBouquet(int[] bloomDay, int mid, int k) {
        int out = 0;
        
        int cnt = 0;
        for (int i=0; i<bloomDay.length; i++) {
            if(bloomDay[i] <= mid) {
                cnt++;
                if(cnt == k) {
                    out++;
                    cnt=0;
                }
            } else {
                cnt = 0;
            }
        }
        return out;
    }
}
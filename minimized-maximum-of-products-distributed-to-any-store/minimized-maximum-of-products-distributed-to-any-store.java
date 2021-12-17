class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int ans = Integer.MAX_VALUE;
        
        int l = 1, r = 0;
        for (int quantity : quantities) {
            r = Math.max(r,quantity);
        }
        
        while(l<r) {
            int m = (l+r)/2;
            int cnt = count(quantities, m);
            
            if(cnt > n) {
                l = m+1;
            } else {
                r = m;
            }
        }
        
        return l;
    }
    
    private int count(int[] quantities, int unit) {
        int cnt = 0;
        for (int quantity : quantities) {
            cnt+=(int)Math.ceil((double)quantity/(double)unit);
        }
        return cnt;
    }
}